package com.mumapp.mumapp.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mumapp.mumapp.city.City;
import com.mumapp.mumapp.music.Music;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.*;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id = Long.valueOf(0);

    private String firstName;
    private String lastName;
    private String name;
    private String email;
    private boolean image;

    @JsonIgnore
    private String passwordHash;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles;

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

    public User(String firstName, String lastName, String name, String email, String password,
                String... roles) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.name = name;
        this.email = email;
        this.passwordHash = new BCryptPasswordEncoder().encode(password);
        this.roles = new ArrayList<>(Arrays.asList(roles));
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

    public String getName() {
        return name;
    }

    public void setName(String userName) {
        this.name = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean hasImage() {
        return image;
    }

    public void setImage(boolean img) {
        this.image = img;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

/*
    public Set<Long> citySetIds{
        get {
            return citySet.toArray().map(city -> city.id);
        }
    }

    public Set<Long> musicSetIds {
        get {
            return musicSet.toArray().map(music -> music.id);
        }
    }
*/

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
