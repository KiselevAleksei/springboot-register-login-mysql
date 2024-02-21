package com.kiselev.springbootreglogindemo.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "role")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, unique = true)
	private String name;

	@ManyToMany(mappedBy="roles")
	List<User> users;

	public Role() {
		}
	
	public Role(String name) {
		super();
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
