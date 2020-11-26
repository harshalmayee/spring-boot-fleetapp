package com.harshalmayee.services;

import com.harshalmayee.models.Location;
import com.harshalmayee.models.VehicleType;

import java.util.List;

public interface VehicleTypeService {

    public List<VehicleType> getAllVehicleTypes();

    public void addNewVehicleType(VehicleType vehicleType);

    public VehicleType getVehicleTypeById(int id);

    void delete(int id);
}
