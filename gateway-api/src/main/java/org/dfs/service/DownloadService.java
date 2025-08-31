package org.dfs.service;

import org.dfs.dto.ChunkMetadataDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.FileNotFoundException;

@Service
public class DownloadService {

    private final RestTemplate restTemplate;

    public DownloadService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public StreamingResponseBody streamFile(String fileId) {
        return outputStream -> {

            String masterUrl = String.format("http://dfs-master-node:8081/files/%s/chunks", fileId);
            ChunkMetadataDTO[] chunkMetadataArray = restTemplate.getForObject(masterUrl, ChunkMetadataDTO[].class);

            if (chunkMetadataArray == null || chunkMetadataArray.length == 0) {
                throw new FileNotFoundException("File not found or has no chunks.");
            }

            for (ChunkMetadataDTO chunkMetadata : chunkMetadataArray) {
                byte[] chunkData = null;
                try {
                    String primaryUrl = String.format("http://%s/chunks/%s",
                            chunkMetadata.getFileNodeAddress(),
                            chunkMetadata.getChunkId());
                    chunkData = restTemplate.getForObject(primaryUrl, byte[].class);
                } catch (Exception e) {
                    String replicaUrl = String.format("http://%s/chunks/%s",
                            chunkMetadata.getReplicaNodeAddress(),
                            chunkMetadata.getChunkId());
                    chunkData = restTemplate.getForObject(replicaUrl, byte[].class);
                }
                if (chunkData != null) {
                    outputStream.write(chunkData);
                }
            }
        };
    }
}