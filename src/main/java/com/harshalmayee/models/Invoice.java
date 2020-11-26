package com.harshalmayee.models;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class Invoice {	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date invoiceDate;
	
	@ManyToOne
	@JoinColumn(name="invoiceStatusId", insertable=false, updatable=false)
	private InvoiceStatus invoiceStatus;
	private Integer invoiceStatusId;
	
	@ManyToOne
	@JoinColumn(name="clientId", insertable=false, updatable=false)
	private Client client;
	private Integer clientId;
	
	private String remarks;	
}
