package com.harshalmayee.services.impl;

import com.harshalmayee.models.Location;
import com.harshalmayee.models.VehicleModel;
import com.harshalmayee.models.VehicleStatus;
import com.harshalmayee.repositories.LocationRepository;
import com.harshalmayee.repositories.VehicleStatusRepository;
import com.harshalmayee.services.VehicleStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleStatusServiceImpl implements VehicleStatusService {


    @Autowired
    private VehicleStatusRepository vehicleStatusRepository;

    @Override
    public List<VehicleStatus> getAllVehicleStatuses() {
        return vehicleStatusRepository.findAll();
    }

    @Override
    public void addNewVehicleStatus(VehicleStatus vehicleStatus) {
        vehicleStatusRepository.save(vehicleStatus);
    }

    @Override
    public VehicleStatus getVehicleStatusById(int id) {
        Optional<VehicleStatus> optional=vehicleStatusRepository.findById(id);
        VehicleStatus vehicleStatus=null;
        if(optional.isPresent()){
            vehicleStatus=optional.get();
        }else{
            throw new RuntimeException("Vehicle Status Value Not Found :"+id);
        }
        return vehicleStatus;
    }

    @Override
    public void delete(int id) {
        vehicleStatusRepository.deleteById(id);
    }
}
