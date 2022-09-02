package com.br.geduc.dto.request;

import com.br.geduc.dto.enums.EventStatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape;

import static com.br.geduc.constants.Errors.*;

@Data
@Builder
@AllArgsConstructor
public class EventRequestDTO {

    @Null(message = EVENT_NUMER_IS_NON_REQUIRED)
    private String eventNumber;

    @NotBlank(message = TITLE_IS_REQUIRED)
    private String title;

    @NotBlank(message = DESCRIPTION_IS_REQUIRED)
    private String description;

    @NotBlank(message = REGISTRATION_IS_REQUIRED)
    private String creatorRegistration;

    @NotNull(message = START_IS_REQUIRED)
    @JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime start;

    @NotNull(message = END_IS_REQUIRED)
    @JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime end;

    @Null(message = EVENT_STATUS_IS_NON_REQUIRED)
    private EventStatusEnum status;

    private Set<String> techs;
}
