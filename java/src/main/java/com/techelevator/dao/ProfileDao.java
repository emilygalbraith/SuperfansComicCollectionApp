package com.techelevator.dao;

import com.techelevator.model.Profile;
import com.techelevator.model.UserProfile;

import java.util.List;

public interface ProfileDao {

    List<Profile> listAllProfiles();
    void linkProfileToUser(UserProfile userProfile);
    Profile createProfile(Profile profile);
}
