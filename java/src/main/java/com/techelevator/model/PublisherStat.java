package com.techelevator.model;

public class PublisherStat {

    private String publisherName;
    private int occurrences;

    public PublisherStat(String publisherName, int occurrences) {
        this.publisherName = publisherName;
        this.occurrences = occurrences;
    }

    public String getPublisherName() { return publisherName; }
    public void setPublisherName(String publisherName) { this.publisherName = publisherName; }

    public int getOccurrences() { return occurrences; }
    public void setOccurrences(int occurrences) { this.occurrences = occurrences; }
}
