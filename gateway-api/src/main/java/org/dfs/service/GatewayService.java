package org.dfs.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class GatewayService {
    public static final int CHUNK_SIZE = 5 * 1024 * 1024;
    private RestTemplate restTemplate;

    public void handleFileUpload(MultipartFile file) throws IOException {
        byte[] fileBytes = file.getBytes();
        int totalChunks = (int) Math.ceil((double) fileBytes.length / CHUNK_SIZE);
        String fileId = UUID.randomUUID().toString();


    }
}
