package org.dfs.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class FileMetadata {

    @Id
    private String fileId;
    private String fileName;
    private int total_chunks;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public int getTotal_chunks() {
        return total_chunks;
    }

    public void setTotal_chunks(int total_chunks) {
        this.total_chunks = total_chunks;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
