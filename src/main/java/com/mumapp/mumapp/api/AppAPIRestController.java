package com.mumapp.mumapp.api;


import com.mumapp.mumapp.user.User;
import com.mumapp.mumapp.user.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

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

    @Transactional
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable long id) {
        userService.deleteUserById(id);
        return "User deleted";
    }

    @PutMapping("/user/{id}")  //    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable long id, @RequestBody User updatedUser) {

        userRepository.findById(id).getId(); //Returns with 404 if not found in database

        updatedUser.setId(id);
        userRepository.save(updatedUser);
        return updatedUser;
    }



    /*
    @GetMapping("/user/{id}/city")
    public Set<City> getUserCity(@PathVariable long id) {
        return (Set<City>) userRepository.findById(id).getCitySet();
    }

    @GetMapping("user/{id}/music")
    public Set<Music> getUserMusic(@PathVariable long id) {
        return (Set<Music>) userRepository.findById(id).getMusicSet();
    }
    */







}
