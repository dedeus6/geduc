package com.ceub.geduc.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.ceub.geduc.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long registration;
	private String fullName;
	private String email;
	private Set<TagDTO> tags = new HashSet<>();
	
	public UserDTO(User entity) {
		this.registration = entity.getRegistration();
		this.fullName = entity.getFullName();
		this.email = entity.getEmail();
		entity.getTags().forEach(role -> this.tags.add(new TagDTO(role)));
	}

}
