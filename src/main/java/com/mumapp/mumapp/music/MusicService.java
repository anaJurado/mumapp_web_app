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

    public List<Object> findTopPopularityRateByUserId(long id) {
        return musicRepository.findTopPopularityRateByUserId(id);
    }

    public List<Object> findTopPopularity() {
        return musicRepository.findTopPopularity();
    }

}
