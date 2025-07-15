package org.dfs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

    @RestController
    public class StatusController {

        @GetMapping("/status")
        public String status(){
            return "success";
        }
}
