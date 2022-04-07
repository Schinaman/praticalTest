package com.example.api.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class AddressDTO implements Serializable{ //utilizado para o metodo Insert Post
	private static final long serialVersionUID = 1L;
	
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

	@Column(nullable = false)
	private Long customerId;

	public AddressDTO() {
		super();
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

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}	

	
	

}
