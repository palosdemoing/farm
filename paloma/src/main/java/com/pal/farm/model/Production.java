package com.pal.farm.model;


import java.util.Date;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Table;


import lombok.Data;


@Data
@Entity
@Table(name = "PRODUCTION")
public class Production implements Serializable {

	private static final long serialVersionUID = 1786920272455080095L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID_PRODUCTION")
	private Integer idProduction;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="PRODUCTION_DATE")
	private Date productionDate;
	
	@Column(name="STATE")
	private Boolean state;

	@Column(name="PRICE")
	private Integer price;
	
	@ManyToOne
	private Chicken chicken;
}
