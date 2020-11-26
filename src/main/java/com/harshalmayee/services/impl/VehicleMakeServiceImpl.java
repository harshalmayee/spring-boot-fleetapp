package com.harshalmayee.services.impl;

import com.harshalmayee.models.Location;
import com.harshalmayee.models.VehicleMake;
import com.harshalmayee.repositories.LocationRepository;
import com.harshalmayee.repositories.VehicleMakeRepository;
import com.harshalmayee.services.VehicleMakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleMakeServiceImpl implements VehicleMakeService {

    @Autowired
    private VehicleMakeRepository vehicleMakeRepository;

    @Override
    public List<VehicleMake> getAllVehicleMakes() {
        return vehicleMakeRepository.findAll();
    }

    @Override
    public void addNewVehicleMake(VehicleMake vehicleMake) {
        vehicleMakeRepository.save(vehicleMake);
    }

    @Override
    public VehicleMake getVehicleMakeById(int id) {
        Optional<VehicleMake> optional=vehicleMakeRepository.findById(id);
        VehicleMake vehicleMake=null;
        if(optional.isPresent()){
            vehicleMake=optional.get();
        }else{
            throw new RuntimeException("Vehicle Make Not Found :"+id);
        }
        return vehicleMake;
    }

    @Override
    public void delete(int id) {
        vehicleMakeRepository.deleteById(id);
    }
}
