package com.mumapp.mumapp.city;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mumapp.mumapp.musiccity.MusicCity;

import javax.persistence.*;
import java.util.Set;


@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id = Long.valueOf(0);

    private String cityName;
    private String country;
    private String continent;

    @JsonIgnore
    @OneToMany(mappedBy = "city",
               cascade = CascadeType.ALL)
    private Set<MusicCity> musicCitySet;


    public City() {}

    public City(String cityName, String country, String continent) {
        this.cityName = cityName;
        this.country = country;
        this.continent = continent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public Set<MusicCity> getMusicCitySet() {
        return musicCitySet;
    }

    public void setMusicCitySet(Set<MusicCity> musicCitySet) {
        this.musicCitySet = musicCitySet;
    }
}
