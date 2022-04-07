package com.example.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.api.domain.Address;
import com.example.api.repository.AddressRepository;
import com.example.api.service.exceptions.ObjectNotFoundException;

@Service
public class AddressService {

	private AddressRepository repository;

	@Autowired
	public AddressService(AddressRepository repository) {
		this.repository = repository;
	}
	
	public List<Address> findAll() {
		return repository.findAll();
	}

	public Address findById(Long id) {
		Optional<Address> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Address.class.getName()));
	}
	

	public Address insert(Address obj) {
		return repository.save(obj);
	}

	public Address update(Address obj) {
		Address newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	private void updateData(Address newObj, Address obj) {
		newObj.setBairro(obj.getBairro());
		newObj.setCep(obj.getCep());
		newObj.setComplement(obj.getComplement());		
		newObj.setLogradouro(obj.getLogradouro());
		newObj.setNumber(obj.getNumber());
		//newObj.setCustomer(obj.getCustomer());
	}

	public void delete(Long id) {
		findById(id);
//		try {
		repository.deleteById(id);
//		}
//		catch (DataIntegrityViolationException e) {
//			throw new DataIntegrityException("Não é possível excluir uma cliente que possui endereços");
//		}
	}

	public Page<Address> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page , linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}
	
	
}
