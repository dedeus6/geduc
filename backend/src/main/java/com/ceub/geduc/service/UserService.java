package com.ceub.geduc.service;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ceub.geduc.dto.TagDTO;
import com.ceub.geduc.dto.UserDTO;
import com.ceub.geduc.dto.UserInsertDTO;
import com.ceub.geduc.entities.Tag;
import com.ceub.geduc.entities.User;
import com.ceub.geduc.repository.TagRepository;
import com.ceub.geduc.repository.UserRepository;

import javax.transaction.Transactional;

@Service
public class UserService implements UserDetailsService {
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TagRepository tagRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Transactional
	public UserDTO insert(UserInsertDTO req) {
		User entity = new User();
		copyDtoToEntity(req, entity);
		entity.setPassword(passwordEncoder.encode(req.getPassword()));
		entity = userRepository.save(entity);
		return new UserDTO(entity);
	}
	
	private void copyDtoToEntity(UserDTO dto, User entity) {
		entity.setRegistration(dto.getRegistration());
		entity.setEmail(dto.getEmail());
		entity.setFullName(dto.getFullName());
		
		entity.getTags().clear();
		for (TagDTO tag: dto.getTags()) {
			Tag role = tagRepository.getById(tag.getTagId());
			entity.getTags().add(role);
		}
	}
	
	@Override
	public UserDetails loadUserByUsername(String registration) throws UsernameNotFoundException {
		User user = this.userRepository.getById(Long.valueOf(registration).longValue());
		if (user.equals(null)) {
			logger.error("User not found: " + registration);
			throw new UsernameNotFoundException("Email not found");
		}
		logger.info("User found: " + registration);
		return user;
	}

}
