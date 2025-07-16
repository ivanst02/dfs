package org.dfs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

    @RestController
    public class StatusController {

        @GetMapping("/status")
        public Map<String, String> status(){
            Map<String, String> responce = new HashMap<String, String>();
            responce.put("data", "up");
            return responce;
        }
}
