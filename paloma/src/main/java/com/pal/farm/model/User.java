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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "USER")
public class User implements Serializable {

	private static final long serialVersionUID = 4324472415853055382L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID_USER")
	private Integer idUser;
	
	@Column(name="USERNAME", nullable=false)
	private String username;
	
	@Column(name="EMAIL", nullable=false)
	private String email;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
	private List<Animal> animals;
	

	public User(String username, String email) {
		this.setUsername(username);
		this.setEmail(email);
	}

}
