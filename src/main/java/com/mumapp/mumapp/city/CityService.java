package com.mumapp.mumapp.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public Optional<City> findById(long id) {
        return cityRepository.findById(id);
    }

    public Optional<City> findByCityName(String name) {

        return cityRepository.findCityByCityName(name);
    }

    public void save(City city) {
        cityRepository.save(city);
    }

    @Transactional
    public void deleteById(long id) {
        cityRepository.deleteCityUser(id);
        cityRepository.deleteCityMusicCity(id);
        cityRepository.deleteById(id);
    }

    public List<City> findAll() {
        return cityRepository.findAll();
    }
}
