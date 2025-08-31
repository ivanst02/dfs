package org.dfs.repository;

import org.dfs.model.ChunkMetadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChunkMetadataRepository extends JpaRepository<ChunkMetadata, String> {
    List<ChunkMetadata> findByFileId(String fileId);
}
