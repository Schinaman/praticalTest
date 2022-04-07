package com.example.api.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(max=80, message="Tamanho deve ter até 80 caracteres")
	private String logradouro;

	@Column(nullable = false)
	private String number;
	
	private String complement;
	@Column(nullable = false)
	private String bairro;
	@Column(nullable = false)
	private String cep;

	
	//@ManyToOne
	//@JoinColumn (name = "customer_id")
	//@JsonIgnore
	//private Customer customer;
	
	
	public Address() {
		super();
	}

	public Address(Long id, String logradouro, String number, String complement, String bairro, String cep, Customer customer) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.number = number;
		this.complement = complement;
		this.bairro = bairro;
		this.cep = cep;
		//this.customer = customer;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getLogradouro() {
		return logradouro;
	}


	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getComplement() {
		return complement;
	}


	public void setComplement(String complement) {
		this.complement = complement;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}

//
//	public Customer getCustomer() {
//		return customer;
//	}
//
//
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}
//	
	
	
}
