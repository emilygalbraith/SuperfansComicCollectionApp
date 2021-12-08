package com.techelevator.dao;

import com.techelevator.model.Series;

import java.util.List;

public interface SeriesDao {

    List<Series> listAllSeries();
    Series getSeriesByName(String seriesName);
    Series createSeries(Series series);
}
