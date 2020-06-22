package com.mumapp.mumapp.api;


import com.mumapp.mumapp.city.CityService;
import com.mumapp.mumapp.music.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/")
public class AppRestControllers {

    @Autowired
    private MusicService musicService;

    @Autowired
    private CityService cityService;

/*    @Autowired
    private  MusicCityService musicCityService;*/


    @GetMapping("/music/style")
    public Collection<String> getMusicStyles() {
        return musicService.findAll().stream().map(music -> music.getStyleName()).collect(Collectors.toList());
    }

    @GetMapping("/music/id")
    public List<Long> getMusicListId() {
        return musicService.findAll().stream().map(music -> music.getId()).collect(Collectors.toList());
    }

/*    @GetMapping("/poprate/{musicId}/{cityId}")
    public Integer getPopularityRate(@PathVariable long musicId, @PathVariable long cityId) {
        return musicCityService.findPopRateByMusicAndCity(musicId, cityId);
    }*/

    @GetMapping("/city")
    public Collection<String> getCityName() {
        return cityService.findAll().stream().map(city -> city.getCityName()).collect(Collectors.toList());
    }

    @GetMapping("/city/id")
    public List<Long> getCityId() {
        return cityService.findAll().stream().map(city -> city.getId()).collect(Collectors.toList());
    }

}
