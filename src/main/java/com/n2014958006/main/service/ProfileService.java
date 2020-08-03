package com.n2014958006.main.service;

import com.n2014958006.main.domain.Profile;
import com.n2014958006.main.repository.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Profile findProfileByIdx(Long idx) {
        return profileRepository.findById(idx).orElse(new Profile());
    }

    public List<Profile> findProfileList() {
        return profileRepository.findAll();
    }

    public Profile saveProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    public void deleteProfile(Profile profile) {
        profileRepository.delete(profile);
    }

    public void getCreatedDate(Profile profile) {
        profile.setCreatedDat(profileRepository.getOne(profile.getIdx()).getCreatedDat());
    }
}

