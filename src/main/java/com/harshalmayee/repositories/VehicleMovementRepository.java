package com.harshalmayee.repositories;

import com.harshalmayee.models.VehicleMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface VehicleMovementRepository extends JpaRepository<VehicleMovement, Integer> {

}
