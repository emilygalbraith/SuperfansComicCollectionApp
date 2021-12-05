package com.techelevator.service;

import com.techelevator.dao.CollectionDao;
import com.techelevator.model.Collection;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComicCuratorService {

    private CollectionDao collectionDao;

    public ComicCuratorService(CollectionDao collectionDao) { this.collectionDao = collectionDao; }

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
}
