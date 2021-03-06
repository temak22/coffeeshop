package ru.mirea.coffeeshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.mirea.coffeeshop.entities.Role;
import ru.mirea.coffeeshop.entities.User;
import ru.mirea.coffeeshop.services.UserService;

import java.util.Collections;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Model model) {
        User userFromDB = userService.getUserByUsername(user.getUsername());

        if (userFromDB != null) {
            model.addAttribute("message", "*User with this name exists!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userService.saveUser(user);

        model.addAttribute("message", "User was created!");
        return "redirect:/login";
    }
}
