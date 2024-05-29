package com.example.music_mp3.Service;

import com.example.music_mp3.Entity.AccountsEntity;
import com.example.music_mp3.Repository.AccountRepository;
import com.example.music_mp3.utils.PasswordEncoderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public boolean authenticateUser(String email, String password) {
        AccountsEntity account = accountRepository.findByEmail(email);
        if (account == null || password == null) {
            return false;
        }
        return BCrypt.checkpw(password, account.getHashedPassword());
    }

    public boolean isAdmin(String email) {
        AccountsEntity account = accountRepository.findByEmail(email);
        return account != null && account.getRole();
    }

    @Transactional
    public void registerUser(String username, String email, String password) {
        // Kiểm tra xem email đã được sử dụng chưa
        if (accountRepository.findByEmail(email) != null) {
            throw new RuntimeException("Email đã tồn tại trong hệ thống");
        }

        // Mã hóa mật khẩu trước khi lưu vào cơ sở dữ liệu
        String hashedPassword = PasswordEncoderUtil.encodePassword(password);

        // Tạo một đối tượng Account mới
        AccountsEntity account = new AccountsEntity();
        account.setUsername(username);
        account.setEmail(email);
        account.setHashedPassword(hashedPassword);
        account.setRole(false); // Mặc định vai trò là người dùng

        // Lưu tài khoản vào cơ sở dữ liệu
        accountRepository.save(account);
    }
}



