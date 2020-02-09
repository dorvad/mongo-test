package com.mongo.api.service.dto;

import com.mongo.api.config.Constants;

import com.mongo.api.domain.Authority;
import com.mongo.api.domain.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.*;
import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * A DTO representing a user, with his authorities.
 */
@Data
@Builder
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class UserDTO {

    private String id;

    @NotBlank
    @Size(min = 1, max = 50)
    @Pattern(regexp = Constants.LOGIN_REGEX)
    private String login;

    @Size(max = 50)
    private String firstName;

    @Size(max = 50)
    private String lastName;

    @Email
    @Size(min = 5, max = 254)
    private String email;

    @Size(max = 256)
    private String imageUrl;

    private boolean activated = false;

    @Size(min = 2, max = 10)
    private String langKey;

    private String createdBy;

    private Instant createdDate;

    private String lastModifiedBy;

    private Instant lastModifiedDate;

    private Set<String> authorities;

    public static UserDTO toDTO(User user){
        return UserDTO.builder()
            .id(user.getId())
            .login(user.getLogin())
            .firstName(user.getFirstName())
            .lastName(user.getLastName())
            .email(user.getEmail())
            .activated(user.isActivated())
            .imageUrl(user.getImageUrl())
            .langKey(user.getLangKey())
            .createdBy(user.getCreatedBy())
            .createdDate(user.getCreatedDate())
            .lastModifiedBy(user.getLastModifiedBy())
            .lastModifiedDate(user.getLastModifiedDate())
            .authorities(user.getAuthorities().stream()
                .map(Authority::getName)
                .collect(Collectors.toSet()))
            .build();
    }

}
