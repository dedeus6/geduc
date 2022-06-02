package com.ceub.geduc.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceub.geduc.entities.File;

@Repository
public interface FileRepository extends JpaRepository<File, UUID>{

}
