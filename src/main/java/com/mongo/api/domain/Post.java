package com.mongo.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * A Post.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "post")
@EqualsAndHashCode(callSuper = true)
public class Post extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotNull
    @Size(min = 10, max = 50)
    @Field("title")
    private String title;

    @Size(max = 1000)
    @Field("text")
    private String text;

    @DBRef
    @Field("author")
    @JsonIgnoreProperties("posts")
    private User author;

}
