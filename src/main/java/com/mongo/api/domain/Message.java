package com.mongo.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * A Message.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "message")
@EqualsAndHashCode(callSuper = true)
public class Message extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotNull
    @Field("text")
    @Size(max = 255)
    private String text;

    @NotNull
    @Field("is_read")
    private Boolean isRead = false;

    @NotNull
    @Field("date")
    @Setter(AccessLevel.PRIVATE)
    private ZonedDateTime date = ZonedDateTime.now();

    @DBRef
    @Field("author")
    @JsonIgnoreProperties("messages")
    private User author;

    @DBRef
    @Field("recipient")
    @JsonIgnoreProperties("messages")
    private User recipient;

}
