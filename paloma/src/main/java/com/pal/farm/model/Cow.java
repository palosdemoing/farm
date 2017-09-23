package com.pal.farm.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.NoArgsConstructor;


//@DiscriminatorValue("COW")
@Entity
@NoArgsConstructor
@Table(name = "COW")
public class Cow extends Animal {

	private static final long serialVersionUID = -397042806270603878L;
	
	public Cow(String type, String frecuency) {
		super(type, frecuency);
	}

}
