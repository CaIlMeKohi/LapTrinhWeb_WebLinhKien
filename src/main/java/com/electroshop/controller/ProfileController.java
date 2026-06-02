package com.electroshop.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.electroshop.entity.AppUser;
import com.electroshop.service.UserService;

@Controller
public class ProfileController {
    @Autowired
    private UserService userService;

    @Autowired
    private ServletContext servletContext;

    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }

    @PostMapping("/profile")
    public String update(@RequestParam String fullName,
                         @RequestParam(required = false) String phone,
                         @RequestParam(required = false) String address,
                         @RequestParam(required = false) MultipartFile avatar,
                         HttpSession session,
                         Model model) throws IOException {
        AppUser user = (AppUser) session.getAttribute("currentUser");
        if (fullName == null || fullName.trim().isEmpty()) {
            model.addAttribute("profileError", "Ho va ten khong duoc de trong");
            return "profile";
        }
        user.setFullName(fullName.trim());
        user.setPhone(phone);
        user.setAddress(address);
        if (avatar != null && !avatar.isEmpty()) {
            String uploadPath = servletContext.getRealPath("/assets/uploads");
            File uploadDirectory = new File(uploadPath);
            if (!uploadDirectory.exists()) uploadDirectory.mkdirs();
            String fileName = user.getId() + "-" + avatar.getOriginalFilename();
            avatar.transferTo(new File(uploadDirectory, fileName));
            user.setAvatarPath("/assets/uploads/" + fileName);
        }
        userService.save(user);
        session.setAttribute("currentUser", user);
        model.addAttribute("profileSuccess", "Da cap nhat thong tin");
        return "profile";
    }
}
