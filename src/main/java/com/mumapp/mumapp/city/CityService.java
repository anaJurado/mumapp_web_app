package com.mumapp.mumapp.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;


    public Optional<City> findById(long id) {
        return cityRepository.findById(id);
    }

    public void save(City city) {
        cityRepository.save(city);
    }
    public void deleteById(long id) {
        cityRepository.deleteById(id);
    }

    public List<City> findAll() {
        return cityRepository.findAll();
    }
}
