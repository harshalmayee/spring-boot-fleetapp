package com.harshalmayee.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Vehicle {
		
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	private String name;
	@ManyToOne
	@JoinColumn(name="vehicleTypeId", insertable=false, updatable=false)
	private VehicleType vehicleType;
	private Integer vehicleTypeId;
	
	private String vehicleNumber;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date registrationDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date acquisitionDate;
	private String description;
	
	@ManyToOne
	@JoinColumn(name="vehicleMakeId", insertable=false, updatable=false)
	private VehicleMake vehicleMake;
	private Integer vehicleMakeId;
	
	private String power;
	private String fuelCapacity;
	@ManyToOne
	@JoinColumn(name="vehicleStatusId", insertable=false, updatable=false)
	private VehicleStatus vehicleStatus;
	private Integer vehicleStatusId;
	
	private String netWeight;

	@ManyToOne
	@JoinColumn(name="employeeId", insertable=false, updatable=false)
	private Employee inCharge;
	private Integer employeeId;
	
	@ManyToOne
	@JoinColumn(name="vehicleModelId", insertable=false, updatable=false)
	private VehicleModel vehicleModel;	
	private Integer vehicleModelId;

	@ManyToOne
	@JoinColumn(name="locationId", insertable=false, updatable=false)
	private Location currentLocation;
	private Integer locationId;
	
	private String remarks;	
}
