package com.ceub.geduc.dto;

import java.io.Serializable;

import com.ceub.geduc.entities.Tag;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TagDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long tagId;
	private String tag;
	
	public TagDTO(Tag entity) {
		this.tagId = entity.getTagId();
		this.tag = entity.getTag();
	}

}
