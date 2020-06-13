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

        // MUSIC STYLES (15)

        Music jazz = musicRepository.save(new Music("jazz"));
        Music blues = musicRepository.save(new Music("blues"));
        Music funk = musicRepository.save(new Music("funk"));
        Music soul = musicRepository.save(new Music("soul"));
        Music randb = musicRepository.save(new Music("r&b"));
        Music latin = musicRepository.save(new Music("latin"));
        Music indie = musicRepository.save(new Music("indie"));
        Music pop = musicRepository.save(new Music("pop"));
        Music rock = musicRepository.save(new Music("rock"));
        Music metal = musicRepository.save(new Music("metal"));
        Music punk = musicRepository.save(new Music("punk"));
        Music country = musicRepository.save(new Music("country"));
        Music trap = musicRepository.save(new Music("trap"));
        Music classical = musicRepository.save(new Music("classical"));
        Music tvandfilm = musicRepository.save(new Music("tv&film"));


        // CITITES (25)
        City madrid = cityRepository.save(new City("madrid", "spain", "europe"));
        City barcelona = cityRepository.save(new City("barcelona", "spain", "europe"));
        City rome = cityRepository.save(new City("rome", "italy", "europe"));
        City helsinki = cityRepository.save(new City("helsinki", "finland", "europe"));
        City dublin = cityRepository.save(new City("dublin", "ireland", "europe"));
        City amsterdam = cityRepository.save(new City("amsterdam", "netherlands", "europe"));
        City newyork = cityRepository.save(new City("new york", "usa", "america"));
        City losangeles = cityRepository.save(new City("l.a.", "usa", "america"));
        City vancouver = cityRepository.save(new City("vancouver", "canada", "america"));
        City mexicocity = cityRepository.save(new City("mexico city", "mexico", "america"));
        City buenosaires = cityRepository.save(new City("buenos aires", "argentina", "america"));
        City santiago = cityRepository.save(new City("santiago", "chile", "america"));
        City tokyo = cityRepository.save(new City("tokyo", "japan", "asia"));
        City manila = cityRepository.save(new City("manila", "philippines", "asia"));
        City beijing = cityRepository.save(new City("beijing", "china", "asia"));
        City shanghai = cityRepository.save(new City("shanghai", "china", "asia"));
        City mumbai = cityRepository.save(new City("mumbai", "india", "asia"));
        City nairobi = cityRepository.save(new City("nairobi", "kenya", "africa"));
        City capetown = cityRepository.save(new City("cape town", "south africa", "africa"));
        City cairo = cityRepository.save(new City("cairo", "egypt", "africa"));
        City luanda = cityRepository.save(new City("luanda", "angola", "africa"));
        City tunis = cityRepository.save(new City("tunis", "tunisia", "africa"));
        City sidney = cityRepository.save(new City("sidney", "australia", "oceania"));
        City brisbane = cityRepository.save(new City("brisbane", "australia", "oceania"));
        City wellington = cityRepository.save(new City("wellington", "new zealand", "oceania"));


        // Sample users
        User admin = userRepository.save(new User("admin", "admin", "admin",
                "admin@mumapp.not", "pass", true));
        User ana = userRepository.save(new User("ana", "jurado", "nukyma",
                "ana@mumapp.not", "12345", false));
        User maria = userRepository.save(new User("maria", "crespo", "mimi",
                "mimi@mumapp.not", "54321", false));


        // USER - MUSIC - CITY ANA
        ana.getMusicSet().add(jazz);
        ana.getMusicSet().add(soul);
        ana.getMusicSet().add(funk);
        ana.getMusicSet().add(randb);
        ana.getMusicSet().add(classical);

        ana.getCitySet().add(madrid);
        ana.getCitySet().add(dublin);
        ana.getCitySet().add(newyork);
        ana.getCitySet().add(cairo);
        ana.getCitySet().add(sidney);


        userRepository.save(ana);


        // USER - MUSIC - CITY MARIA

        maria.getMusicSet().add(jazz);
        maria.getMusicSet().add(latin);
        maria.getMusicSet().add(rock);
        maria.getMusicSet().add(metal);
        maria.getMusicSet().add(pop);
        maria.getMusicSet().add(trap);
        maria.getMusicSet().add(punk);
        maria.getMusicSet().add(indie);
        maria.getMusicSet().add(country);
        maria.getMusicSet().add(tvandfilm);

        maria.getCitySet().add(santiago);
        maria.getCitySet().add(buenosaires);
        maria.getCitySet().add(tokyo);
        userRepository.save(maria);

/*
        INSERT INTO music_city (music_id, city_id)
        SELECT music.id as music_id, city.id as city_id
        FROM music CROSS JOIN city;

        UPDATE music_city SET popularity_rate = 100 * RAND() WHERE 1;
*/
    }
}