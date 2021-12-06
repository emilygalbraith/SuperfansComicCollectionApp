package com.techelevator.dao;

import com.techelevator.model.Collection;
import com.techelevator.model.Comic;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcComicDao implements ComicDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcComicDao(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    @Override
    public List<Comic> listComicsByPublisherId(int publisherId) {
        List<Comic> comicList = new ArrayList<>();
        String sql = "SELECT * FROM comics WHERE publisher_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, publisherId);
        while(result.next()) {
            comicList.add(mapRowToComic(result));
        }
        return comicList;
    }

    @Override
    public List<Comic> listComicsBySeriesId(int seriesId) {
        List<Comic> comicList = new ArrayList<>();
        String sql = "SELECT * FROM comics WHERE series_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, seriesId);
        while(result.next()) {
            comicList.add(mapRowToComic(result));
        }
        return comicList;
    }

    @Override
    public List<Comic> listComicsByAuthor(String author) {
        List<Comic> comicList = new ArrayList<>();
        String sql = "SELECT * FROM comics WHERE author = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, author);
        while(result.next()) {
            comicList.add(mapRowToComic(result));
        }
        return comicList;
    }

    @Override
    public Comic getComicById(int comicId) {
        String sql = "SELECT * FROM comics WHERE comic_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, comicId);
        if(result.next()) {
            return mapRowToComic(result);
        } else {
            throw new RuntimeException("Comic with the id " + comicId + " was not found.");
        }
    }

    @Override
    public Comic getComicByName(String comicName) {
        String sql = "SELECT * FROM comics WHERE comic_name = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, comicName);
        if(result.next()) {
            return mapRowToComic(result);
        } else {
            throw new RuntimeException("Comic named, " + comicName + ", was not found.");
        }
    }

    @Override
    public void addComic(Comic comic) {
        String comicName = comic.getComicName();
        String author = comic.getAuthor();
        String releaseDate = comic.getReleaseDate();
        int publishedId = comic.getPublisherId();
        int seriesId = comic.getSeriesId();
        String sql = "INSERT INTO collections (comic_name, author, release_date, publisher_id, series_id) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, comicName, author, releaseDate, publishedId, seriesId);
    }

    private Comic mapRowToComic(SqlRowSet rs) {
        Comic comic = new Comic();
        comic.setComicId(rs.getInt("comic_id"));
        comic.setComicName(rs.getString("comic_name"));
        comic.setAuthor(rs.getString("author"));
        comic.setReleaseDate(rs.getString("release_date"));
        comic.setPublisherId(rs.getInt("publisher_id"));
        comic.setSeriesId(rs.getInt("series_id"));
        return comic;
    }
}
