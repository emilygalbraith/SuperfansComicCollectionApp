package com.techelevator.dao;

import com.techelevator.model.Collection;
import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCollectionDao implements CollectionDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcCollectionDao(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    @Override
    public List<Collection> listAllCollections() {
        List<Collection> allCollections = new ArrayList<>();
        String sql = "SELECT * FROM collections";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while(result.next()) {
            allCollections.add(mapRowToCollection(result));
        }
        return allCollections;
    }

    @Override
    public List<Collection> listAllPublicCollections() {
        List<Collection> allPublicCollections = new ArrayList<>();
        String sql = "SELECT * FROM collections WHERE private = false";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while(result.next()) {
            allPublicCollections.add(mapRowToCollection(result));
        }
        return allPublicCollections;
    }

    @Override
    public List<Collection> getCollectionsByUserId(int userId) {
        List<Collection> userCollectionList = new ArrayList<>();
        String sql = "SELECT * FROM collections WHERE user_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, userId);
        while(result.next()) {
            userCollectionList.add(mapRowToCollection(result));
        }
        return userCollectionList;
    }

    @Override
    public Collection getCollectionByName(String collectionName) {
        String sql = "SELECT * FROM collections WHERE collection_name = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, collectionName);
        if(result.next()) {
            return mapRowToCollection(result);
        } else {
            throw new RuntimeException("Collection with the name " + collectionName + " was not found.");
        }
    }

    @Override
    public Collection createCollection(Collection collection) {
        String collectionName = collection.getCollectionName();
        int userId = collection.getUserId();
        boolean isPrivate = collection.isPrivate();
        String sql = "INSERT INTO collections (collection_name, user_id, private) VALUES (?, ?, ?) RETURNING collection_id";
        int collectionId = jdbcTemplate.queryForObject(sql, Integer.class, collectionName, userId, isPrivate);
        collection.setCollectionId(collectionId);
        return collection;
    }

    @Override
    public void deleteCollection(int collectionId) {
        String sql = "DELETE FROM collections WHERE collection_id = ?";
        jdbcTemplate.update(sql, collectionId);
    }


    private Collection mapRowToCollection(SqlRowSet rs) {
        Collection collection = new Collection();
        collection.setCollectionId(rs.getInt("collection_id"));
        collection.setCollectionName(rs.getString("collection_name"));
        collection.setUserId(rs.getInt("user_id"));
        collection.setPrivate(rs.getBoolean("private"));
        return collection;
    }
}
