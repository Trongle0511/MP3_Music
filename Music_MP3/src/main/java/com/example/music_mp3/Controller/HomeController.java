package com.example.music_mp3.Controller;

import com.example.music_mp3.Entity.AccountsEntity;
import com.example.music_mp3.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @GetMapping("/MusicMp3")
    public String Home() {

        return "Home/index";
    }
    @Autowired
    private AccountService authService;

//    @Autowired
//    private AccountService accountService;

    @GetMapping("/login")
    public String login(Model model) {
        AccountsEntity account = new AccountsEntity();
        model.addAttribute("account", account);
        return "Admin/auth/login";
    }

    @PostMapping("/submitLogin")
    public String submitLogin(@RequestParam("email") String email,
                              @RequestParam("hashedPassword") String password,
                              Model model) {
        if (authService.authenticateUser(email, password)) {
            if (authService.isAdmin(email)) {
                // Đăng nhập thành công cho vai trò admin
                return "redirect:/admin";
            } else {
                // Đăng nhập thành công cho vai trò user
                return "redirect:/MusicMp3";
            }
        } else {
            // Đăng nhập thất bại
            model.addAttribute("error", "Invalid email or password");
            model.addAttribute("account", new AccountsEntity());
            return "redirect:/login";
        }
    }



    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("account", new AccountsEntity());
        return "Admin/auth/register";
    }

    @PostMapping("/submitRegister")
    public String registerUser(@RequestParam("username") String username,
                               @RequestParam("email") String email,
                               @RequestParam("password") String password,
                               @RequestParam("passwordConfirmation") String passwordConfirmation,
                               @RequestParam("acceptTerms") boolean acceptTerms,
                               Model model) {
        if (!password.equals(passwordConfirmation)) {
            model.addAttribute("errorMessage", "Passwords do not match!");
            return "Admin/auth/register";
        }
        if (!acceptTerms) {
            model.addAttribute("errorMessage", "You must accept the terms and conditions!");
            return "Admin/auth/register";
        }
        try {
            authService.registerUser(username, email, password);
            model.addAttribute("successMessage", "Registration successful!");
            return "redirect:/login";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Registration failed: " + e.getMessage());
            return "Admin/auth/register";
        }
    }


    @GetMapping("/forgot-password")
    public String forgotpassword() {

        return "Admin/auth/forgot-password";
    }
    @GetMapping("/reset")
    public String reset() {

        return "Admin/auth/reset-password";
    }
    @GetMapping("/detail")
    public String detail() {

        return "Home/SinglePlaylistScreen";
    }
}
