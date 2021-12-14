package com.techelevator.dao;

import com.techelevator.model.Profile;
import com.techelevator.model.UserProfile;

import java.util.List;

public interface ProfileDao {

    List<Profile> listAllProfiles();
<<<<<<< HEAD
    void linkProfileToUser(UserProfile userProfile);
=======
    Profile createProfile(Profile profile);
>>>>>>> 4071ebcbc9ce79085b0b43723a819b7ba2b4882b
}
