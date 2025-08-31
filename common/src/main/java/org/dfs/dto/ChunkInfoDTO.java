package org.dfs.dto;

public class ChunkInfoDTO {
    private String chunkId;
    private int chunkIndex;
    private String fileId;
    private String fileNodeAddress;
    private String replicaNodeAddress;

    public ChunkInfoDTO(String chunkId, int chunkIndex, String fileId) {
        this.chunkId = chunkId;
        this.chunkIndex = chunkIndex;
        this.fileId = fileId;
    }

    public ChunkInfoDTO(String chunkId, int chunkIndex, String fileId, String fileNodeAddress, String replicaNodeAddress) {
        this.chunkId = chunkId;
        this.chunkIndex = chunkIndex;
        this.fileId = fileId;
        this.fileNodeAddress = fileNodeAddress;
        this.replicaNodeAddress = replicaNodeAddress;
    }

    public ChunkInfoDTO() {}

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

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileNodeAddress() {return fileNodeAddress;}

    public void setFileNodeAddress(String fileNodeAddress) {this.fileNodeAddress = fileNodeAddress;}
}
