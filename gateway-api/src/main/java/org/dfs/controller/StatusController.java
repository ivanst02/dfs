package org.dfs.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StatusController {

    @GetMapping("/status")
    public Map<String, String> status(){
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> response = new HashMap<>();

        response.put("api", "up");
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://dfs-master-node:8081/status", String.class);
        response.put("master_db", responseEntity.getBody());
        responseEntity = restTemplate.getForEntity("http://dfs-file-node:8082/status", String.class);
        response.put("data", responseEntity.getBody());

        return response;
    }
}
