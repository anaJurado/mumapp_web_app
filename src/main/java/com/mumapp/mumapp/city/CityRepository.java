package com.mumapp.mumapp.city;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface CityRepository extends JpaRepository<City, Long> {

    @Query( value="SELECT * FROM city WHERE city_name= ?1",
            nativeQuery=true)
    Optional<City> findCityByCityName(String name);

    @Modifying
    @Query( value="DELETE FROM user_city WHERE city_id= ?1",
            nativeQuery=true)
    void deleteCityUser(long id);

    @Modifying
    @Query( value="DELETE FROM music_city WHERE city_id= ?1",
            nativeQuery=true)
    void deleteCityMusicCity(long id);


}


