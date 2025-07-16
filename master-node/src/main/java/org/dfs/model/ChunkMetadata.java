package org.dfs.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ChunkMetadata {

    @Id
    private String chunkId;
    private int chunkIndex;
    private String fileId;
    private String fileNodeAddress;

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
        return fileId;
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
}
