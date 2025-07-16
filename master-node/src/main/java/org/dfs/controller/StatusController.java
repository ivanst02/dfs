package org.dfs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.HashMap;
import java.util.Map;


@RestController
public class StatusController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/status")
    public Map<String, String> status() {
        Map<String, String> responce = new HashMap<String, String>();
        responce.put("master", "up");
        try {
            jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            responce.put("db", "up");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            responce.put("db", "down");
        }
        return responce;
    }
}