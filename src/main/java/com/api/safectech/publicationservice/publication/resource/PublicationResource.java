package com.api.safectech.publicationservice.publication.resource;

import com.api.safectech.publicationservice.publication.domain.model.entity.Technical;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PublicationResource {

    private String title;
    private String description;
    private String urlImage;
    private Integer technicalId;
    private Technical technical;
}
