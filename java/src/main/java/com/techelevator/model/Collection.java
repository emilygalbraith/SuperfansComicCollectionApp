package com.techelevator.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Collection {

    @NotNull(message = "A collection id is required.")
    private int collectionId;
    @NotBlank(message = "A collection name must be entered.")
    private String collectionName;
    @NotNull(message = "A collection must be set to public or private.")
    private boolean isPrivate;
    @NotNull(message = "A user id is required.")
    private int userId;

    public Collection() { }

    public Collection(int collectionId, String collectionName, int userId) {
        this.collectionId = collectionId;
        this.collectionName = collectionName;
        this.userId = userId;
    }

    public int getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }
}
