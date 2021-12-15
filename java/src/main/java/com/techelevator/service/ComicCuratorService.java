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
import java.util.Arrays;
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
    private ProfileDao profileDao;

    public ComicCuratorService(CollectionDao collectionDao, ComicDao comicDao, PublisherDao publisherDao,
                               SeriesDao seriesDao, SuperheroDao superheroDao, ProfileDao profileDao) {
        this.collectionDao = collectionDao;
        this.comicDao = comicDao;
        this.publisherDao = publisherDao;
        this.seriesDao = seriesDao;
        this.superheroDao = superheroDao;
        this.profileDao = profileDao;
    }

    //superhero methods
    public List<Superhero> listAllSuperheroes() { return superheroDao.listAllSuperheroes(); }

    //Statistics related methods

    //Aggregate statistics
    public int getTotalComics() {
        int totalComics = 0;
        List<Collection> collectionsList = listAllCollections();
        List<Comic> allComicsList = new ArrayList<>();
        for(Collection collection : collectionsList) {
            List<Comic> collectionComics = listComicsInCollection(collection.getCollectionId());
            for(Comic comic : collectionComics) {
                allComicsList.add(comic);
            }
        }
        totalComics = allComicsList.size();
        return totalComics;
    }

    public List<PublisherStat> getTotalPublisherStats() {
        List<PublisherStat> publisherStatList = new ArrayList<>();
        List<Collection> collectionList = listAllCollections();
        int count = 0;
        for(Collection collection : collectionList) {
            List<PublisherStat> publisherStats = getUserCollectionPublisherStats(collection.getCollectionId());
            for(PublisherStat publisherStat : publisherStats) {
                if(count == 0) {
                    publisherStatList.add(publisherStat);
                }
                if(count > 0) {
                    boolean found = false;
                    for(PublisherStat publisherStat1 : publisherStatList) {
                        if(publisherStat.getPublisherName().equals(publisherStat1.getPublisherName())) {
                            publisherStat1.setOccurrences(publisherStat1.getOccurrences() + 1);
                            found = true;
                            break;
                        }
                    }
                    if(!found) {
                        publisherStatList.add(publisherStat);
                    }
                }
                count++;
            }
        }
        return publisherStatList;
    }

    public List<SuperheroStat> getTotalSuperheroStats() {
        List<SuperheroStat> superheroStatList = new ArrayList<>();
        List<Collection> collectionList = listAllCollections();
        int count = 0;
        for(Collection collection : collectionList) {
            List<SuperheroStat> superheroStats = getUsersSuperheroStats(collection.getCollectionId());
            for(SuperheroStat superheroStat : superheroStats) {
                if(count == 0) {
                    superheroStatList.add(superheroStat);
                }
                if(count > 0) {
                    boolean found = false;
                    for(SuperheroStat superheroStat1 : superheroStatList) {
                        if(superheroStat.getHeroName().equals(superheroStat1.getHeroName())) {
                            superheroStat1.setOccurrences(superheroStat1.getOccurrences() + 1);
                            found = true;
                            break;
                        }
                    }
                    if(!found) {
                        superheroStatList.add(superheroStat);
                    }
                }
                count++;
            }
        }
        return superheroStatList;
    }

    public List<SeriesStat> getTotalSeriesStats() {
        List<SeriesStat> seriesStatList = new ArrayList<>();
        List<Collection> collectionList = listAllCollections();
        int count = 0;
        for(Collection collection : collectionList) {
            List<SeriesStat> seriesStats = getUserCollectionSeriesStats(collection.getCollectionId());
            for(SeriesStat seriesStat : seriesStats) {
                if(count == 0) {
                    seriesStatList.add(seriesStat);
                }
                if(count > 0) {
                    boolean found = false;
                    for(SeriesStat seriesStat1 : seriesStatList) {
                        if(seriesStat.getSeriesName().equals(seriesStat1.getSeriesName())) {
                            seriesStat1.setOccurrences(seriesStat1.getOccurrences() + 1);
                            found = true;
                            break;
                        }
                    }
                    if(!found) {
                        seriesStatList.add(seriesStat);
                    }
                }
                count++;
            }
        }
        return  seriesStatList;
    }


    //User collection statistics
    public List<SuperheroStat> getUsersSuperheroStats(int collectionId) {
        List<SuperheroStat> superheroStatList = new ArrayList<>();
        List<Comic> comicList = listComicsInCollection(collectionId);
        if(comicList.size() == 0) { return superheroStatList; }
        List<Superhero> superheroList = superheroDao.listAllSuperheroesInComic(comicList.get(0).getComicId());
        SuperheroStat firstStat = new SuperheroStat(superheroList.get(0).getSuperheroName(), 1);
        superheroStatList.add(firstStat);
        for(Comic comic : comicList) {
                superheroList = superheroDao.listAllSuperheroesInComic(comic.getComicId());
                int count = 0;
                for(Superhero superhero : superheroList) {
                    boolean found = false;
                    for(SuperheroStat superheroStat : superheroStatList) {
                        if(superhero.getSuperheroName().equals(superheroStat.getHeroName())) {
                            if (count != 0) {
                                superheroStat.setOccurrences(superheroStat.getOccurrences() + 1);
                            }
                            found = true;
                            break;
                        }
                    }
                    if(!found) {
                        SuperheroStat superheroStat1 = new SuperheroStat(superhero.getSuperheroName(), 1);
                        superheroStatList.add(superheroStat1);
                    }
                    count++;
                }
            }
        return superheroStatList;
    }

    public List<PublisherStat> getUserCollectionPublisherStats(int collectionId) {
        List<PublisherStat> publisherStatList = new ArrayList<>();
        List<Comic> comicList = listComicsInCollection(collectionId);
        if(comicList.size() == 0) { return publisherStatList; }
        Publisher currentPublisher = new Publisher();
        currentPublisher = publisherDao.getPublisherById(comicList.get(0).getPublisherId());
        PublisherStat publisherStat = new PublisherStat(currentPublisher.getPublisherName(), 1);
        publisherStatList.add(publisherStat);
        for(Comic comic : comicList) {
            currentPublisher = publisherDao.getPublisherById(comic.getPublisherId());
            boolean found = false;
            for(PublisherStat publisherStat1 : publisherStatList) {
                if(currentPublisher.getPublisherName().equals(publisherStat1.getPublisherName())) {
                    publisherStat.setOccurrences(publisherStat.getOccurrences() + 1);
                    found = true;
                    break;
                }
            }
            if(!found) {
                PublisherStat publisherStat1 = new PublisherStat(currentPublisher.getPublisherName(), 1);
                publisherStatList.add(publisherStat1);
            }

        }
        return publisherStatList;
    }

    public List<SeriesStat> getUserCollectionSeriesStats(int collectionId) {
        List<SeriesStat> seriesStatList = new ArrayList<>();
        List<Comic> comicList = listComicsInCollection(collectionId);
        if(comicList.size() == 0) { return seriesStatList; }
        Series currentSeries = new Series();
        currentSeries = seriesDao.getSeriesById(comicList.get(0).getSeriesId());
        SeriesStat seriesStat = new SeriesStat(currentSeries.getSeriesName(), 1);
        seriesStatList.add(seriesStat);
        for(Comic comic : comicList) {
            currentSeries = seriesDao.getSeriesById(comic.getSeriesId());
            boolean found = false;
            for(SeriesStat seriesStat1 : seriesStatList) {
                if(seriesStat1.getSeriesName().equals(currentSeries.getSeriesName())) {
                    seriesStat1.setOccurrences(seriesStat1.getOccurrences() + 1);
                    found = true;
                    break;
                }
            }
            if(!found) {
                SeriesStat seriesStat1 = new SeriesStat(currentSeries.getSeriesName(), 1);
                seriesStatList.add(seriesStat1);
            }
        }
        return seriesStatList;
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
        comic = comicDao.addComic(comic, collectionId);
        List<String> superheroes = Arrays.asList(newComic.getSuperheroes());
        for(String name : superheroes) {
            Superhero superhero = superheroDao.getSuperheroByName(name);
            if(superhero.getSuperheroName() == null) {
                superhero.setSuperheroName(name);
                superhero = superheroDao.createSuperhero(superhero);
            }
            superheroDao.createComicSuperhero(superhero.getSuperheroId(), comic.getComicId());
        }
        return comic;
    }

    public List<Comic> listComicsInCollection(int collectionId) {
        return comicDao.listComicsInCollection(collectionId);
    }

    // profile related methods
    public List<Profile> listAllProfiles() { return profileDao.listAllProfiles(); }

//    public Profile createProfile(Profile profile) { return profileDao.createProfile(profile); }

    public void linkProfileToUser(UserProfile userProfile) { profileDao.linkProfileToUser(userProfile); }

    public Profile getProfileByUserId(int userId) { return profileDao.getProfileByUserId(userId); }

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
