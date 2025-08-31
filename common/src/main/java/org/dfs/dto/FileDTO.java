package org.dfs.dto;

public class FileDTO {
    private String fileId;
    private String fileName;

    public FileDTO() {}

    public FileDTO(String fileId, String fileName) {
        this.fileId = fileId;
        this.fileName = fileName;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
