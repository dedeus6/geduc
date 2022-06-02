package com.ceub.geduc.dto;

import java.io.Serializable;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FileDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long eventId;
	private Set<String> files;

}
