package com.pal.farm.model;


import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@Table(name = "CHICKEN")
public class Chicken extends Animal {
	
	private static final long serialVersionUID = -3954881926460420285L;
	
	public Chicken(String type, String frecuency) {
		super(type, frecuency);
	}

}

