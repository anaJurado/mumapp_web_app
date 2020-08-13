package com.mumapp.mumapp.music;

import com.mumapp.mumapp.city.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MusicService {

    @Autowired
    private MusicRepository musicRepository;

    public List<Music> findAll() {
        return musicRepository.findAll();
    }

    public Optional<Music> findByStyleName(String style) {
        return musicRepository.findMusicByStyleName(style);
    }

    public Optional<Music> findById(long id) {
        return musicRepository.findById(id);
    }

    public void save(Music music) {
        musicRepository.save(music);
    }

    @Transactional
    public void deleteMusicById(long id) {
        musicRepository.deleteMusicUser(id);
        musicRepository.deleteMusicMusicCity(id);
        musicRepository.deleteById(id);
    }

    @Transactional
    public void getData(){
        musicRepository.truncateMusicCity();
        musicRepository.crossJoinMusicCity();
        musicRepository.randomData();
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
