package com.techelevator.marvelapi;

public class Comics {

    private String available;
    private ComicName[] items;

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public ComicName[] getItems() {
        return items;
    }

    public void setItems(ComicName[] items) {
        this.items = items;
    }
}
