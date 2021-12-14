package com.techelevator.controller;

import com.techelevator.model.*;
import com.techelevator.service.ComicCuratorService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
public class SuperfanController {

    private ComicCuratorService comicCuratorService;

    public SuperfanController(ComicCuratorService comicCuratorService) { this.comicCuratorService = comicCuratorService; }

    //Superhero methods

    @RequestMapping(path = "superheroes", method = RequestMethod.GET)
    public List<Superhero> listAllSuperheroes() { return comicCuratorService.listAllSuperheroes(); }

    //Aggregate statistics
    @RequestMapping(path = "statistics/totalComics", method = RequestMethod.GET)
    public int getTotalComics() { return comicCuratorService.getTotalComics(); }

    @RequestMapping(path = "statistics/publisher", method = RequestMethod.GET)
    public List<PublisherStat> getTotalPublisherStats() { return comicCuratorService.getTotalPublisherStats(); }

    @RequestMapping(path = "statistics/superhero", method = RequestMethod.GET)
    public List<SuperheroStat> getTotalSuperheroStats() { return comicCuratorService.getTotalSuperheroStats(); }

    @RequestMapping(path = "statistics/series", method = RequestMethod.GET)
    public List<SeriesStat> getTotalSeriesStats() { return  comicCuratorService.getTotalSeriesStats(); }

    //User collection statistics
    @RequestMapping(path = "user/collection/{collectionId}/superhero", method = RequestMethod.GET)
    public List<SuperheroStat> getUsersSuperheroStats(@PathVariable int collectionId) {
        return comicCuratorService.getUsersSuperheroStats(collectionId);
    }

    @RequestMapping(path = "user/collection/{collectionId}/publisher", method = RequestMethod.GET)
    public List<PublisherStat> getUserCollectionPublisherStats(@PathVariable int collectionId) {
        return comicCuratorService.getUserCollectionPublisherStats(collectionId);
    }

    @RequestMapping(path = "user/collection/{collectionId}/series", method = RequestMethod.GET)
    public List<SeriesStat> getUserCollectionSeriesStats(@PathVariable int collectionId) {
        return comicCuratorService.getUserCollectionSeriesStats(collectionId);
    }


    //Collections
    @RequestMapping(path = "collections/public", method = RequestMethod.GET)
    public List<Collection> listALlPublicCollections() { return comicCuratorService.listALlPublicCollections(); }

    @RequestMapping(path = "collections", method = RequestMethod.GET)
    public List<Collection> listAllCollections() {
        return comicCuratorService.listAllCollections();
    }

    @RequestMapping(path = "collections/user/{userId}", method = RequestMethod.GET)
    public List<Collection> getCollectionsByUserId(@PathVariable int userId) {
        return comicCuratorService.getCollectionsByUserId(userId);
    }

    @RequestMapping(path = "collections/{collectionId}")
    public Collection getCollectionById(@PathVariable int collectionId) {
        return comicCuratorService.getCollectionById(collectionId);
    }

    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(code = HttpStatus.CREATED)
    @RequestMapping(path = "collections/create", method = RequestMethod.POST)
    public Collection createCollection(@RequestBody Collection collection) {
        return comicCuratorService.createCollection(collection);
    }

    //Added logic in service layer to confirm the collection belongs to the user
    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @RequestMapping(path = "collections/user/{userId}/{collectionId}", method = RequestMethod.DELETE)
    public void deleteCollection(@PathVariable int userId, @PathVariable int collectionId) {
        comicCuratorService.deleteCollection(userId, collectionId);
    }


    //Comics
    @RequestMapping(path = "collections/{collectionId}/comics", method = RequestMethod.GET)
    public List<Comic> listComicsInCollection(@PathVariable int collectionId) {
        return comicCuratorService.listComicsInCollection(collectionId);
    }

    @RequestMapping(path = "comics/publisher/{publisherId}", method = RequestMethod.GET)
    public List<Comic> listComicsByPublisherId(@PathVariable int publisherId) {
        return comicCuratorService.listComicsByPublisherId(publisherId);
    }

    @RequestMapping(path = "comics/series/{seriesId}", method = RequestMethod.GET)
    public List<Comic> listComicsBySeriesId(@PathVariable int seriesId) {
        return comicCuratorService.listComicsBySeriesId(seriesId);
    }

    @RequestMapping(path = "comics/author/{author}", method = RequestMethod.GET)
    public List<Comic> listComicsByAuthor(@PathVariable String author) {
        return comicCuratorService.listComicsByAuthor(author);
    }

    @RequestMapping(path = "comics/{comicId}", method = RequestMethod.GET)
    public Comic getComicById(@PathVariable int comicId) {
        return comicCuratorService.getComicById(comicId);
    }

    @RequestMapping(path = "comics/title/{comicName}", method = RequestMethod.GET)
    public Comic getComicByName(@PathVariable String comicName) {
        return comicCuratorService.getComicByName(comicName);
    }

    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(code = HttpStatus.CREATED)
    @RequestMapping(path = "collections/{collectionId}", method = RequestMethod.POST)
    public Comic addComic(@RequestBody NewComic newComic, @PathVariable int collectionId) {
        return comicCuratorService.addComic(newComic, collectionId);
    }

    // profiles
    @RequestMapping(path = "profiles", method = RequestMethod.GET)
    public List<Profile> listAllProfiles() {
        return comicCuratorService.listAllProfiles();
    }

    @RequestMapping(path = "user/profile", method = RequestMethod.POST)
    public void linkProfileToUser(@RequestBody UserProfile userProfile) {
        comicCuratorService.linkProfileToUser(userProfile);
    }

    @RequestMapping(path = "profiles", method = RequestMethod.POST)
    public Profile createProfile(@RequestBody Profile profile) { return comicCuratorService.createProfile(profile); }

}
