package com.mumapp.mumapp.musiccity;
import com.mumapp.mumapp.city.City;
import com.mumapp.mumapp.music.Music;


import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "music_city")
public class MusicCity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id = Long.valueOf(0);

    @Id
    @ManyToOne
    @JoinColumn(name = "music_id")
    private Music music;

    @Id
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name = "popularity_rate")
    private int popularityRate;

    public MusicCity() {
    }

    public MusicCity(Music music, City city, int popularityRate) {
        this.music = music;
        this.city = city;
        this.popularityRate = popularityRate;
    }

    public Music getMusic(){
        return music;
    }

    public void setMusic(Music music){
        this.music = music;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getPopularityRate() {
        return popularityRate;
    }

    public void setPopularityRate(int popularityRate) {
        this.popularityRate = popularityRate;
    }
}
