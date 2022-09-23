package com.sofka.docs.commands;

import co.com.sofka.domain.generic.Command;

public class CreateDocumentCommand extends Command {

    private String documentId;
    private String userId;
    private String categoryId;
     private Integer version;
    private String pathDocument;
    private String blockChainId;
    private String description;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocumentId() {
        return documentId;
    }

    public String getUserId() {
        return userId;
    }
    public String getCategoryId() {
        return categoryId;
    }

    public Integer getVersion() {
        return version;
    }

    public String getPathDocument() {
        return pathDocument;
    }

    public String getBlockChainId() {
        return blockChainId;
    }

    public String getDescription() {
        return description;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

        public void setVersion(Integer version) {
        this.version = version;
    }

    public void setPathDocument(String pathDocument) {
        this.pathDocument = pathDocument;
    }

    public void setBlockChainId(String blockChainId) {
        this.blockChainId = blockChainId;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
