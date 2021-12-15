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
    public void linkProfileToUser(UserProfile userProfile) {
        String sql = "SELECT * FROM user_profile WHERE user_id = ?";
        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, userProfile.getUserId());

        if (!row.next()) {
            sql = "INSERT INTO user_profile VALUES (?, ?)";
            jdbcTemplate.update(sql, userProfile.getUserId(), userProfile.getProfileId());
        } else {
            sql = "UPDATE user_profile SET profile_id = ? WHERE user_id = ?";
            jdbcTemplate.update(sql, userProfile.getProfileId(), userProfile.getUserId());
        }

    }

//    @Override
//    public Profile createProfile(Profile profile) {
//        String profileImg = profile.getImgUrl();
//        String profileImgName = profile.getImgName();
//        String sql = "INSERT INTO profiles (profile_img, profile_img_name) VALUES (?, ?, ?) RETURNING profile_id";
//        int profileId = jdbcTemplate.queryForObject(sql, Integer.class, profileImg, profileImgName, userId);
//        profile.setProfileId(profileId);
//        return profile;
//    }

    @Override
    public Profile getProfileByUserId(int userId) {
        String sql = " SELECT * FROM profiles p " +
                " JOIN user_profile up ON p.profile_id = up.profile_id " +
                " WHERE user_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, userId);
        if(result.next()) {
            return mapRowToProfile(result);
        }
//        else {
//            throw new RuntimeException("Profile with the user id, " + userId + ", was not found.");
//        }
        return null;
    }


    private Profile mapRowToProfile(SqlRowSet row) {
        Profile newProfile = new Profile();
        newProfile.setProfileId(row.getInt("profile_id"));
        newProfile.setImgUrl(row.getString("profile_img"));
        newProfile.setImgName(row.getString("profile_img_name"));

        return newProfile;
    }

}
