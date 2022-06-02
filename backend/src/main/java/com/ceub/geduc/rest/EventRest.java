package com.ceub.geduc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceub.geduc.dto.EventDTO;
import com.ceub.geduc.service.FileService;

@RestController
@RequestMapping(value = "/event")
public class EventRest {
	
	@Autowired
	private FileService fileService;
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody EventDTO req) {
		fileService.saveFileOnSystem(req.getFiles());
		return null;
	}

}
