package org.dfs.controller;

import org.dfs.dto.ChunkInfoDTO;
import org.dfs.model.ChunkMetadata;
import org.dfs.repository.ChunkMetadataRepository;
import org.dfs.service.FileNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chunks")
public class ChunkController {

    @Autowired
    private ChunkMetadataRepository chunkMetadataRepository;

    @Autowired
    private FileNodeService fileNodeService;

    @PostMapping("/register")
    public ResponseEntity<ChunkInfoDTO> registerChunk(@RequestBody ChunkInfoDTO chunkInfoDTO) {
        ChunkMetadata metadata = new ChunkMetadata();
        metadata.setChunkId(chunkInfoDTO.getChunkId());
        metadata.setChunkIndex(chunkInfoDTO.getChunkIndex());
        metadata.setFileId(chunkInfoDTO.getFileId());
        String primaryNodeAddress = fileNodeService.getNextNodeAddress();
        String replicaNodeAddress = fileNodeService.getReplicaNodeAddress(primaryNodeAddress);
        metadata.setFileNodeAddress(primaryNodeAddress);
        metadata.setReplicaNodeAddress(replicaNodeAddress);
        chunkMetadataRepository.save(metadata);

        ChunkInfoDTO responseDto = new ChunkInfoDTO(
                metadata.getChunkId(),
                metadata.getChunkIndex(),
                metadata.getFileId(),
                metadata.getFileNodeAddress(),
                metadata.getReplicaNodeAddress()
        );

        return ResponseEntity.ok(responseDto);
    }
}

