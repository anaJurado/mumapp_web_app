package com.mumapp.mumapp.api;


import com.mumapp.mumapp.music.MusicRepository;
import com.mumapp.mumapp.user.User;
import com.mumapp.mumapp.user.UserRepository;
import com.mumapp.mumapp.city.CityService;
import com.mumapp.mumapp.city.City;
import com.mumapp.mumapp.music.MusicService;
import com.mumapp.mumapp.music.Music;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/music/{style}")
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
    public Optional<Music> deleteMusicById(@PathVariable long id){

        Optional<Music> deletedMusic = musicService.findById(id);

        musicRepository.deleteMusicUser(id);
        musicRepository.deleteMusicMusicCity(id);
        musicRepository.deleteById(id);

        return deletedMusic;
    }
}

