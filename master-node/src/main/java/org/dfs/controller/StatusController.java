package org.dfs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.jdbc.core.JdbcTemplate;


@RestController
public class StatusController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/status")
    public String[] status() {
        String[] status = new String[2];
        status[0] = "success";
        try {
            jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            status[1] = "success";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            status[1] = "fail";
        }
        return status;
    }
}