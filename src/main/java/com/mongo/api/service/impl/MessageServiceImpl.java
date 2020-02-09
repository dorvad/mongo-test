package com.mongo.api.service.impl;

import com.mongo.api.security.SecurityUtils;
import com.mongo.api.service.MessageService;
import com.mongo.api.domain.Message;
import com.mongo.api.repository.MessageRepository;
import com.mongo.api.service.dto.MessageDTO;
import com.mongo.api.service.mapper.MessageMapper;
import com.mongo.api.web.rest.errors.BadRequestAlertException;
import com.mongo.api.web.rest.errors.ErrorConstants;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Message}.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageMapper messageMapper;

    private final MessageRepository messageRepository;

    /**
     * Save a message.
     *
     * @param messageDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public MessageDTO save(MessageDTO messageDTO) {
        log.debug("Request to save Message : {}", messageDTO);
        Message message = messageMapper.toEntity(messageDTO);
        message = messageRepository.save(message);
        return messageMapper.toDto(message);
    }

    /**
     * Get all the messages.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    public Page<MessageDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Messages");
        return messageRepository.findAll(pageable)
            .map(this::mapLoadedMessagesToDto);
    }


    /**
     * Get one message by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    public Optional<MessageDTO> findOne(String id) {
        log.debug("Request to get Message : {}", id);
        messageRepository.findById(id);
        return messageRepository.findById(id)
            .map(this::mapLoadedMessagesToDto);
    }

    private MessageDTO mapLoadedMessagesToDto(Message message){
        String currentUserLogin = SecurityUtils.getCurrentUserLogin()
            .orElseThrow(() -> new BadRequestAlertException(ErrorConstants.USER_NOT_AUTHORIZED,
                "User is not authorized!", "userManagement", "userdoesnotexists"));
        if(!message.getIsRead() && message.getRecipient().getLogin().equals(currentUserLogin)){
            message.setIsRead(true);
            messageRepository.save(message);
        }
        return messageMapper.toDto(message);
    }

    /**
     * Delete the message by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete Message : {}", id);
        messageRepository.deleteById(id);
    }
}
