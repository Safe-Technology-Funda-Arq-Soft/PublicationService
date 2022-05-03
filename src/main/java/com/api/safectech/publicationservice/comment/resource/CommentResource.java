package com.api.safectech.publicationservice.comment.resource;

import com.api.safectech.publicationservice.publication.resource.PublicationResource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentResource {
    private Long id;
    private String comment;
    private Integer userId;
    private PublicationResource publication;
}
