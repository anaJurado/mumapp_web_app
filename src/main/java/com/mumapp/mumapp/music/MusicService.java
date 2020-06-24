package com.mumapp.mumapp.music;

import com.mumapp.mumapp.musiccity.MusicCity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService {

    @Autowired
    private MusicRepository musicRepository;


    public List<Music> findAll() {

        return musicRepository.findAll();
    }

    public int findByMusicIdAndCityId(long musicId, long cityId){
        return musicRepository.findByMusicIdAndCityId(musicId, cityId);
    }

    public List<Object> findPopularityRateByUserId(long id) {
        return musicRepository.findPopularityRateByUserId(id);
    }

    public List<Object> findTop5PopularityRateByUserId(long id) {
        return musicRepository.findTop5PopularityRateByUserId(id);
    }

    public List<Object> findTop5Popularity() {
        return musicRepository.findTop5Popularity();
    }

}
