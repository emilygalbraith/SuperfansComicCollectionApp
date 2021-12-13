package com.techelevator.dao;

import com.techelevator.model.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcProfileDao implements ProfileDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcProfileDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<Profile> listAllProfiles() {

        String sql = "SELECT * FROM profiles";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);

        List<Profile> profiles = new ArrayList<>();

        while(rowSet.next()) {
            profiles.add(mapRowToProfile(rowSet));
        }
        return profiles;
    }

    private Profile mapRowToProfile(SqlRowSet row) {
        Profile newProfile = new Profile();
        newProfile.setProfileId(row.getInt("profile_id"));
        newProfile.setImgUrl(row.getString("profile_img"));
        newProfile.setImgName(row.getNString("profile_img_name"));
        newProfile.setUserId(row.getInt("user_id"));

        return newProfile;
    }
}
