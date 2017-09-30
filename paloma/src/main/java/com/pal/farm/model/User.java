package com.pal.farm.model;


import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@Entity
@RequiredArgsConstructor
@Table(name = "USER")
public class User implements Serializable {

	private static final long serialVersionUID = 4324472415853055382L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_USER")
	private Integer idUser;
	
	@Column(name = "USERNAME", nullable = false, unique = true)
	@NotNull
	private String username;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "USER")
	private List<Animal> animals;

}
