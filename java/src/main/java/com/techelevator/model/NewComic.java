package com.techelevator.model;

public class NewComic {

    private Comic comic;
    private String publisher;
    private String series;
    private String[] superheroes;

    public Comic getComic() { return comic; }
    public void setComic(Comic comic) { this.comic = comic; }

    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }

    public String getSeries() { return series; }
    public void setSeries(String series) { this.series = series; }

    public String[] getSuperheroes() { return superheroes; }
    public void setSuperheroes(String[] superheroes) { this.superheroes = superheroes; }
}
