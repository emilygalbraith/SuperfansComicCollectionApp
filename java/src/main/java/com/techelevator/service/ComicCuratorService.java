package com.techelevator.service;

import com.techelevator.dao.CollectionDao;
import com.techelevator.dao.ComicDao;
import com.techelevator.marvelapi.MarvelApiSeries;
import com.techelevator.marvelapi.SeriesInfo;
import com.techelevator.model.Collection;
import com.techelevator.model.Comic;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComicCuratorService {

    private static final String BASE_API_URL = "http://gateway.marvel.com/v1/public/";
    private static final String TS = "1";
    private static final String API_KEY = "c3cee22de726a7daa438ad22d9fc55ed";
    private static final String HASH = "799f31a76098f4fff42e1fd282bf7cf8";

    private final RestTemplate restTemplate =  new RestTemplate();

    private CollectionDao collectionDao;
    private ComicDao comicDao;

    public ComicCuratorService(CollectionDao collectionDao, ComicDao comicDao) {
        this.collectionDao = collectionDao;
        this.comicDao = comicDao;
    }

    //TODO Depending on what is better for the front-end I think we will need to add logic in here returning public collections only
    //TODO Maybe add logic that creates a HashMap with key as the collection, and value as a list of comics in that collection to display


    //Collection related methods
    public List<Collection> listAllCollections() {
        return collectionDao.listAllCollections();
    }

    public List<Collection> getCollectionsByUserId(int userId) {
        return collectionDao.getCollectionsByUserId(userId);
    }

    public Collection getCollectionById(int collectionId) {
        return collectionDao.getCollectionById(collectionId);
    }

    public void createCollection(Collection collection) {
        collectionDao.createCollection(collection);
    }

    public void deleteCollection(int collectionId) {
        collectionDao.deleteCollection(collectionId);
    }


    //Comic related methods
    public List<Comic> listComicsByPublisherId(int publisherId) {
        return comicDao.listComicsByPublisherId(publisherId);
    }

    public List<Comic> listComicsBySeriesId(int seriesId) {
        return comicDao.listComicsBySeriesId(seriesId);
    }

    public List<Comic> listComicsByAuthor(String author) {
        return comicDao.listComicsByAuthor(author);
    }

    public Comic getComicById(int comicId) {
        return comicDao.getComicById(comicId);
    }

    public Comic getComicByName(String comicName) {
        return comicDao.getComicByName(comicName);
    }

    public void addComic(Comic comic) {
        comicDao.addComic(comic);
    }

    public List<Comic> listComicsInCollection(int collectionId) {
        return comicDao.listComicsInCollection(collectionId);
    }

    /*
    will keep working on pull information from Marvel api and turn into something we can work with in our api
     */
    // can be used for method below
    public SeriesInfo[] getAllMarvelSeries() {
        try {
            MarvelApiSeries allSeries = restTemplate.getForObject(BASE_API_URL + "series?ts=" + TS + "&apikey="
            + API_KEY + "&hash=" + HASH, MarvelApiSeries.class);

            if (allSeries != null && allSeries.getData().getResults() != null) {
                return allSeries.getData().getResults();
            }
        } catch (RestClientResponseException ex) {
            System.out.println(ex.getMessage());
        } catch (ResourceAccessException ex) {
            System.out.println(ex.getMessage());
        }

        return new SeriesInfo[] {};
    }

    /*
    for future when we work on series, we can display marvel series on a certain page
    public List<Series> displayMarvelSeries() {

    }
     */
}
