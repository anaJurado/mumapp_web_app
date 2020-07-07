package com.mumapp.mumapp.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicService {

    @Autowired
    private MusicRepository musicRepository;

    public List<Music> findAll() {

        return musicRepository.findAll();
    }




    public Optional<Music> findById(long id) {
        return musicRepository.findById(id);
    }

    public void save(Music music) {
        musicRepository.save(music);
    }
    public void deleteById(long id) {
        musicRepository.deleteById(id);
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
