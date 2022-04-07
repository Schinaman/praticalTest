package com.example.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.api.domain.Customer;
import com.example.api.repository.CustomerRepository;
import com.example.api.service.exceptions.ObjectNotFoundException;

@Service
public class CustomerService {

	private CustomerRepository repository;

	@Autowired
	public CustomerService(CustomerRepository repository) {
		this.repository = repository;
	}
	
	public List<Customer> findAll() {
		return repository.findAll();
	}

	public Customer findById(Long id) {
		Optional<Customer> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Customer.class.getName()));
	}
	

	public Customer insert(Customer obj) {
		return repository.save(obj);
	}

	public Customer update(Customer obj) {
		Customer newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	private void updateData(Customer newObj, Customer obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}


	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);

	}

	public Page<Customer> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page , linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}
	
	
}
