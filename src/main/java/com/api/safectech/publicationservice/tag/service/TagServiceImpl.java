package com.api.safectech.publicationservice.tag.service;

import com.api.safectech.publicationservice.publication.domain.model.entity.Publication;
import com.api.safectech.publicationservice.publication.domain.persistence.PublicationRepository;
import com.api.safectech.publicationservice.shared.exception.ResourceNotFoundException;
import com.api.safectech.publicationservice.tag.domain.model.entity.Tag;
import com.api.safectech.publicationservice.tag.domain.persistence.TagRepository;
import com.api.safectech.publicationservice.tag.domain.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    private final static String ENTITY = "Tag";

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private PublicationRepository publicationRepository;

    @Override
    public List<Tag> getAll() { return tagRepository.findAll();}

    @Override
    public Tag getById(Long tagId) {
        return tagRepository.findById(tagId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, tagId));
    }

    @Override
    public Tag create(Tag tag, Long publicationId) {
        Publication publication = publicationRepository.findById(publicationId)
                .orElseThrow(() -> new ResourceNotFoundException("Publication not found with Id" + publicationId));

        tag.setPublication(publication);
        return tagRepository.save(tag);
    }
    @Override
    public Tag update(Long tagId, Tag request) {
        return tagRepository.findById(tagId).map(comment ->
                        tagRepository.save(comment
                                .withTag(request.getTag())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY,tagId));
    }

    @Override
    public ResponseEntity<?> delete(Long tagId) {
        return tagRepository.findById(tagId).map(tag -> {
            tagRepository.delete(tag);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, tagId));
    }
    @Override
    public List<Tag> getByPublicationId(Long publicationId) {
        return tagRepository.findByPublicationId(publicationId);
    }

}