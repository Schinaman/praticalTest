package com.example.api.domain;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class AddressTest {

	private Customer customer = new Customer(2L,"Joaquim Silva", "joaquimsilva@gmail.com");
	private Address object0 = new Address(2L,"Rua Pascoale", "12345", "rua de trás", "Piritubacity", "04343430", customer);
	
	private Long id;
	private String logradouro;
	private String number;
	private String complement;
	private String bairro;
	private String cep;
	
	
	
	private List<Address> addresses = new ArrayList<>();
	
	
	@Before
	public void setup() {
		object0 = new Address();

		id = 1L;
		logradouro = "Rua Roberto Paes";
		number = "54321";
		complement = "Fundo";
		bairro = "Moema";
		cep = "04545454";
		
	}
	
	
	
	@Test
	public void test() {
		// setters
		object0.setId(id);;
		object0.setLogradouro(logradouro);
		object0.setNumber(number);
		object0.setComplement(complement);
		object0.setBairro(bairro);
		object0.setCep(cep);
		
		// getters
		assertEquals(Address.class, object0.getClass());
		assertEquals(1L, object0.getId(), 0.0);
		assertEquals("Rua Roberto Paes", object0.getLogradouro());
		assertEquals("54321", object0.getNumber());
		assertEquals("Fundo", object0.getComplement());
		assertEquals("Moema", object0.getBairro());
		assertEquals("04545454", object0.getCep());
		
	}


}
