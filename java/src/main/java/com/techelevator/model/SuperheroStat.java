package com.techelevator.model;

public class SuperheroStat {

    private String heroName;
    private int occurrences;

    public SuperheroStat(String heroName, int occurrences) {
        this.heroName = heroName;
        this.occurrences = occurrences;
    }

    public String getHeroName() { return heroName; }
    public void setHeroName(String heroName) { this.heroName = heroName; }

    public int getOccurrences() { return occurrences; }
    public void setOccurrences(int occurrences) { this.occurrences = occurrences; }
}
