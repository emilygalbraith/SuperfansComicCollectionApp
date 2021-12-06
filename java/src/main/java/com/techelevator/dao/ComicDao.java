package com.techelevator.dao;

import com.techelevator.model.Comic;

import java.util.List;

public interface ComicDao {

    List<Comic> listComicsByCollectionId(int collectionId);
    List<Comic> listComicsByUserId(int userId);
    List<Comic> listComicsByPublisherId(int publisherId);
    List<Comic> listComicsBySeriesId(int seriesId);
    List<Comic> listComicsByAuthor(String author);
    Comic getComicById(int comicId);
    Comic getComicByName(String comicName);

}
