package com.mumapp.mumapp.music;

import com.mumapp.mumapp.city.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MusicRepository extends JpaRepository<Music, Long> {

    @Query( value="SELECT * FROM music WHERE style_name= ?1",
            nativeQuery=true)
    Optional<Music> findMusicByStyleName(String style);


    @Query( value = "SELECT popularity_rate FROM music_city WHERE music_id = ?1 AND city_id = ?2",
            nativeQuery = true)
    int findByMusicIdAndCityId(long musicId, long cityId);

    @Query ( value = "SELECT m.style_name, c.city_name, music_city.popularity_rate FROM music_city JOIN music m on music_city.music_id = m.id JOIN city c on music_city.city_id = c.id WHERE music_id in ( SELECT music_id as userMusicId FROM user JOIN user_music um on user.id = um.user_id WHERE user.id = ?1 ) and city_id in ( SELECT city_id as userCityId FROM user JOIN user_city uc on user.id = uc.user_id WHERE user.id = ?1 )",
            nativeQuery = true)
    List<Object> findPopularityRateByUserId(long id);

    @Query ( value = "SELECT m.style_name, c.city_name, music_city.popularity_rate FROM music_city JOIN music m on music_city.music_id = m.id JOIN city c on music_city.city_id = c.id WHERE music_id in ( SELECT music_id as userMusicId FROM user JOIN user_music um on user.id = um.user_id WHERE user.id = ?1 ) and city_id in ( SELECT city_id as userCityId FROM user JOIN user_city uc on user.id = uc.user_id WHERE user.id = ?1 ) ORDER BY music_city.popularity_rate DESC LIMIT 10 ",
            nativeQuery = true)
    List<Object> findTopPopularityRateByUserId(long id);

    @Query ( value="SELECT m.style_name, c.city_name, music_city.popularity_rate FROM music_city JOIN music m on music_city.music_id = m.id JOIN city c on music_city.city_id = c.id GROUP BY 1,2,3 ORDER BY music_city.popularity_rate DESC",
            nativeQuery= true)
    List<Object> findPopularity();

    @Query ( value="SELECT m.style_name, c.city_name, music_city.popularity_rate FROM music_city JOIN music m on music_city.music_id = m.id JOIN city c on music_city.city_id = c.id GROUP BY 1,2,3 ORDER BY music_city.popularity_rate DESC LIMIT 10",
             nativeQuery= true)
    List<Object> findTopPopularity();

    // DELETE "ON CASCADE"
    @Modifying
    @Query( value="DELETE FROM user_music WHERE music_id= ?1",
            nativeQuery=true)
    void deleteMusicUser(long id);

    @Modifying
    @Query( value="DELETE FROM music_city WHERE music_id= ?1",
            nativeQuery=true)
    void deleteMusicMusicCity(long id);


    // GENERATE RANDOM DATA
    @Modifying
    @Query( value="DELETE FROM music_city WHERE TRUE",
            nativeQuery=true)
    void truncateMusicCity();

    @Modifying
    @Query( value="INSERT INTO music_city (music_id, city_id) SELECT music.id music_id, city.id as city_id FROM music CROSS JOIN city",
            nativeQuery=true)
    void crossJoinMusicCity();

    @Modifying
    @Query( value="UPDATE music_city SET popularity_rate = 100 * RAND() WHERE 1",
            nativeQuery=true)
    void randomData();



}