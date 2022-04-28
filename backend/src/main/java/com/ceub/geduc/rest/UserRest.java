package com.ceub.geduc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ceub.geduc.dto.UserDTO;
import com.ceub.geduc.dto.UserInsertDTO;
import com.ceub.geduc.service.UserService;

import java.net.URI;

@RestController
@RequestMapping(value = "/user")
public class UserRest {
	
	@Autowired
	private UserService service;
	
	@PostMapping
	public ResponseEntity<UserDTO> insert(@RequestBody UserInsertDTO req) {
		UserDTO newDto = service.insert(req);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newDto.getRegistration()).toUri();
		return ResponseEntity.created(uri).body(newDto);
	}

}
