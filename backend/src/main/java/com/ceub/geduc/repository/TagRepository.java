package com.ceub.geduc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceub.geduc.entities.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long>{
	
	Tag findByTag(String tag);

}
