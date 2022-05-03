package com.api.safectech.publicationservice.comment.mapping;

import com.api.safectech.publicationservice.comment.domain.model.entity.Comment;
import com.api.safectech.publicationservice.comment.resource.CommentResource;
import com.api.safectech.publicationservice.comment.resource.CreateCommentResource;
import com.api.safectech.publicationservice.comment.resource.UpdateCommentResource;
import com.api.safectech.publicationservice.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommentMapper {

    @Autowired
    private EnhancedModelMapper mapper;

    // Object Mapping
    public CommentResource toResource(Comment model)
    {
        return mapper.map(model, CommentResource.class);
    }

    public List<CommentResource> toResource(List<Comment> model)
    {
        return mapper.mapList(model, CommentResource.class);
    }

    public Comment toModel(CreateCommentResource resource)
    {
        return mapper.map(resource, Comment.class);
    }

    public Comment toModel(UpdateCommentResource resource)
    {
        return mapper.map(resource, Comment.class);
    }

}