package org.dfs.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

@RestController
@RequestMapping("/chunks")
public class ChunkController {

    private static final String STORAGE_PATH = "/data/";

    @PutMapping("/{chunkId}")
    public ResponseEntity<Void> storeChunk(@PathVariable String chunkId, @RequestBody byte[] chunkData) throws IOException {
        File file = new File(STORAGE_PATH + chunkId + ".chunk");
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(chunkData);
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{chunkId}")
    public ResponseEntity<byte[]> getChunk(@PathVariable String chunkId) throws IOException {
        File file = new File(STORAGE_PATH + chunkId + ".chunk");

        if (!file.exists()) {
            return ResponseEntity.notFound().build();
        }

        byte[] fileBytes = Files.readAllBytes(file.toPath());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDisposition(ContentDisposition.builder("attachment").filename(chunkId + ".chunk").build());

        return new ResponseEntity<>(fileBytes, headers, HttpStatus.OK);
    }
}
