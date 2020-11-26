package com.harshalmayee.services;

import com.harshalmayee.models.Location;
import com.harshalmayee.models.VehicleMake;

import java.util.List;

public interface VehicleMakeService {

    public List<VehicleMake> getAllVehicleMakes();

    public void addNewVehicleMake(VehicleMake vehicleMake);

    public VehicleMake getVehicleMakeById(int id);

    void delete(int id);
}
