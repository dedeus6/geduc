package com.br.geduc.repository;

import com.br.geduc.document.SubscribeDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SubscriberRepository extends MongoRepository<SubscribeDocument, String> {

    SubscribeDocument findByEventNumberAndRegistration(String eventNumber, String registration);

    List<SubscribeDocument> findByRegistration(String registration);
}
