package com.techelevator.model;

public class SeriesStat {

    private String seriesName;
    private int occurrences;

    public SeriesStat(String seriesName, int occurrences) {
        this.seriesName = seriesName;
        this.occurrences = occurrences;
    }

    public String getSeriesName() { return seriesName; }
    public void setSeriesName(String seriesName) { this.seriesName = seriesName; }

    public int getOccurrences() { return occurrences; }
    public void setOccurrences(int occurrences) { this.occurrences = occurrences; }
}
