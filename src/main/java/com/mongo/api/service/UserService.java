package com.mongo.api.service;

import com.mongo.api.domain.User;
import com.mongo.api.service.dto.UserDTO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Service class for managing users.
 */
//@Slf4j
//@Service
//@RequiredArgsConstructor
public interface UserService {

//    private final UserRepository userRepository;
//
//    private final PasswordEncoder passwordEncoder;
//
//    private final AuthorityRepository authorityRepository;

    Optional<User> activateRegistration(String key);

    Optional<User> completePasswordReset(String newPassword, String key);

    Optional<User> requestPasswordReset(String mail);

    User registerUser(UserDTO userDTO, String password);

//    private boolean removeNonActivatedUser(User existingUser){
//        if (existingUser.isActivated()) {
//             return false;
//        }
//        userRepository.delete(existingUser);
//        return true;
//    }

    User createUser(UserDTO userDTO);

    /**
     * Update basic information (first name, last name, email, language) for the current user.
     *
     * @param firstName first name of user.
     * @param lastName  last name of user.
     * @param email     email id of user.
     * @param langKey   language key.
     * @param imageUrl  image URL of user.
     */
    void updateUser(String firstName, String lastName, String email, String langKey, String imageUrl);

    /**
     * Update all information for a specific user, and return the modified user.
     *
     * @param userDTO user to update.
     * @return updated user.
     */
    Optional<UserDTO> updateUser(UserDTO userDTO);

    void deleteUser(String login);

    void changePassword(String currentClearTextPassword, String newPassword);

    Page<UserDTO> getAllManagedUsers(Pageable pageable);

    Optional<User> getUserWithAuthoritiesByLogin(String login);

    Optional<User> getUserWithAuthorities(String id);

    Optional<User> getUserWithAuthorities();

    /**
     * Not activated users should be automatically deleted after 3 days.
     * <p>
     * This is scheduled to get fired everyday, at 01:00 (am).
     */
    @Scheduled(cron = "0 0 1 * * ?")
    void removeNotActivatedUsers();

    /**
     * Gets a list of all the authorities.
     *
     * @return a list of all the authorities.
     */
    List<String> getAuthorities();

}
