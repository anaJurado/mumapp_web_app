package com.mumapp.mumapp.music;

import com.mumapp.mumapp.musiccity.MusicCity;
import com.mumapp.mumapp.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MusicRepository extends JpaRepository<Music, Long> {
    @Query( value = "SELECT popularity_rate FROM music_city WHERE music_id = ?1 AND city_id = ?2",
            nativeQuery = true)
    int findByMusicIdAndCityId(long musicId, long cityId);

    @Query ( value = "SELECT m.style_name, c.city_name, music_city.popularity_rate FROM music_city JOIN music m on music_city.music_id = m.id JOIN city c on music_city.city_id = c.id WHERE music_id in ( SELECT music_id as userMusicId FROM user JOIN user_music um on user.id = um.user_id WHERE user.id = ?1 ) and city_id in ( SELECT city_id as userCityId FROM user JOIN user_city uc on user.id = uc.user_id WHERE user.id = ?1 )",
            nativeQuery = true)
    List<Object> findPopularityRateByUserId(long id);

    @Query ( value = "SELECT m.style_name, c.city_name, music_city.popularity_rate FROM music_city JOIN music m on music_city.music_id = m.id JOIN city c on music_city.city_id = c.id WHERE music_id in ( SELECT music_id as userMusicId FROM user JOIN user_music um on user.id = um.user_id WHERE user.id = ?1 ) and city_id in ( SELECT city_id as userCityId FROM user JOIN user_city uc on user.id = uc.user_id WHERE user.id = ?1 ) ORDER BY music_city.popularity_rate DESC LIMIT 10 ",
            nativeQuery = true)
    List<Object> findTopPopularityRateByUserId(long id);

    @Query ( value="SELECT m.style_name, c.city_name, music_city.popularity_rate FROM music_city JOIN music m on music_city.music_id = m.id JOIN city c on music_city.city_id = c.id GROUP BY 1,2,3 ORDER BY music_city.popularity_rate DESC LIMIT 10",
             nativeQuery= true)
    List<Object> findTopPopularity();

}