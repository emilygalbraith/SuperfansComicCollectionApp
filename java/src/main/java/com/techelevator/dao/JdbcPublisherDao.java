package com.techelevator.dao;

import com.techelevator.model.Collection;
import com.techelevator.model.Publisher;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPublisherDao implements PublisherDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcPublisherDao(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    @Override
    public List<Publisher> listAllPublishers() {
        List<Publisher> publisherList = new ArrayList<>();
        String sql = "SELECT * FROM publishers";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while(result.next()) {
            publisherList.add(mapRowToPublisher(result));
        }
        return publisherList;
    }

    @Override
    public Publisher getPublisherByName(String publisherName) {
        String sql = "SELECT * FROM publishers WHERE publisher_name = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, publisherName);
        if(result.next()) {
            return mapRowToPublisher(result);
        } else {
            Publisher publisher = new Publisher();
            return  publisher;
        }
    }

    @Override
    public Publisher createPublisher(Publisher publisher) {
        String publisherName = publisher.getPublisherName();
        String sql = "INSERT INTO publishers (publisher_name) VALUES (?) RETURNING publisher_id";
        int publisherId = jdbcTemplate.queryForObject(sql, Integer.class, publisherName);
        publisher.setPublisherId(publisherId);
        return publisher;
    }

    @Override
    public Publisher getPublisherById(int publisherId) {
        String sql = "SELECT * FROM publishers WHERE publisher_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, publisherId);
        if(result.next()) {
            return mapRowToPublisher(result);
        } else {
            throw new RuntimeException("publisherId "+publisherId+" was not found.");
        }
    }

    private Publisher mapRowToPublisher(SqlRowSet rs) {
        Publisher publisher = new Publisher();
        publisher.setPublisherId(rs.getInt("publisher_id"));
        publisher.setPublisherName(rs.getString("publisher_name"));
        return publisher;
    }
}
