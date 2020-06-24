package com.mumapp.mumapp.api;

import com.mumapp.mumapp.city.CityService;
import com.mumapp.mumapp.city.City;
import com.mumapp.mumapp.user.UserRepository;
import com.mumapp.mumapp.music.MusicService;
import com.mumapp.mumapp.music.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/")
public class AppRestControllers {

    @Autowired
    private MusicService musicService;

    @Autowired
    private CityService cityService;

    @Autowired
    private UserRepository userRepository;



    @GetMapping("/music/style")
    public Collection<String> getMusicStyles() {
        return musicService.findAll().stream().map(music -> music.getStyleName()).collect(Collectors.toList());
    }

    @GetMapping("/music/id")
    public List<Long> getMusicListId() {
        return musicService.findAll().stream().map(music -> music.getId()).collect(Collectors.toList());
    }

    @GetMapping("/city")
    public Collection<String> getCityName() {
        return cityService.findAll().stream().map(city -> city.getCityName()).collect(Collectors.toList());
    }

    @GetMapping("/all/city")
    public List<City> getAllCity(){
        return cityService.findAll();
    }

    @GetMapping("/city/id")
    public List<Long> getCityId() {
        return cityService.findAll().stream().map(city -> city.getId()).collect(Collectors.toList());
    }

    @GetMapping("/{id}/city")
    public Set<City> getUserCity(@PathVariable long id) {
        return (Set<City>) userRepository.findById(id).getCitySet();
    }

    @GetMapping("/{id}/music")
    public Set<Music> getUserMusic(@PathVariable long id) {
        return (Set<Music>) userRepository.findById(id).getMusicSet();
    }

    @GetMapping("/popularity/{musicId}/{cityId}")
    public Integer getPopularityRate(@PathVariable long musicId, @PathVariable long cityId) {
        return musicService.findByMusicIdAndCityId(musicId, cityId);
    }

    @GetMapping("/{id}/popularity")
    public List<Object> getPopularityRateUserId(@PathVariable long id){
        return musicService.findPopularityRateByUserId(id);
    }

    @GetMapping("/{id}/popularity/top")
    public List<Object> getTopPopularityRateUserId(@PathVariable long id){
        return musicService.findTopPopularityRateByUserId(id);
    }

    @GetMapping("/all/popularity/top")
    public List<Object> getTopPopularity(){
        return musicService.findTopPopularity();
    }




}