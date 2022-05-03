package com.api.safectech.publicationservice.tag.mapping;

import com.api.safectech.publicationservice.shared.mapping.EnhancedModelMapper;
import com.api.safectech.publicationservice.tag.domain.model.entity.Tag;
import com.api.safectech.publicationservice.tag.resource.CreateTagResource;
import com.api.safectech.publicationservice.tag.resource.TagResource;
import com.api.safectech.publicationservice.tag.resource.UpdateTagResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TagMapper {

    @Autowired
    private EnhancedModelMapper mapper;

    public TagResource toResource(Tag model) { return mapper.map(model, TagResource.class);
    }
    public List<TagResource> toResource(List<Tag> model)
    {
        return mapper.mapList(model, TagResource.class);
    }

    public Tag toModel(CreateTagResource resource)
    {
        return mapper.map(resource, Tag.class);
    }

    public Tag toModel(UpdateTagResource resource)
    {
        return mapper.map(resource, Tag.class);
    }

}