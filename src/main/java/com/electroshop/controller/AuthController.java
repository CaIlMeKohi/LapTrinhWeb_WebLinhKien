package com.electroshop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.electroshop.controller.form.LoginForm;
import com.electroshop.controller.form.RegisterForm;
import com.electroshop.entity.AppUser;
import com.electroshop.service.UserService;

@Controller
public class AuthController {
    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @InitBinder({"loginForm", "registerForm"})
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(new AuthFormValidator());
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("registerForm", new RegisterForm());
        return "register";
    }

    @PostMapping("/register")
    public String register(@Validated @ModelAttribute("registerForm") RegisterForm form,
                           BindingResult bindingResult,
                           HttpSession session,
                           Model model) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        if (userService.findByEmail(form.getEmail()) != null) {
            model.addAttribute("emailExists", "Email da duoc su dung");
            return "register";
        }
        AppUser user = new AppUser(form.getEmail().trim(), form.getFullName().trim(), form.getPassword());
        userService.save(user);
        session.setAttribute("currentUser", user);
        if ("ADMIN".equals(user.getRole())) return "redirect:/admin/dashboard";
        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginPage(@RequestParam(name = "redirectUrl", required = false) String redirectUrl, Model model) {
        model.addAttribute("loginForm", new LoginForm());
        model.addAttribute("redirectUrl", redirectUrl);
        return "login";
    }

    @PostMapping("/login")
    public String login(@Validated @ModelAttribute("loginForm") LoginForm form,
                        BindingResult bindingResult,
                        @RequestParam(name = "redirectUrl", required = false) String redirectUrl,
                        HttpSession session,
                        Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("redirectUrl", redirectUrl);
            return "login";
        }
        AppUser user = userService.authenticate(form.getEmail(), form.getPassword());
        if (user == null) {
            model.addAttribute("generalError", "Email hoac mat khau khong dung");
            return "login";
        }
        session.setAttribute("currentUser", user);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
