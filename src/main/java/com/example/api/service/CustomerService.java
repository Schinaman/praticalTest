package com.example.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
		return repository.findAllByOrderByNameAsc();
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

	// deleção exclui endereços vinculados
	public void delete(Long id) {
		findById(id);
//		try {
		repository.deleteById(id);
//		}
//		catch (DataIntegrityViolationException e) {
//			throw new DataIntegrityException("Não é possível excluir uma cliente que possui endereços");
//		}
	}

	
	
	
}
