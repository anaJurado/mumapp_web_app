package com.mumapp.mumapp.music;

import com.mumapp.mumapp.musiccity.MusicCity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MusicRepository extends JpaRepository<Music, Long> {
    @Query( value = "SELECT popularity_rate FROM music_city WHERE music_id = ?1 AND city_id = ?2",
            nativeQuery = true)
    int findByMusicIdAndCityId(long musicId, long cityId);

    @Query ( value = "SELECT music_id as music, city_id as city,  popularity_rate as popularityRate FROM music_city WHERE music_id in ( SELECT music_id as userMusicId FROM user JOIN user_music um on user.id = um.user_id WHERE user.id = ?1 ) and city_id in ( SELECT city_id as userCityId FROM user JOIN user_city uc on user.id = uc.user_id WHERE user.id = ?1 ) ",
            nativeQuery = true)
    List<Object> findPopularityRateByUserId(long id);

}