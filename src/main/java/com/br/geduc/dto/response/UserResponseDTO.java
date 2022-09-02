package com.br.geduc.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
public class UserResponseDTO {
    private String registration;
    private String name;
    private String email;
    @JsonIgnore
    private String password;
    private Set<String> techs;
}
