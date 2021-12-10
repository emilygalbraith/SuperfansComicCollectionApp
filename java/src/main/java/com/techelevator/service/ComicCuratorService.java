package com.techelevator.service;

import com.techelevator.dao.*;
import com.techelevator.marvelapi.MarvelApiSeries;
import com.techelevator.marvelapi.SeriesInfo;
import com.techelevator.model.*;
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
    private PublisherDao publisherDao;
    private SeriesDao seriesDao;
    private SuperheroDao superheroDao;

    public ComicCuratorService(CollectionDao collectionDao, ComicDao comicDao, PublisherDao publisherDao,
                               SeriesDao seriesDao, SuperheroDao superheroDao) {
        this.collectionDao = collectionDao;
        this.comicDao = comicDao;
        this.publisherDao = publisherDao;
        this.seriesDao = seriesDao;
        this.superheroDao = superheroDao;
    }

    //Statistics related methods
    public List<SuperheroStat> getUsersSuperheroStats(int userId) {
        List<SuperheroStat> superheroStatList = new ArrayList<>();
        List<Collection> usersCollections = collectionDao.getCollectionsByUserId(userId);
        for(Collection collection : usersCollections) {
            List<Comic> comicList = listComicsInCollection(collection.getCollectionId());
            for(Comic comic : comicList) {
                List<Superhero> superheroList = superheroDao.listAllSuperheroesInComic(comic.getComicId());
                for(Superhero superhero : superheroList) {
                    boolean found = false;
                    for(SuperheroStat superheroStat : superheroStatList) {
                        if(superhero.equals(superheroStat.getHeroName())) {
                            superheroStat.setOccurrences(superheroStat.getOccurrences() +  1);
                            found = true;
                            break;
                        }
                        if(!found) {
                            SuperheroStat superheroStat1 = new SuperheroStat(superhero.getSuperheroName(), 1);
                        }
                    }
                }
            }
        }
        return superheroStatList;
    }

    //Collection related methods
    public List<Collection> listALlPublicCollections() {
        return collectionDao.listAllPublicCollections();
    }

    public List<Collection> listAllCollections() {
        return collectionDao.listAllCollections();
    }

    public List<Collection> getCollectionsByUserId(int userId) {
        return collectionDao.getCollectionsByUserId(userId);
    }

    public Collection getCollectionById(int collectionId) {
        return collectionDao.getCollectionById(collectionId);
    }

    public Collection createCollection(Collection collection) {
        return collectionDao.createCollection(collection);
    }

    public void deleteCollection(int userId, int collectionId) {
        List<Collection> collections = collectionDao.getCollectionsByUserId(userId);
        boolean isUsersCollection = false;
        for(Collection collection : collections) {
            if(collection.getUserId() == userId) isUsersCollection = true;
        }
        if(isUsersCollection) {
            collectionDao.deleteCollection(collectionId);
        }
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

    public Comic addComic(NewComic newComic, int collectionId) {
        Comic comic = newComic.getComic();
        Publisher publisher = publisherDao.getPublisherByName(newComic.getPublisher());
        if(publisher.getPublisherName() == null) {
            publisher.setPublisherName(newComic.getPublisher());
            publisher = publisherDao.createPublisher(publisher);
        }
        comic.setPublisherId(publisher.getPublisherId());
        Series series = seriesDao.getSeriesByName(newComic.getSeries());
        if(series.getSeriesName() == null) {
            series.setSeriesName(newComic.getSeries());
            series = seriesDao.createSeries(series);
        }
        comic.setSeriesId(series.getSeriesId());
        return comicDao.addComic(comic, collectionId);
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
