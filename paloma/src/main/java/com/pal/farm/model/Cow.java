package com.pal.farm.model;

import java.util.List;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "COW")
public class Cow extends Animal implements Serializable {

	private static final long serialVersionUID = 9108825445592569217L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID_COW")
	private Integer idCow;

	@Column(name="TYPE")
	private String type;

	@Column(name="FRECUENCY")
	private String frecuency;
	
	@ManyToOne
	private User user;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "animal")
	private List<Production> productions;

}
