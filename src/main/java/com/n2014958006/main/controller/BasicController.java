package com.n2014958006.main.controller;

import com.n2014958006.main.domain.Basic;
import com.n2014958006.main.domain.Profile;
import com.n2014958006.main.service.BasicService;
import com.n2014958006.main.service.ProfileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class BasicController {

    private BasicService basicService;
    private ProfileService profileService;

    public BasicController(BasicService basicService, ProfileService profileService) {
        this.basicService = basicService;
        this.profileService = profileService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Basic> basicList = basicService.findBasicList();
        List<Profile> profileList = profileService.findProfileList();
        model.addAttribute("basicList", basicList);
        model.addAttribute("profileList", profileList);
        return "index";
    }

    @GetMapping("/basic/new")
    public String form(Basic basic) {
        return "new";
    }

    @GetMapping("/basic/{idx}")
    public String read(@PathVariable Long idx, Model model) {
        model.addAttribute("basic", basicService.findBasicByIdx(idx));
        return "item";
    }

    @PostMapping("/basic/add")
    public String add(Basic basic, Model model) {
        basic.setCreatedDat(LocalDateTime.now());
        Basic saveBasic = basicService.saveBasic(basic);
        model.addAttribute("basic", basicService.findBasicByIdx(saveBasic.getIdx()));
        return "item";
    }

    @GetMapping("/basic/edit/{idx}")
    public String showUpdateForm(@PathVariable("idx") long idx, Model model) {
        Basic basic = basicService.findBasicByIdx(idx);
        model.addAttribute("basic", basic);
        return "update";
    }

    @PostMapping("/basic/update/{idx}")
    public String updateBasic(@PathVariable("idx") long idx, @Valid Basic basic,
                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            basic.setIdx(idx);
            return "update";
        }
        basicService.getCreatedDate(basic);
        basic.setUpdatedDat(LocalDateTime.now());
        basicService.saveBasic(basic);
        List<Basic> basicList = basicService.findBasicList();
        List<Profile> profileList = profileService.findProfileList();
        model.addAttribute("basicList", basicList);
        model.addAttribute("profileList", profileList);
        return "index";
    }

    @GetMapping("/basic/delete/{idx}")
    public String deleteBasic(@PathVariable("idx") long idx, Model model) {
        Basic basic = basicService.findBasicByIdx(idx);
        basicService.deleteBasic(basic);
        List<Basic> basicList = basicService.findBasicList();
        List<Profile> profileList = profileService.findProfileList();
        model.addAttribute("basicList", basicList);
        model.addAttribute("profileList", profileList);
        return "index";
    }
}