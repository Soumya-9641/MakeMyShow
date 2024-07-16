package com.makemyshow.authentication.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.makemyshow.authentication.dto.UserRequestDTO;
import com.makemyshow.authentication.models.User;
import com.makemyshow.authentication.models.VerificationToken;

@Service
public interface UserService {
    User registerUser(UserRequestDTO user);

    void saveVerificationTokenForUser(String token, User user);

    String validateVerificationToken(String token);

    VerificationToken generateNewVerificationToken(String oldToken);

    User findUserByEmail(String email);

    void createPasswordResetTokenForUser(User user, String token);

    String validatePasswordResetToken(String token);

    Optional<User> getUserByPasswordResetToken(String token);

    void changePassword(User user, String newPassword);

    boolean checkIfValidOldPassword(User user, String oldPassword);
}
