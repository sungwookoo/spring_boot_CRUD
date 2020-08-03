package com.n2014958006.main.controller;

import com.n2014958006.main.domain.Basic;
import com.n2014958006.main.domain.Profile;
import com.n2014958006.main.service.BasicService;
import com.n2014958006.main.service.ProfileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class ProfileController {

    private ProfileService profileService;
    private BasicService basicService;

    public ProfileController(ProfileService profileService, BasicService basicService) {
        this.profileService = profileService;
        this.basicService = basicService;
    }

    @GetMapping("/profile/new")
    public String form(Profile profile) {
        return "new";
    }

    @GetMapping("/profile/{idx}")
    public String read(@PathVariable Long idx, Model model) {
        model.addAttribute("profile", profileService.findProfileByIdx(idx));
        return "item";
    }

    @PostMapping("/profile/add")
    public String add(Profile profile, Model model) {
        profile.setCreatedDat(LocalDateTime.now());
        Profile saveProfile = profileService.saveProfile(profile);
        model.addAttribute("profile", profileService.findProfileByIdx(saveProfile.getIdx()));
        return "item";
    }


    @GetMapping("/profile/edit/{idx}")
    public String showUpdateForm(@PathVariable("idx") long idx, Model model) {
        Profile profile = profileService.findProfileByIdx(idx);
        model.addAttribute("profile", profile);
        return "update";
    }

    @PostMapping("/profile/update/{idx}")
    public String updateProfile(@PathVariable("idx") long idx, Profile profile,
                                BindingResult result, Model model) {
        if (result.hasErrors()) {
            profile.setIdx(idx);
            return "update";
        }
        profileService.getCreatedDate(profile);
        profile.setUpdatedDat(LocalDateTime.now());
        profileService.saveProfile(profile);
        List<Basic> basicList = basicService.findBasicList();
        List<Profile> profileList = profileService.findProfileList();
        model.addAttribute("basicList", basicList);
        model.addAttribute("profileList", profileList);
        return "index";
    }

    @GetMapping("/profile/delete/{idx}")
    public String deleteProfile(@PathVariable("idx") long idx, Model model) {
        Profile profile = profileService.findProfileByIdx(idx);
        profileService.deleteProfile(profile);
        List<Basic> basicList = basicService.findBasicList();
        List<Profile> profileList = profileService.findProfileList();
        model.addAttribute("basicList", basicList);
        model.addAttribute("profileList", profileList);
        return "index";
    }
}


