package com.mumapp.mumapp.api;


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
import java.util.Set;

@RestController
@RequestMapping("/api/")
public class AppAPIRestController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRepository userService;


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

    @PutMapping("/user/{id}")  //    @PutMapping("/user/{id}")
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







}
