package com.mumapp.mumapp.user;

import com.mumapp.mumapp.music.Music;
import com.mumapp.mumapp.city.City;
import com.mumapp.mumapp.musiccity.MusicCity;

import javax.persistence.*;
import java.util.*;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id = Long.valueOf(0);

    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private Boolean isAdmin;


    //Uni-directional many-to-many association to music
    @ManyToMany(cascade={CascadeType.ALL})
    @JoinTable(name="user_music",
            joinColumns=@JoinColumn(name="user_id"),
            inverseJoinColumns=@JoinColumn(name="music_id"))
    private Set<Music> musicSet;

    //Uni-directional many-to-many association to city
    @ManyToMany(cascade={CascadeType.ALL})
    @JoinTable(name="user_city",
            joinColumns=@JoinColumn(name="user_id"),
            inverseJoinColumns=@JoinColumn(name="city_id"))
    private Set<City> citySet;


    public User() {}

    public User(String firstName, String lastName, String username, String email, String password,
                Boolean isAdmin) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
        musicSet = new HashSet<>();
        citySet = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Music> getMusicSet() {
        return musicSet;
    }

    public void setMusicSet(Set<Music> musicSet) {
        this.musicSet = musicSet;
    }

    public Set<City> getCitySet() {
        return citySet;
    }

    public void setCitySet(Set<City> citySet) {
        this.citySet = citySet;
    }
}
