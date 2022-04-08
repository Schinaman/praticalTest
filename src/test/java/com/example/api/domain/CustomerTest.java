package com.example.api.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {


	private Customer object0 = new Customer(2L,"Joaquim Silva", "joaquimsilva@gmail.com");
	
	private Long id;
	private String name;
	private String email;
	
	private List<Address> addresses = new ArrayList<>();
	
	
	@Before
	public void setup() {
		object0 = new Customer();

		name = "Abcdefghi Jklkmnopq Rstuvxz";
		email = "abc@gmail.com";
	}
	
	@Test
	public void test() {
		// setters
		object0.setName(name);
		object0.setEmail(email);
		object0.setId(1L);
		
		// getters
		assertEquals(Customer.class, object0.getClass());
		assertEquals(1L, object0.getId(), 0.0);
		assertEquals("Abcdefghi Jklkmnopq Rstuvxz", object0.getName());
		assertEquals("abc@gmail.com", object0.getEmail());
		
	}

}
