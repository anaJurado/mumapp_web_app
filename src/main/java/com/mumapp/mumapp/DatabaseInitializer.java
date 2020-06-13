package com.mumapp.mumapp;

import com.mumapp.mumapp.city.City;
import com.mumapp.mumapp.city.CityRepository;
import com.mumapp.mumapp.music.Music;
import com.mumapp.mumapp.music.MusicRepository;
import com.mumapp.mumapp.user.User;
import com.mumapp.mumapp.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class DatabaseInitializer {

    @Autowired
    private MusicRepository musicRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init() {

        // Sample MUSIC
        musicRepository.save(new Music("rock", "upbeat","guitar"));
        musicRepository.save(new Music("jazz", "upbeat","downbeat","improvisation","trio","quartet"));
        musicRepository.save(new Music("pop", "upbeat","popular"));
        musicRepository.save(new Music("funk", "upbeat","guitar","disco","80's"));
        musicRepository.save(new Music("trap", "vocal","rap"));

        cityRepository.save(new City("madrid", "spain", "europe"));
        cityRepository.save(new City("dublin", "ireland", "europe"));
        cityRepository.save(new City("new york", "usa", "america"));
        cityRepository.save(new City("lisbon", "portugal", "europe"));
        cityRepository.save(new City("tokyo", "japan", "asia"));

        // Sample users

        userRepository.save(new User("admin", "admin", "admin", "admin@mumapp.not", "pass", true));
        userRepository.save(new User("ana", "jurado", "nukyma", "ana@mumapp.not", "12345", false));
    }
}