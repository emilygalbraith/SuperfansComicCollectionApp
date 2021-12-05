package com.techelevator.model;

public class Collection {

    private int collectionId;
    private String collectionName;
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
}
