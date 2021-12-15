package com.techelevator.dao;

import com.techelevator.model.Collection;
import com.techelevator.model.Comic;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class JdbcComicDao implements ComicDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcComicDao(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    @Override
    public List<Comic> listAllComics() {
        List<Comic> comicList = new ArrayList<>();
        String sql = "SELECT * FROM comics";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while(result.next()) {
            comicList.add(mapRowToComic(result));
        }
        return comicList;
    }

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
            Comic comic = new Comic();
            return comic;
        }
    }

    @Override
    public Comic addComic(Comic comic, int collectionId) {
        String comicName = comic.getComicName();
        String author = comic.getAuthor();
        String image = comic.getImage();
        Date releaseDate = comic.getReleaseDate();
        int publishedId = comic.getPublisherId();
        int seriesId = comic.getSeriesId();
        int comicId = 0;
        Comic checkComic = new Comic();
        checkComic = getComicByName(comic.getComicName());
        if(checkComic.getComicName() == null) {
            String sql = "INSERT INTO comics VALUES (DEFAULT, ?, ?, ?, ?, ?, ?) RETURNING comic_id";
            comicId = jdbcTemplate.queryForObject(sql, Integer.class, comicName, author, image, releaseDate,
                    publishedId, seriesId);
        } else {
            comicId = checkComic.getComicId();
        }
        String sql2 = "INSERT INTO collection_comic (comic_id, collection_id) VALUES (?, ?)";
        jdbcTemplate.update(sql2, comicId, collectionId);
        comic.setComicId(comicId);
        return comic;
    }

    @Override
    public List<Comic> listComicsInCollection(int collectionId) {
        List<Comic> comicList = new ArrayList<>();
        String sql = "SELECT * FROM comics c" +
                " JOIN collection_comic cc ON c.comic_id = cc.comic_id" +
                " WHERE cc.collection_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, collectionId);
        while (result.next()) {
            Comic comic = mapRowToComic(result);
            comicList.add(comic);
        }
        return comicList;
    }

    private Comic mapRowToComic(SqlRowSet rs) {
        Comic comic = new Comic();
        comic.setComicId(rs.getInt("comic_id"));
        comic.setComicName(rs.getString("comic_name"));
        comic.setAuthor(rs.getString("author"));
        comic.setReleaseDate(rs.getDate("release_date"));
        comic.setPublisherId(rs.getInt("publisher_id"));
        comic.setSeriesId(rs.getInt("series_id"));
        comic.setImage(rs.getString("image"));
        return comic;
    }
}
