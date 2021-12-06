package com.techelevator.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class Comic {

    @NotNull(message = "A comic id is required.")
    private int comicId;
    @NotBlank(message = "You must enter a comic name.")
    private String comicName;
    @NotBlank(message = "You must enter an author name.")
    private String author;
    private String imgUrl;
    @NotBlank(message = "You must enter a release date.")
    private String releaseDate;
    @NotNull(message = "A publisher id is required.")
    private int publisherId;
    @NotNull(message = "A series id is required.")
    private int seriesId;

    public int getComicId() {
        return comicId;
    }

    public void setComicId(int comicId) {
        this.comicId = comicId;
    }

    public String getComicName() {
        return comicName;
    }

    public void setComicName(String comicName) {
        this.comicName = comicName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImgUrl() { return imgUrl; }
    public void setImgUrl(String imgUrl) { this.imgUrl = imgUrl; }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public int getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(int seriesId) {
        this.seriesId = seriesId;
    }
}
