package org.dfs.service;

import org.dfs.dto.ChunkInfoDTO;
import org.dfs.dto.FileInfoDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

@Service
public class UploadService {

    private static final int CHUNK_SIZE = 1 * 1024 * 1024; // 5MB

    private final RestTemplate restTemplate;

    public UploadService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String handleFileUpload(MultipartFile file) throws IOException {
        byte[] fileBytes = file.getBytes();
        int totalChunks = (int) Math.ceil((double) fileBytes.length / CHUNK_SIZE);
        String fileId = UUID.randomUUID().toString();

        FileInfoDTO fileInfoDTO = new FileInfoDTO(fileId, file.getOriginalFilename(), totalChunks);

        restTemplate.postForEntity("http://master-node:8081/files/register", fileInfoDTO, Void.class);

        for (int i = 0; i < totalChunks; i++) {
            int start = i * CHUNK_SIZE;
            int end = Math.min(fileBytes.length, (i + 1) * CHUNK_SIZE);
            byte[] chunkBytes = Arrays.copyOfRange(fileBytes, start, end);

            String chunkId = UUID.randomUUID().toString();
            ChunkInfoDTO chunkInfoDTO = new ChunkInfoDTO(chunkId, i, fileId);

            ResponseEntity<ChunkInfoDTO> response = restTemplate.postForEntity("http://master-node:8081/chunks/register", chunkInfoDTO, ChunkInfoDTO.class);

            String primaryNodeAddress = response.getBody().getFileNodeAddress();
            String replicaNodeAddress = response.getBody().getReplicaNodeAddress();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            HttpEntity<byte[]> requestEntity = new HttpEntity<>(chunkBytes, headers);

            String primaryUrl = "http://" + primaryNodeAddress + "/chunks/" + chunkId;
            restTemplate.put(primaryUrl, requestEntity);

            String replicaUrl = "http://" + replicaNodeAddress + "/chunks/" + chunkId;
            restTemplate.put(replicaUrl, requestEntity);
        }
        return fileId;
    }
}
