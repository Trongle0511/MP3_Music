package com.example.music_mp3.Service;

import com.example.music_mp3.Entity.User;
import com.example.music_mp3.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void createPasswordResetTokenForUser(User user, String token) {
        user.setResetToken(token);
        userRepository.save(user);
    }

    public User findUserByResetToken(String resetToken) {
        return userRepository.findByResetToken(resetToken);
    }

    public void changeUserPassword(User user, String password) {
        user.setPassword(password);
        user.setResetToken(null); // Xóa token sau khi đổi mật khẩu
        userRepository.save(user);
    }
}

