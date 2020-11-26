package com.harshalmayee.services.impl;

import com.harshalmayee.models.Location;
import com.harshalmayee.models.VehicleStatus;
import com.harshalmayee.models.VehicleType;
import com.harshalmayee.repositories.LocationRepository;
import com.harshalmayee.repositories.VehicleTypeRepository;
import com.harshalmayee.services.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleTypeServiceImpl implements VehicleTypeService {

    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    @Override
    public List<VehicleType> getAllVehicleTypes() {
        return vehicleTypeRepository.findAll();
    }

    @Override
    public void addNewVehicleType(VehicleType vehicleType) {
        vehicleTypeRepository.save(vehicleType);
    }

    @Override
    public VehicleType getVehicleTypeById(int id) {
        Optional<VehicleType> optional=vehicleTypeRepository.findById(id);
        VehicleType vehicleType=null;
        if(optional.isPresent()){
            vehicleType=optional.get();
        }else{
            throw new RuntimeException("Vehicle Type  Not Found :"+id);
        }
        return vehicleType;
    }

    @Override
    public void delete(int id) {
        vehicleTypeRepository.deleteById(id);
    }
}
