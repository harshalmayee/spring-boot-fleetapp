package com.harshalmayee.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Employee extends Person {
		
	@ManyToOne
	@JoinColumn(name="employeeTypeId", insertable=false, updatable=false)
	private EmployeeType employeeType;
	private Integer employeeTypeId;
	private String photo;
	private String username;
	
	@ManyToOne
	@JoinColumn(name="jobTitleId", insertable=false, updatable=false)
	private JobTitle jobTitle;
	private Integer jobTitleId;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")	
	private Date hireDate;
}
