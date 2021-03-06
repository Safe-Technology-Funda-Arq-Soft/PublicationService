package com.api.safectech.publicationservice.comment.api;

import com.api.safectech.publicationservice.comment.domain.service.CommentService;
import com.api.safectech.publicationservice.comment.mapping.CommentMapper;
import com.api.safectech.publicationservice.comment.resource.CommentResource;
import com.api.safectech.publicationservice.comment.resource.CreateCommentResource;
import com.api.safectech.publicationservice.comment.resource.UpdateCommentResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Comment")
@RestController
@RequestMapping("/api/v1/comments")
@CrossOrigin
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentMapper mapper;

    @Operation(summary = "Get Comments", description = "Get All Comments")
    @GetMapping
    public List<CommentResource> getAllCommentary()
    {
        return mapper.toResource(commentService.getAll());
    }

    @Operation(summary = "Get Comment by Id", description = "Get Comment by Id")
    @GetMapping("{commentId}")
    public CommentResource getCommentById(@PathVariable Long commentId)
    {
        return mapper.toResource(commentService.getById(commentId));
    }

    @Operation(summary = "Create Comment", description = "Create Comment")
    @PostMapping("publications/{publicationId}")
    public CommentResource createComment(@Valid @RequestBody CreateCommentResource request, @PathVariable Long publicationId)
    {
        return mapper.toResource(commentService.create(mapper.toModel(request), publicationId));
    }

    @Operation(summary = "Update Comment", description = "Update Comment by Id ")
    @PutMapping("{commentId}")
    public CommentResource updateComment(@PathVariable Long commentId, @Valid @RequestBody UpdateCommentResource request)
    {
        return mapper.toResource(commentService.update(commentId, mapper.toModel(request)));
    }

    @Operation(summary = "Delete Comment", description = "Delete Comment by Id")
    @DeleteMapping("{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable Long commentId)
    {
        return commentService.delete(commentId);
    }

    @Operation(summary = "Get Commentary by publication Id", description = "Get Commentary by publication Id")
    @GetMapping("publication/{publicationId}")
    public List<CommentResource> getCommentaryByPublication(@PathVariable Long publicationId)
    {
        return mapper.toResource(commentService.getByPublicationId(publicationId));
    }

    @Operation(summary = "Get Commentary by user Id", description = "Get Commentary by user Id")
    @GetMapping("user/{userId}")
    public List<CommentResource> getCommentaryByUser(@PathVariable Long userId)
    {
        return mapper.toResource(commentService.getByUserId(userId));
    }

}
