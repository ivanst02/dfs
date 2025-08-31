package org.dfs.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ChunkMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String chunkId;
    private int chunkIndex;
    private String fileId;
    private String fileNodeAddress;
    private String replicaNodeAddress;

    public String getReplicaNodeAddress() {
        return replicaNodeAddress;
    }

    public void setReplicaNodeAddress(String replicaNodeAddress) {
        this.replicaNodeAddress = replicaNodeAddress;
    }

    public String getChunkId() {
        return chunkId;
    }

    public int getChunkIndex() {
        return chunkIndex;
    }

    public void setChunkIndex(int chunkIndex) {
        this.chunkIndex = chunkIndex;
    }

    public String getFileId() {
        return null;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileNodeAddress() {
        return fileNodeAddress;
    }

    public void setFileNodeAddress(String fileNodeAddress) {
        this.fileNodeAddress = fileNodeAddress;
    }

    public void setChunkId(String chunkId) {
        this.chunkId = chunkId;
    }
}
