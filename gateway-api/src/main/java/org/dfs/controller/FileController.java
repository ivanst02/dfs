package org.dfs.controller;

import org.dfs.dto.FileDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/files")
public class FileController {

    private final RestTemplate restTemplate;
    private final String masterNodeAddress = "dfs-master-node:8081";

    @Autowired
    public FileController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public List<FileDTO> listFiles() {
        String masterUrl = String.format("http://%s/files/files", masterNodeAddress);
        FileDTO[] filesArray = restTemplate.getForObject(masterUrl, FileDTO[].class);

        if (filesArray == null) {
            return Collections.emptyList();
        }

        return Arrays.asList(filesArray);
    }
}