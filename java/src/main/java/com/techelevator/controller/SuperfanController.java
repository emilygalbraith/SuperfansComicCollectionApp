package com.techelevator.controller;

import com.techelevator.model.Collection;
import com.techelevator.model.Comic;
import com.techelevator.model.NewComic;
import com.techelevator.model.SuperheroStat;
import com.techelevator.service.ComicCuratorService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
public class SuperfanController {

    private ComicCuratorService comicCuratorService;

    public SuperfanController(ComicCuratorService comicCuratorService) { this.comicCuratorService = comicCuratorService; }
    
    @RequestMapping(path = "user/{userId}/superhero", method = RequestMethod.GET)
    public List<SuperheroStat> getUsersSuperheroStats(int userId) { return comicCuratorService.getUsersSuperheroStats(userId); }

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

    @RequestMapping(path = "collections/{collectionName}")
    public Collection getCollectionByName(@PathVariable String collectionName) {
        return comicCuratorService.getCollectionByName(collectionName);
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


}
