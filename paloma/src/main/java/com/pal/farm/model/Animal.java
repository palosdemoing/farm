package com.pal.farm.model;


import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.dozer.Mapping;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@DiscriminatorColumn(name = "ANIMAL_TYPE", discriminatorType=DiscriminatorType.STRING)
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@Table(name = "ANIMAL")
public abstract class Animal implements Serializable {

	private static final long serialVersionUID = 9108825445592569217L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_ANIMAL", updatable = false)
	protected Integer idAnimal;

	@Column(name="TYPE")
	private String type;

	@Column(name="FRECUENCY")
	private String frecuency;

	@ManyToOne
	private User user;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Production> productions;

}
