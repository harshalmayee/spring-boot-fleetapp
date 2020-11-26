package com.harshalmayee.services;

import com.harshalmayee.models.Location;

import java.util.List;

public interface LocationService {

    public List<Location> getAllLocations();

    public void addNewLocation(Location location);

    public Location getLocationById(int id);

    void delete(int id);
}
