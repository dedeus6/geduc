package com.br.geduc.rest;

import com.br.geduc.dto.enums.EventStatusEnum;
import com.br.geduc.dto.request.EventRequestDTO;
import com.br.geduc.dto.response.EventResponseDTO;
import com.br.geduc.service.EventService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.modelmapper.internal.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.br.geduc.dto.enums.EventStatusEnum.PENDING;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/event")
@Validated
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping
    @ResponseStatus(CREATED)
    public void createEvent(@Valid @RequestBody EventRequestDTO event) {
        eventService.createEvent(event);
    }

    @GetMapping
    @ResponseStatus(OK)
    public Page<EventResponseDTO> listEvents(Pageable pageable) {
        return eventService.listEvents(pageable);
    }

}
