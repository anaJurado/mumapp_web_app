package com.mumapp.mumapp.music;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mumapp.mumapp.musiccity.MusicCity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id = Long.valueOf(0);

    @Column
    private String styleName;

    @JsonIgnore
    @OneToMany(
            mappedBy = "music"
    )
    private Set<MusicCity> musicCitySet;


    public Music() {
    }

    public Music(String styleName) {
        this.styleName = styleName;
        musicCitySet = new HashSet<>();
    }

    public Music(String styleName, Set<MusicCity> musicCitySet) {
        this.styleName = styleName;
        this.musicCitySet = musicCitySet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }

    public Set<MusicCity> getMusicCitySet() {
        return musicCitySet;
    }

    public void setMusicCitySet(Set<MusicCity> musicCitySet) {
        this.musicCitySet = musicCitySet;
    }
}
