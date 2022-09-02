package com.br.geduc.repository;

import com.br.geduc.document.EventDocument;
import com.br.geduc.dto.enums.EventStatusEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EventRepository extends MongoRepository<EventDocument, UUID> {

    List<EventDocument> findEventsByStatus(EventStatusEnum status);

    @Override
    @Query(value = "{'status': 'PENDING'}")
    Page<EventDocument> findAll(Pageable pageable);
}
