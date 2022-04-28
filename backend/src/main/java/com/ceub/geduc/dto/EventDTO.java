package com.ceub.geduc.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
	private Date date;
	private LocalDate startTime;
	private LocalDate endTime;
	private User registration;
	private Set<Tag> tags = new HashSet<>();
	private Set<User> users = new HashSet<>();
}
