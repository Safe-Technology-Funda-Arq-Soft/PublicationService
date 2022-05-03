package com.api.safectech.publicationservice.publication.domain.service;

import com.api.safectech.publicationservice.publication.domain.model.entity.Publication;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PublicationService {
    List<Publication> getAll();
    Publication getById(Long publicationId);
    Publication create(Publication publication);
    Publication update(Long publicationId, Publication request);
    ResponseEntity<?> delete(Long publicationId);
    List<Publication> getByTechnicalId(Integer technicalId);


}
