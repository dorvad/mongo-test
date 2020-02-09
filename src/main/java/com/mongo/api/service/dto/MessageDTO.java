package com.mongo.api.service.dto;
import java.time.ZonedDateTime;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A DTO for the {@link com.mongo.api.domain.Message} entity.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO implements Serializable {

    private String id;

    @NotNull
    @Size(max = 255)
    private String text;

    @NotNull
    private Boolean isRead = false;

    @NotNull
    private ZonedDateTime date = ZonedDateTime.now();

    private String authorId;

    private String authorLogin;

    private String recipientId;

    private String recipientLogin;

}
