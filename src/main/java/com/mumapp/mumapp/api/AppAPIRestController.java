package com.mumapp.mumapp.api;


import com.mumapp.mumapp.city.City;
import com.mumapp.mumapp.city.CityRepository;
import com.mumapp.mumapp.city.CityService;
import com.mumapp.mumapp.music.Music;
import com.mumapp.mumapp.music.MusicRepository;
import com.mumapp.mumapp.music.MusicService;
import com.mumapp.mumapp.user.User;
import com.mumapp.mumapp.user.UserRepository;
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
    private UserRepository userRepository;

    @Autowired
    private MusicService musicService;
    @Autowired
    private MusicRepository musicRepository;

    @Autowired
    private CityService cityService;
    @Autowired
    private CityRepository cityRepository;


    //**********//
    //   USER   //
    //**********//
    // GET ALL
    @GetMapping("/user/all")
    public Collection<User> getUsers() {
        return userRepository.findAll();
    }

    // POST
    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        userRepository.save(user);
        System.out.println(user.getId());
        return user;
    }

    // GET/DELETE/PUT user/{id}
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable long id) {
        return userRepository.findById(id);
    }

    @PutMapping("/user/{id}")
    public User updateUserById(@PathVariable long id, @RequestBody User updatedUser) {
        userRepository.findById(id).getId(); //Returns with 404 if not found in database
        updatedUser.setId(id);
        userRepository.save(updatedUser);
        return updatedUser;
    }

    @Transactional
    @DeleteMapping("/user/{id}")
    public User deleteUserById(@PathVariable long id) {
        User deletedUser = userRepository.findById(id);
        userRepository.deleteUserMusic(id);
        userRepository.deleteUserCity(id);
        userRepository.deleteUserRole(id);
        userRepository.deleteById(id);
        return deletedUser;
    }

    @GetMapping("/user/{id}/city")
    public Set<City> getUserCity(@PathVariable long id) {
        return (Set<City>) userRepository.findById(id).getCitySet();
    }

    @GetMapping("user/{id}/music")
    public Set<Music> getUserMusic(@PathVariable long id) {
        return (Set<Music>) userRepository.findById(id).getMusicSet();
    }

    //***********//
    //   MUSIC   //
    //***********//

    // GET ALL
    @GetMapping("/music/all/style")
    public Collection<String> getMusicStyle() {
        return musicService.findAll().stream().map(music -> music.getStyleName()).collect(Collectors.toList());
    }

    @GetMapping("/music/all/id")
    public List<Long> getMusicId() {
        return musicService.findAll().stream().map(music -> music.getId()).collect(Collectors.toList());
    }

    // POST
    @PostMapping("/music")
    @ResponseStatus(HttpStatus.CREATED)
    public Music createMusic(@RequestBody Music music) {
        musicService.save(music);
        System.out.println(music.getId());
        return music;
    }

    // GET/DELETE/PUT music/{id}
    @GetMapping("/music/{id}")
    public Optional<Music> getMusicById(@PathVariable long id) {
        return musicService.findById(id);
    }

    @GetMapping("/music/style/{style}")
    public Optional<Music> getMusicByMusicStyle(@PathVariable String style) {
        return musicService.findByStyleName(style);
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
        musicRepository.deleteMusicUser(id);
        musicRepository.deleteMusicMusicCity(id);
        musicRepository.deleteById(id);
        return deletedMusic;
    }

    //***********//
    //   CITY   //
    //***********//

    // GET ALL
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

    // POST
    @PostMapping("/city")
    @ResponseStatus(HttpStatus.CREATED)
    public City createCity(@RequestBody City city) {
        cityService.save(city);
        System.out.println(city.getId());
        return city;
    }

    // GET/DELETE/PUT city/{id}
    @GetMapping("/city/{id}")
    public Optional<City> getCityById(@PathVariable long id) {
        return cityService.findById(id);
    }

    @GetMapping("/city/name/{name}")
    public Optional<City> getCityByName(@PathVariable String name) {
        return cityService.findByCityName(name);
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
        cityRepository.deleteCityUser(id);
        cityRepository.deleteCityMusicCity(id);
        cityRepository.deleteById(id);
        return deletedCity;
    }

    //**********************//
    //   POPULARITY RATES   //
    //**********************//

    @GetMapping("/popularity")
    public Page<Object> getPopularity(Pageable page){
        return musicService.findPopularity(page);
    }

    @GetMapping("/{id}/popularity")
    public Page<Object> getPopularityRateUserId(@PathVariable long id, Pageable page) {
        return musicService.findPopularityRateByUserId(id, page);
    }

//    @GetMapping("/popularity")
//    public List<Object> getPopularity() {
//        return musicService.findPopularity();
//    }

    @GetMapping("/popularity/top")
    public List<Object> getTopPopularity() {
        return musicService.findTopPopularity();
    }

    @GetMapping("/{id}/popularity/top")
    public List<Object> getTopPopularityRateUserId(@PathVariable long id) {
        return musicService.findTopPopularityRateByUserId(id);
    }


//    @GetMapping("/{id}/popularity")
//    public List<Object> getPopularityRateUserId(@PathVariable long id) {
//        return musicService.findPopularityRateByUserId(id);
//    }
}

