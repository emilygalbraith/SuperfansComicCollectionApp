package com.techelevator.dao;

import com.techelevator.model.Profile;

import java.util.List;

public interface ProfileDao {

    List<Profile> listAllProfiles();
    Profile createProfile(Profile profile);
}
