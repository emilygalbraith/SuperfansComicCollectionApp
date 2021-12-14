package com.techelevator.dao;

import com.techelevator.model.Profile;
import com.techelevator.model.UserProfile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
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

    @Override
<<<<<<< HEAD
    public void linkProfileToUser(UserProfile userProfile) {
        String sql = "INSERT INTO user_profile VALUES (?, ?)";
        jdbcTemplate.update(sql, userProfile.getUserId(), userProfile.getProfileId());
=======
    public Profile createProfile(Profile profile) {
        String profileImg = profile.getImgUrl();
        String profileImgName = profile.getImgName();
        int userId = profile.getUserId();
        String sql = "INSERT INTO profiles (profile_img, profile_img_name, user_id) VALUES (?, ?, ?) RETURNING profile_id";
        int profileId = jdbcTemplate.queryForObject(sql, Integer.class, profileImg, profileImgName, userId);
        profile.setProfileId(profileId);
        return profile;
>>>>>>> 4071ebcbc9ce79085b0b43723a819b7ba2b4882b
    }

    private Profile mapRowToProfile(SqlRowSet row) {
        Profile newProfile = new Profile();
        newProfile.setProfileId(row.getInt("profile_id"));
        newProfile.setImgUrl(row.getString("profile_img"));
        newProfile.setImgName(row.getString("profile_img_name"));

        return newProfile;
    }
}
