package org.dfs.controller;

import org.dfs.dto.FileInfoDTO;
import org.dfs.model.FileMetadata;
import org.dfs.repository.FileMetadataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/files")
public class MasterController {

    @Autowired
    private FileMetadataRepository fileMetadataRepository;

    @PostMapping("/register")
    public ResponseEntity<Void> registerFile(@RequestBody FileInfoDTO fileInfoDTO) {
        FileMetadata metadata = new FileMetadata();
        metadata.setFileId(fileInfoDTO.getFileId());
        metadata.setFileName(fileInfoDTO.getFileName());
        metadata.setTotalChunks(fileInfoDTO.getTotalChunks());

        fileMetadataRepository.save(metadata);
        return ResponseEntity.ok().build();
    }
}
