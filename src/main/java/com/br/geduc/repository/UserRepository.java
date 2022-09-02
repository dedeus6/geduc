package com.br.geduc.repository;

import com.br.geduc.document.UserDocument;
import com.br.geduc.dto.request.UserRequestDTO;
import com.br.geduc.dto.response.UserResponseDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserDocument, String> {

    UserResponseDTO findByRegistration(String registration);
    UserResponseDTO findByEmail(String email);

}
