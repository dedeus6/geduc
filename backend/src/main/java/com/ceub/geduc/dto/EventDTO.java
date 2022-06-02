package com.ceub.geduc.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;
import com.ceub.geduc.entities.Tag;
import com.ceub.geduc.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long eventId;
	private String title;
	private String description;
	private LocalDate creationDate;
	private LocalTime duration;
	private User registration;
	private Set<Tag> tags = new HashSet<>();
	private Set<User> users = new HashSet<>();
	private Set<MultipartFile> files = new HashSet<>();
}
