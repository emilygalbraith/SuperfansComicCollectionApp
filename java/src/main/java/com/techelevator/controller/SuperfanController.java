package com.techelevator.controller;

import com.techelevator.model.Collection;
import com.techelevator.service.ComicCuratorService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SuperfanController {

    private ComicCuratorService comicCuratorService;

    public SuperfanController(ComicCuratorService comicCuratorService) { this.comicCuratorService = comicCuratorService; }

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
    public void deleteCollection(int collectionId) {
        comicCuratorService.deleteCollection(collectionId);
    }
}
