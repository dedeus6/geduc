package com.br.geduc.service;

import com.br.geduc.dto.request.EventRequestDTO;
import com.br.geduc.dto.response.EventResponseDTO;
import com.br.geduc.mapper.EventMapper;
import com.br.geduc.repository.EventRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import static com.br.geduc.dto.enums.EventStatusEnum.PENDING;

@AllArgsConstructor
@Slf4j
public class EventService {

    private EventRepository eventRepository;

    private EventMapper eventMapper;

    public void createEvent(EventRequestDTO event) {
        event.setStatus(PENDING);
        var enventDocument = eventMapper.toDocument(event);
        eventRepository.save(enventDocument);
    }

    public Page<EventResponseDTO> listEvents(Pageable pageable) {
        var events = eventRepository.findAll(pageable);
        return events.map(event -> EventResponseDTO.builder()
                .eventNumber(event.getEventNumber().toString())
                .title(event.getTitle())
                .description(event.getDescription())
                .creatorRegistration(event.getCreatorRegistration())
                .duration(event.getDuration())
                .status(event.getStatus())
                .techs(event.getTechs())
                .build());
    }
}
