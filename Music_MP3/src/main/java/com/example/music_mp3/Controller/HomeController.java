package com.example.music_mp3.Controller;

import com.example.music_mp3.Entity.Account;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;

@Controller
public class HomeController {
    @GetMapping("/MusicMp3")
    public String Home() {

        return "Home/index";
    }
    @GetMapping("/login")
    public String login(Model model) {
        Account account = new Account();
        model.addAttribute("account", account);
        return "Admin/auth/login";
    }
    @PostMapping("/submitLogin")
    public String submitLogin(@ModelAttribute("account") Account account, Model model){
        model.addAttribute("account", account);
        return "redirect:/MusicMp3";
    }
}
