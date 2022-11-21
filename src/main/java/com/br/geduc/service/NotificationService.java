package com.br.geduc.service;

import com.br.geduc.document.NotificationDocument;
import com.br.geduc.dto.enums.NotificationTypeEnum;
import com.br.geduc.dto.response.NotificationResponseDTO;
import com.br.geduc.mapper.NotificationMapper;
import com.br.geduc.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class NotificationService {

    private NotificationRepository notificationRepository;

    private NotificationMapper notificationMapper;

    public void createNotification(String registration, String eventTitle, NotificationTypeEnum notificationType) {
        var document = NotificationDocument.builder()
                .registration(registration)
                .notification(getNotification(eventTitle, notificationType))
                .creationTimeStamp(LocalDateTime.now().toString())
                .status("PENDING")
                .build();
        this.notificationRepository.save(document);
    }

    public void readNotification(String notificationId) {
        var document = this.notificationRepository.findById(notificationId).get();

        var documentUpdate = NotificationDocument.builder()
                .id(document.getId())
                .registration(document.getRegistration())
                .notification(document.getNotification())
                .creationTimeStamp(document.getCreationTimeStamp())
                .status("READ")
                .build();

        this.notificationRepository.save(documentUpdate);
    }

    public List<NotificationResponseDTO> listNotifications(String registration) {
        var listToReturn = new ArrayList<NotificationResponseDTO>();
        this.notificationRepository.findByRegistrationNotReaded(registration).forEach(document -> {
            listToReturn.add(notificationMapper.toResponse(document));
        });

        return listToReturn;
    }

    private String getNotification(String eventTitle, NotificationTypeEnum notificationType) {
        switch (notificationType) {
            case SUBSCRIBE_EVENT:
                return "Você se inscreveu no evento " + eventTitle;
            case CREATE_EVENT:
                return "Você criou o evento " + eventTitle;
            case FINISH_EVENT:
                return "Você encerrou o evento " + eventTitle + ", logo seu certificado estará disponível.";
            default:
                return null;
        }
    }

}
