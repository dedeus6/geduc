package com.br.geduc.mapper;

import com.br.geduc.document.UserDocument;
import com.br.geduc.dto.request.UserRequestDTO;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;

public class UserMapper {

    private final ModelMapper mapper;

    public UserMapper(ModelMapper mapper) {
        this.mapper = mapper;
        this.mapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
    }

    public UserDocument toDocument(UserRequestDTO user) {
        return mapper.map(user, UserDocument.class);
    }
}
