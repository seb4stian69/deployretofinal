package com.sofka.docdoc.commands;

import co.com.sofka.domain.generic.Command;

import java.time.Instant;
import java.util.Set;

public class CreateDocumentCommand extends Command {

    private String _id;

    private String documentId;
    private String userId;
    private String categoryId;
    private Integer version;
    private String pathDocument;
    private Set<String> blockChainId;
    private String description;
    private String name;
    private String subCategoryName;
    private final Instant dateCreated = Instant.now();

    private final Instant dateUpdated = Instant.now();

    private final Instant lastDateDownload = Instant.now();

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Instant getDateUpdated() {
        return dateUpdated;
    }

    public Instant getDateCreated() {
        return dateCreated;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocumentId() {
        return _id;
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

    public Set<String> getBlockChainId() {
        return blockChainId;
    }

    public String getDescription() {
        return description;
    }

    public void setDocumentId(String documentId) {
        this._id = documentId;
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

    public void setBlockChainId(Set<String> blockChainId) {
        this.blockChainId = blockChainId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getLastDateDownload() {
        return lastDateDownload;
    }
}
