package com.mongo.api.service.mapper;

import com.mongo.api.domain.*;
import com.mongo.api.service.dto.PostDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Post} and its DTO {@link PostDTO}.
 */
@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface PostMapper extends EntityMapper<PostDTO, Post> {

    @Mapping(source = "author.id", target = "authorId")
    @Mapping(source = "author.login", target = "authorLogin")
    PostDTO toDto(Post post);

    @Mapping(source = "authorId", target = "author")
    Post toEntity(PostDTO postDTO);

    default Post fromId(String id) {
        if (id == null) {
            return null;
        }
        Post post = new Post();
        post.setId(id);
        return post;
    }
}
