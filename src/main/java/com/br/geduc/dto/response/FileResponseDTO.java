package com.br.geduc.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class FileResponseDTO {

    @JsonIgnore
    private String id;
    private String name;
    private String contentType;
    private byte[] bytes;
}
