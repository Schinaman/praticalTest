package com.example.api.web.rest;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.api.domain.Address;
import com.example.api.dto.AddressDTO;
import com.example.api.service.AddressService;

@RestController
@RequestMapping("/addresses")
public class AddressController {

	@Autowired
	private AddressService service;


	@GetMapping
	public List<Address> findAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Address> findById(@PathVariable Long id) {
		Address obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody AddressDTO objDto) {
		Address obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	
	@RequestMapping(value = "/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody AddressDTO objDto, @PathVariable Long id) {
		Address obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete (@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	@RequestMapping(value = "/page", method=RequestMethod.GET)
	public ResponseEntity<Page<Address>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="name") String orderBy,
			@RequestParam(value="direction", defaultValue="ASC") String direction){
		Page<Address> list = service.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok(list);
	}
	
}
