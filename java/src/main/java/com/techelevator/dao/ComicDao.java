package com.techelevator.dao;

import com.techelevator.model.Comic;

import java.awt.*;
import java.util.List;

public interface ComicDao {

    List<Comic> listComicsByPublisherId(int publisherId);
    List<Comic> listComicsBySeriesId(int seriesId);
    List<Comic> listComicsByAuthor(String author);
    Comic getComicById(int comicId);
    Comic getComicByName(String comicName);
    void addComic(Comic comic, int collectionId);
    List<Comic> listComicsInCollection(int collectionId);


}
