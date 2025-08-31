package org.dfs.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.dfs.dto.ChunkMetadataDTO;
import org.dfs.dto.FileDTO;
import org.dfs.model.ChunkMetadata;
import org.dfs.model.FileMetadata;
import org.dfs.repository.ChunkMetadataRepository;
import org.dfs.repository.FileMetadataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/files")
public class FileController {

    private final ChunkMetadataRepository chunkMetadataRepository;
    private final FileMetadataRepository fileMetadataRepository;

    @Autowired
    public FileController(ChunkMetadataRepository chunkMetadataRepository, FileMetadataRepository fileMetadataRepository) {
        this.chunkMetadataRepository = chunkMetadataRepository;
        this.fileMetadataRepository = fileMetadataRepository;
    }

    @GetMapping("/{fileId}/chunks")
    public List<ChunkMetadataDTO> getFileChunks(@PathVariable String fileId) {

        List<ChunkMetadata> metadataList = chunkMetadataRepository.findByFileId(fileId);

        return metadataList.stream()
                .map(metadata -> new ChunkMetadataDTO(
                        metadata.getChunkId(),
                        metadata.getChunkIndex(),
                        metadata.getFileNodeAddress(),
                        metadata.getReplicaNodeAddress()))
                .collect(Collectors.toList());
    }

    @GetMapping("/files")
    public List<FileDTO> listFiles() {
        List<FileMetadata> metadataList = fileMetadataRepository.findAll();
        return metadataList.stream()
                .map(file -> new FileDTO(file.getFileId(), file.getFileName()))
                .collect(Collectors.toList());
    }
}