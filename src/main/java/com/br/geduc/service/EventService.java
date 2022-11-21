package com.br.geduc.service;

import com.br.geduc.document.EventDocument;
import com.br.geduc.document.SubscribeDocument;
import com.br.geduc.dto.enums.NotificationTypeEnum;
import com.br.geduc.dto.request.EventRequestDTO;
import com.br.geduc.dto.request.SubscribeEventDTO;
import com.br.geduc.dto.response.EventResponseDTO;
import com.br.geduc.exceptions.BusinessException;
import com.br.geduc.mapper.EventMapper;
import com.br.geduc.mapper.SubscribeMapper;
import com.br.geduc.repository.EventRepository;
import com.br.geduc.repository.SubscriberRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.br.geduc.constants.Errors.EVENT_NOT_EXISTS;
import static com.br.geduc.constants.Errors.USER_NOT_EXIST;
import static com.br.geduc.dto.enums.EventStatusEnum.PENDING;
import static com.br.geduc.dto.enums.NotificationTypeEnum.CREATE_EVENT;
import static com.br.geduc.dto.enums.NotificationTypeEnum.SUBSCRIBE_EVENT;

@AllArgsConstructor
@Slf4j
public class EventService {

    private EventRepository eventRepository;

    private EventMapper eventMapper;

    private StorageService storageService;

    private UserService userService;

    private NotificationService notificationService;

    private SubscriberRepository subscriberRepository;

    private SubscribeMapper subscribeMapper;

    public void createEvent(EventRequestDTO event) {
        event.setStatus(PENDING);
        storageService.findEventFiles(event.getFilesId());
        var enventDocument = eventMapper.toDocument(event);
        eventRepository.save(enventDocument);
        notificationService.createNotification(event.getCreatorRegistration(), event.getTitle(), CREATE_EVENT);
    }

    public void subscribeEvent(SubscribeEventDTO subscriber) {
        var event = getEventByEventNumber(subscriber.getEventNumber());
        var user = userService.getUserByRegistration(subscriber.getRegistration());

        if (event.isEmpty()) {
            throw new BusinessException(EVENT_NOT_EXISTS);
        }

        if (Objects.isNull(user)) {
            throw new BusinessException(USER_NOT_EXIST);
        }

        userService.validateIfUserAlreadySubscribeInEvent(subscriber.getEventNumber(), subscriber.getRegistration());

        subscriberRepository.save(subscribeMapper.toDocument(subscriber));

        notificationService.createNotification(user.getRegistration(), event.get().getTitle(), SUBSCRIBE_EVENT);
    }

    public List<EventResponseDTO> listEventsSubscribed(String registration) {
        var documentList = findSubscribeByRegistration(registration);
        var events = new ArrayList<EventResponseDTO>();

        documentList.forEach(subscribe -> {
            var event = getEventByEventNumber(subscribe.getEventNumber());
            event.ifPresent(eventDocument -> events.add(eventMapper.toResponse(eventDocument)));
        });

        return events;
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

    public List<EventResponseDTO> listEvents(String eventNumber, String creatorRegistration, String status, String title, List<String> techs) {
        var events = eventRepository.findEvents(eventNumber, creatorRegistration, status, title, techs);

        return events.stream().map(event -> eventMapper.toResponse(event)).collect(Collectors.toList());
    }

    private Optional<EventDocument> getEventByEventNumber(String eventNumber) {
        return eventRepository.findById(eventNumber);
    }

    private List<SubscribeDocument> findSubscribeByRegistration(String registration) {
        return subscriberRepository.findByRegistration(registration);
    }
}
