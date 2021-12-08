package com.techelevator.model;

import javax.validation.constraints.NotBlank;

import java.util.Date;

public class Comic {

    private int comicId;
    @NotBlank(message = "You must enter a comic name.")
    private String comicName;
    @NotBlank(message = "You must enter an author name.")
    private String author;
    private String image;
    private String releaseDate;
    private int publisherId;
    private int seriesId;
    private int collectionId;

    public int getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    public int getComicId() { return comicId; }
    public void setComicId(int comicId) { this.comicId = comicId; }

    public String getComicName() { return comicName; }
    public void setComicName(String comicName) { this.comicName = comicName; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getImage() { return image; }
    public void setImage(String imgUrl) { this.image = imgUrl; }

    public String getReleaseDate() { return releaseDate; }
    public void setReleaseDate(String releaseDate) { this.releaseDate = releaseDate; }

    public int getPublisherId() { return publisherId; }
    public void setPublisherId(int publisherId) { this.publisherId = publisherId; }

    public int getSeriesId() { return seriesId; }
    public void setSeriesId(int seriesId) { this.seriesId = seriesId; }
}
