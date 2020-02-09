package com.mongo.api.service.dto;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.mongo.api.domain.Post} entity.
 */
public class PostDTO implements Serializable {

    private String id;

    @NotNull
    @Size(min = 10, max = 50)
    private String title;

    @Size(max = 1000)
    private String text;


    private String authorId;

    private String authorLogin;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String userId) {
        this.authorId = userId;
    }

    public String getAuthorLogin() {
        return authorLogin;
    }

    public void setAuthorLogin(String userLogin) {
        this.authorLogin = userLogin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PostDTO postDTO = (PostDTO) o;
        if (postDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), postDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PostDTO{" +
            "id=" + getId() +
            ", title='" + getTitle() + "'" +
            ", text='" + getText() + "'" +
            ", author=" + getAuthorId() +
            ", author='" + getAuthorLogin() + "'" +
            "}";
    }
}
