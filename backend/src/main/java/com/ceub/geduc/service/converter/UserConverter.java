package com.ceub.geduc.service.converter;

import org.springframework.beans.factory.annotation.Autowired;

import com.ceub.geduc.dto.TagDTO;
import com.ceub.geduc.dto.UserDTO;
import com.ceub.geduc.entities.Tag;
import com.ceub.geduc.entities.User;
import com.ceub.geduc.repository.TagRepository;

public class UserConverter {
	
	@Autowired
	private static TagRepository tagRepository;
	
	public static void copyDtoToEntity(UserDTO dto, User entity) {
		entity.setRegistration(dto.getRegistration());
		entity.setEmail(dto.getEmail());
		entity.setFullName(dto.getFullName());
		
		entity.getTags().clear();
		for (TagDTO tag: dto.getTags()) {
			Tag role = tagRepository.getById(tag.getTagId());
			entity.getTags().add(role);
		}
	}

}
