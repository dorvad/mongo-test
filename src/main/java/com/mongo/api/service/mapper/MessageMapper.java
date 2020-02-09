package com.mongo.api.service.mapper;

import com.mongo.api.domain.*;
import com.mongo.api.service.dto.MessageDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Message} and its DTO {@link MessageDTO}.
 */
@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface MessageMapper extends EntityMapper<MessageDTO, Message> {

    @Mapping(source = "author.id", target = "authorId")
    @Mapping(source = "author.login", target = "authorLogin")
    @Mapping(source = "recipient.id", target = "recipientId")
    @Mapping(source = "recipient.login", target = "recipientLogin")
    MessageDTO toDto(Message message);

    @Mapping(source = "authorId", target = "author")
    @Mapping(source = "recipientId", target = "recipient")
    Message toEntity(MessageDTO messageDTO);

    default Message fromId(String id) {
        if (id == null) {
            return null;
        }
        Message message = new Message();
        message.setId(id);
        return message;
    }
}
