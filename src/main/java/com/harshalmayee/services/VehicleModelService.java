package com.harshalmayee.services;

import com.harshalmayee.models.Location;
import com.harshalmayee.models.VehicleModel;

import java.util.List;

public interface VehicleModelService {

    public List<VehicleModel> getAllVehicleModels();

    public void addNewVehicleModel(VehicleModel vehicleModel);

    public VehicleModel getVehicleModelById(int id);

    void delete(int id);
}
