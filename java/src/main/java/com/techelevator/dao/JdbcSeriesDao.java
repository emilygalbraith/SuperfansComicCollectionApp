package com.techelevator.dao;

import com.techelevator.model.Publisher;
import com.techelevator.model.Series;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcSeriesDao implements SeriesDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcSeriesDao(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    @Override
    public List<Series> listAllSeries() {
        List<Series> seriesList = new ArrayList<>();
        String sql = "SELECT * FROM series";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while(result.next()) {
            seriesList.add(mapRowToSeries(result));
        }
        return seriesList;
    }

    @Override
    public Series getSeriesByName(String seriesName) {
        String sql = "SELECT * FROM series WHERE series_name = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, seriesName);
        if(result.next()) {
            return mapRowToSeries(result);
        } else {
            Series series = new Series();
            return series;
        }
    }

    @Override
    public Series createSeries(Series series) {
        String seriesName = series.getSeriesName();
        String sql = "INSERT INTO series (series_name) VALUES (?) RETURNING series_id";
        int seriesId = jdbcTemplate.queryForObject(sql, Integer.class, seriesName);
        series.setSeriesId(seriesId);
        return series;
    }

    @Override
    public Series getSeriesById(int seriesId) {
        String sql = "SELECT * FROM series WHERE series_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, seriesId);
        if(result.next()) {
            return mapRowToSeries(result);
        } else {
            throw new RuntimeException("publisherId "+seriesId+" was not found.");
        }
    }

    private Series mapRowToSeries(SqlRowSet rs) {
        Series series = new Series();
        series.setSeriesId(rs.getInt("series_id"));
        series.setSeriesName(rs.getString("series_name"));
        return series;
    }
}
