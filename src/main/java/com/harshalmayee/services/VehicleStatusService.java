package com.harshalmayee.services;

import com.harshalmayee.models.Location;
import com.harshalmayee.models.VehicleStatus;

import java.util.List;

public interface VehicleStatusService {

    public List<VehicleStatus> getAllVehicleStatuses();

    public void addNewVehicleStatus(VehicleStatus vehicleStatus);

    public VehicleStatus getVehicleStatusById(int id);

    void delete(int id);
}
