package com.harshalmayee.services.impl;

import com.harshalmayee.models.Location;
import com.harshalmayee.repositories.LocationRepository;
import com.harshalmayee.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    @Override
    public void addNewLocation(Location location) {
        locationRepository.save(location);
    }

    @Override
    public Location getLocationById(int id) {
        Optional<Location> optional=locationRepository.findById(id);
        Location location=null;
        if(optional.isPresent()){
            location=optional.get();
        }else{
            throw new RuntimeException("Location Not Found :"+id);
        }
        return location;
    }

    @Override
    public void delete(int id) {
        locationRepository.deleteById(id);
    }
}
