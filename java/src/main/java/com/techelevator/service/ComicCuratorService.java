package com.techelevator.service;

import com.techelevator.dao.CollectionDao;
import com.techelevator.marvelapi.MarvelApiSeries;
import com.techelevator.marvelapi.SeriesInfo;
import com.techelevator.model.Collection;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ComicCuratorService {

    private static final String BASE_API_URL = "http://gateway.marvel.com/v1/public/";
    private static final String TS = "1";
    private static final String API_KEY = "c3cee22de726a7daa438ad22d9fc55ed";
    private static final String HASH = "799f31a76098f4fff42e1fd282bf7cf8";

    private final RestTemplate restTemplate;

    private CollectionDao collectionDao;

    public ComicCuratorService(CollectionDao collectionDao, RestTemplate restTemplate) {
        this.collectionDao = collectionDao;
        this.restTemplate = restTemplate;
    }

    //TODO Depending on what is better for the front-end I think we will need to add logic in here returning public collections only
    //TODO Maybe add logic that creates a HashMap with key as the collection, and value as a list of comics in that collection to display

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

    /*
    will keep working on pull information from Marvel api and turn into something we can work for in our api
     */
    public SeriesInfo[] listAllMarvelSeries() {
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
}
