package com.br.geduc.service;

import com.br.geduc.document.EventDocument;
import com.br.geduc.dto.request.EventRequestDTO;
import com.br.geduc.dto.response.EventResponseDTO;
import com.br.geduc.exceptions.BusinessException;
import com.br.geduc.mapper.EventMapper;
import com.br.geduc.repository.EventRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.br.geduc.constants.Errors.EVENT_NOT_EXISTS;
import static com.br.geduc.dto.enums.EventStatusEnum.PENDING;

@AllArgsConstructor
@Slf4j
public class EventService {

    private EventRepository eventRepository;

    private EventMapper eventMapper;

    private StorageService storageService;

    public void createEvent(EventRequestDTO event) {
        event.setStatus(PENDING);
        storageService.findEventFiles(event.getFilesId());
        var enventDocument = eventMapper.toDocument(event);
        eventRepository.save(enventDocument);
    }

    public EventResponseDTO updateEvent(String eventNumber, EventRequestDTO event) {
        var eventDocument = getEventByEventNumber(eventNumber);

        if (eventDocument.isEmpty())
            throw new BusinessException(EVENT_NOT_EXISTS);

        event.setEventNumber(eventNumber);
        event.setStatus(eventDocument.get().getStatus());
        var updatedEvent = eventMapper.toDocument(event);
        eventRepository.save(updatedEvent);

        return eventMapper.toResponse(updatedEvent);
    }

    public List<EventResponseDTO> listEvents(String creatorRegistration, String status, String title, List<String> techs) {
        var events = eventRepository.findEvents(creatorRegistration, status, title, techs);

        return events.stream().map(event -> eventMapper.toResponse(event)).collect(Collectors.toList());
    }

    private Optional<EventDocument> getEventByEventNumber(String eventNumber) {
        return eventRepository.findById(eventNumber);
    }
}
