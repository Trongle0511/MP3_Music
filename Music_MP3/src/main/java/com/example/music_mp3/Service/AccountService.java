package com.example.music_mp3.Service;

import com.example.music_mp3.Entity.Account;
import com.example.music_mp3.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public boolean authenticateUser(String email, String password) {
        Account account = accountRepository.findByEmail(email);
        if (account == null || password == null) {
            return false;
        }
        return BCrypt.checkpw(password, account.getHashedPassword());
    }

    public boolean isAdmin(String email) {
        Account account = accountRepository.findByEmail(email);
        return account != null && account.is_admin();
    }
}



