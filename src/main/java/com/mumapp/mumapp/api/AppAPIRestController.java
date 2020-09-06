package com.mumapp.mumapp.api;


import com.mumapp.mumapp.city.City;
import com.mumapp.mumapp.city.CityService;
import com.mumapp.mumapp.music.Music;
import com.mumapp.mumapp.music.MusicService;
import com.mumapp.mumapp.user.User;
import com.mumapp.mumapp.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/")
public class AppAPIRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private MusicService musicService;

    @Autowired
    private CityService cityService;


    //**********//
    //   USER   //
    //**********//
    // GET ALL
    @GetMapping("/user/all")
    public Collection<User> getUsers() {
        return userService.findAll();
    }

    // POST
    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        userService.save(user);
        System.out.println(user.getId());
        return user;
    }

    // GET
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable long id) {
        return userService.findById(id);
    }

    // PUT
    // TODO: updatedUser doesnt work properly. I need a DTO class to manage user but I don't know hot to do it
    @PutMapping("/user/{id}")
    public User updateUserById(@PathVariable long id, @RequestBody User updatedUser) {
        userService.findById(id).getId(); //Returns with 404 if not found in database
        updatedUser.setId(id);
        userService.save(updatedUser);
        return updatedUser;
    }

    // DELETE
    @Transactional
    @DeleteMapping("/user/{id}")
    public User deleteUserById(@PathVariable long id) {
        User deletedUser = userService.findById(id);
        userService.deleteUserById(id);
        return deletedUser;
    }

    // GET USER CITY
    @GetMapping("/user/{id}/city")
    public Set<City> getUserCity(@PathVariable long id) {
        return userService.findById(id).getCitySet();
    }

    // GET USER MUSIC
    @GetMapping("user/{id}/music")
    public Set<Music> getUserMusic(@PathVariable long id) {
        return userService.findById(id).getMusicSet();
    }

    //***********//
    //   MUSIC   //
    //***********//

    @GetMapping("/music/all/style")
    public Collection<String> getMusicStyle() {
        return musicService.findAll().stream().map(music -> music.getStyleName()).collect(Collectors.toList());
    }

    @GetMapping("/music/all/id")
    public List<Long> getMusicId() {
        return musicService.findAll().stream().map(music -> music.getId()).collect(Collectors.toList());
    }

    @GetMapping("/music/{id}")
    public Optional<Music> getMusicById(@PathVariable long id) {

        return musicService.findById(id);
    }

    @GetMapping("/music/style/{style}")
    public Optional<Music> getMusicByMusicStyle(@PathVariable String style) {
        return musicService.findByStyleName(style);
    }

    @PostMapping("/music")
    @ResponseStatus(HttpStatus.CREATED)
    public Music createMusic(@RequestBody Music music) {
        musicService.save(music);
        System.out.println(music.getId());
        return music;
    }

    @PutMapping("/music/{id}")
    public Music updateMusicById(@PathVariable long id, @RequestBody Music updatedMusic) {
        musicService.findById(id); //Returns with 404 if not found in database
        updatedMusic.setId(id);
        musicService.save(updatedMusic);
        return updatedMusic;
    }

    @Transactional
    @DeleteMapping("/music/{id}")
    public Optional<Music> deleteMusicById(@PathVariable long id) {
        Optional<Music> deletedMusic = musicService.findById(id);
        musicService.deleteById(id);
        return deletedMusic;
    }

    //***********//
    //   CITY   //
    //***********//

    @GetMapping("/city/all")
    public List<City> getAllCity() {
        return cityService.findAll();
    }

    @GetMapping("/city/all/name")
    public Collection<String> getCityName() {
        return cityService.findAll().stream().map(city -> city.getCityName()).collect(Collectors.toList());
    }

    @GetMapping("/city/all/id")
    public List<Long> getCityId() {
        return cityService.findAll().stream().map(city -> city.getId()).collect(Collectors.toList());
    }

    @GetMapping("/city/{id}")
    public Optional<City> getCityById(@PathVariable long id) {
        return cityService.findById(id);
    }

    @GetMapping("/city/name/{name}")
    public Optional<City> getCityByName(@PathVariable String name) {
        return cityService.findByCityName(name);
    }

    @PostMapping("/city")
    @ResponseStatus(HttpStatus.CREATED)
    public City createCity(@RequestBody City city) {
        cityService.save(city);
        System.out.println(city.getId());
        return city;
    }

    @PutMapping("/city/{id}")
    public City updateCityById(@PathVariable long id, @RequestBody City updatedCity) {
        cityService.findById(id); //Returns with 404 if not found in database
        updatedCity.setId(id);
        cityService.save(updatedCity);
        return updatedCity;
    }

    @Transactional
    @DeleteMapping("/city/{id}")
    public Optional<City> deleteCityById(@PathVariable long id) {
        Optional<City> deletedCity = cityService.findById(id);
        cityService.deleteById(id);
//        cityRepository.deleteCityUser(id);
//        cityRepository.deleteCityMusicCity(id);
//        cityRepository.deleteById(id);
        return deletedCity;
    }

    //**********************//
    //   POPULARITY RATES   //
    //**********************//

    @GetMapping("/world/popularity/pagination")
    public Page<Object> getPopularityPagination(Pageable page) {
        return musicService.findPopularityPagination(page);
    }

    @GetMapping("/{id}/popularity/pagination")
    public Page<Object> getPopularityRateUserIdPagination(@PathVariable long id, Pageable page) {
        return musicService.findPopularityRateByUserIdPagination(id, page);
    }

    @GetMapping("/popularity")
    public List<Object> getPopularity() {
        return musicService.findPopularity();
    }

    @GetMapping("/popularity/top")
    public List<Object> getTopPopularity() {
        return musicService.findTopPopularity();
    }

    @GetMapping("/{id}/popularity/top")
    public List<Object> getTopPopularityRateUserId(@PathVariable long id) {
        return musicService.findTopPopularityRateByUserId(id);
    }

    @GetMapping("/{id}/popularity")
    public List<Object> getPopularityRateUserId(@PathVariable long id) {
        return musicService.findPopularityRateByUserId(id);
    }
}

