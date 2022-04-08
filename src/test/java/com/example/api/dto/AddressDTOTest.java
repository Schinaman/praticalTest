package com.example.api.dto;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.example.api.domain.Customer;

public class AddressDTOTest {

	private Customer customer = new Customer(2L,"Joaquim Silva", "joaquimsilva@gmail.com");
	private AddressDTO object0 = new AddressDTO();

	private String logradouro;
	private String number;
	private String complement;
	private String bairro;
	private String cep;
	private Long customerId;
	
	
	
	private List<AddressDTO> AddressDTOes = new ArrayList<>();
	
	
	@Before
	public void setup() {
		

		logradouro = "Rua Roberto Paes";
		number = "54321";
		complement = "Fundo";
		bairro = "Moema";
		cep = "04545454";
		customerId = 4L;
		
	}
	
	
	
	@Test
	public void test() {
		// setters
		
		object0.setLogradouro(logradouro);
		object0.setNumber(number);
		object0.setComplement(complement);
		object0.setBairro(bairro);
		object0.setCep(cep);
		object0.setCustomerId(customerId);
		
		// getters
		assertEquals(AddressDTO.class, object0.getClass());
		assertEquals("Rua Roberto Paes", object0.getLogradouro());
		assertEquals("54321", object0.getNumber());
		assertEquals("Fundo", object0.getComplement());
		assertEquals("Moema", object0.getBairro());
		assertEquals("04545454", object0.getCep());
		assertEquals(1L, object0.getCustomerId(), 0.0);
	
	}
}