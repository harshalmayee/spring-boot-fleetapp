package com.harshalmayee.services.impl;

import com.harshalmayee.models.Location;
import com.harshalmayee.models.VehicleMake;
import com.harshalmayee.models.VehicleModel;
import com.harshalmayee.repositories.LocationRepository;
import com.harshalmayee.repositories.VehicleModelRepository;
import com.harshalmayee.services.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleModelServiceImpl implements VehicleModelService {

    @Autowired
    private VehicleModelRepository vehicleModelRepository;

    @Override
    public List<VehicleModel> getAllVehicleModels() {
        return vehicleModelRepository.findAll();
    }

    @Override
    public void addNewVehicleModel(VehicleModel vehicleModel) {
        vehicleModelRepository.save(vehicleModel);
    }

    @Override
    public VehicleModel getVehicleModelById(int id) {
        Optional<VehicleModel> optional=vehicleModelRepository.findById(id);
        VehicleModel vehicleModel=null;
        if(optional.isPresent()){
            vehicleModel=optional.get();
        }else{
            throw new RuntimeException("Vehicle Model Not Found :"+id);
        }
        return vehicleModel;
    }

    @Override
    public void delete(int id) {
        vehicleModelRepository.deleteById(id);
    }
}
