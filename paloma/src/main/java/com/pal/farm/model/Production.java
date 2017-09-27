package com.pal.farm.model;


import java.util.Date;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
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
	@NotNull
	private Date productionDate;
	
	@Column(name="STATE")
	private Boolean state;

	@Column(name="COST_PRICE", nullable = false)
	@NotNull
	private Double costPrice;

	@Column(name="OFFER_PRICE", nullable = false)
	@NotNull
	private Double offerPrice;

	@Column(name="ANIMAL")
	private Animal animal;
	
}
