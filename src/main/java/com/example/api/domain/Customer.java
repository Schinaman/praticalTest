package com.example.api.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;

	@Column(nullable = false)
	@NotEmpty(message="Preenchimento obrigatório")
	private String name;

	@Column(nullable = false)
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=80, message="Tamanho deve ter entre 5 e 80 caracteres")
	@Email
	private String email;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
