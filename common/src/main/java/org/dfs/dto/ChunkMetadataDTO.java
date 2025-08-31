package org.dfs.dto;

public class ChunkMetadataDTO {
        private String chunkId;
        private int chunkIndex;
        private String fileNodeAddress;
        private String replicaNodeAddress;

    public ChunkMetadataDTO(String chunkId, int chunkIndex, String fileNodeAddress, String replicaNodeAddress) {
        this.chunkId = chunkId;
        this.chunkIndex = chunkIndex;
        this.fileNodeAddress = fileNodeAddress;
        this.replicaNodeAddress = replicaNodeAddress;
    }

    public ChunkMetadataDTO() {
    }

    public String getReplicaNodeAddress() {
        return replicaNodeAddress;
    }

    public void setReplicaNodeAddress(String replicaNodeAddress) {
        this.replicaNodeAddress = replicaNodeAddress;
    }

    public String getChunkId() {
        return chunkId;
    }

    public void setChunkId(String chunkId) {
        this.chunkId = chunkId;
    }

    public int getChunkIndex() {
        return chunkIndex;
    }

    public void setChunkIndex(int chunkIndex) {
        this.chunkIndex = chunkIndex;
    }

    public String getFileNodeAddress() {
        return fileNodeAddress;
    }

    public void setFileNodeAddress(String fileNodeAddress) {
        this.fileNodeAddress = fileNodeAddress;
    }
}
