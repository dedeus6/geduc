package com.br.geduc.document;

import com.br.geduc.dto.enums.EventStatusEnum;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "events")
public class EventDocument {
    @Field("eventNumber")
    @Builder.Default
    private UUID eventNumber = UUID.randomUUID();

    @Field("title")
    private String title;

    @Field("description")
    private String description;

    @Field("creatorRegistration")
    private String creatorRegistration;

    @Field("start")
    private String start;

    @Field("end")
    private String end;

    @Field("status")
    private EventStatusEnum status;

    @Field("techs")
    private Set<String> techs;
}
