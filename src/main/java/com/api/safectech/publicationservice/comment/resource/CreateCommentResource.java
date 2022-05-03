package com.api.safectech.publicationservice.comment.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CreateCommentResource {
    @NotNull
    @NotBlank
    @Size(max = 250)
    private String comment;

    @NotNull
    private Integer userId;
}