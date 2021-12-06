package com.techelevator.controller;

import com.techelevator.model.Collection;
import com.techelevator.model.Comic;
import com.techelevator.service.ComicCuratorService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class SuperfanController {

    private ComicCuratorService comicCuratorService;

    public SuperfanController(ComicCuratorService comicCuratorService) { this.comicCuratorService = comicCuratorService; }

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
    @RequestMapping(path = "collections", method = RequestMethod.POST)
    public void createCollection(@RequestBody Collection collection) {
        comicCuratorService.createCollection(collection);
    }

    //TODO should we check to see if authenticated user sending this request matches the user_id belonging to the collection?
    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @RequestMapping(path = "collections", method = RequestMethod.DELETE)
    public void deleteCollection(int collectionId, Principal principal) {
        comicCuratorService.deleteCollection(collectionId);
    }

    @RequestMapping(path = "collections/{collectionId}/comics", method = RequestMethod.GET)
    public List<Comic> listComicsInCollection(@PathVariable int collectionId) {
        return comicCuratorService.listComicsInCollection(collectionId);
    }

    @RequestMapping(path = "comics/{publisherId}", method = RequestMethod.GET)
    public List<Comic> listComicsByPublisherId(@PathVariable int publisherId) {
        return comicCuratorService.listComicsByPublisherId(publisherId);
    }

    @RequestMapping(path = "comics/{seriesId}", method = RequestMethod.GET)
    public List<Comic> listComicsBySeriesId(@PathVariable int seriesId) {
        return comicCuratorService.listComicsBySeriesId(seriesId);
    }

    @RequestMapping(path = "comics/{author}", method = RequestMethod.GET)
    public List<Comic> listComicsByAuthor(@PathVariable String author) {
        return comicCuratorService.listComicsByAuthor(author);
    }

    @RequestMapping(path = "comics/{comicId}", method = RequestMethod.GET)
    public Comic getComicById(@PathVariable int comicId) {
        return comicCuratorService.getComicById(comicId);
    }

    @RequestMapping(path = "comics/{comicName}", method = RequestMethod.GET)
    public Comic getComicByName(@PathVariable String comicName) {
        return comicCuratorService.getComicByName(comicName);
    }

    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(code = HttpStatus.CREATED)
    @RequestMapping(path = "comics", method = RequestMethod.POST)
    public void addComic(@RequestBody Comic comic) {
        comicCuratorService.addComic(comic);
    }


}
