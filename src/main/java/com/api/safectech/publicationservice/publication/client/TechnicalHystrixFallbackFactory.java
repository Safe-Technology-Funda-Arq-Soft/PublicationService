package com.api.safectech.publicationservice.publication.client;

import com.api.safectech.publicationservice.publication.domain.model.entity.Technical;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class TechnicalHystrixFallbackFactory implements TechnicalClient {

    @Override
    public ResponseEntity<Technical> getById(Long technicalId) {
        Technical technical = Technical.builder()
                .firstName("none")
                .lastName("none")
                .dni("none")
                .email("none")
                .password("none")
                .address("none")
                .phone("none")
                .birthday("none")
                .aboutMe("none")
                .build();
        return ResponseEntity.ok(technical);
    }
}
