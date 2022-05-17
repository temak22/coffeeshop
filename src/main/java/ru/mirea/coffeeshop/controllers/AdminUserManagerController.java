package ru.mirea.coffeeshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mirea.coffeeshop.entities.Role;
import ru.mirea.coffeeshop.entities.User;
import ru.mirea.coffeeshop.services.UserService;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminUserManagerController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public String userList(Model model) {
        try {
            model.addAttribute("users", userService.getAllUsers());
            return "userList";
        } catch (Exception e) {
            String errorTitle = "Ошибка 403";
            String errorMessage = "Ошибка доступа! Вернитесь на предыдущую страницу.";
            model.addAttribute("errorTitle", errorTitle);
            model.addAttribute("errorMessage", errorMessage);
            return "error";
        }
    }

    @GetMapping("/{user}")
    public String userEdit(@PathVariable User user, Model model) {
        try {
            model.addAttribute("user", user);
            model.addAttribute("roles", Role.values());
            return "userEdit";
        } catch (Exception e) {
            String errorTitle = "Ошибка 403";
            String errorMessage = "Ошибка доступа! Вернитесь на предыдущую страницу.";
            model.addAttribute("errorTitle", errorTitle);
            model.addAttribute("errorMessage", errorMessage);
            return "error";
        }
    }

    @PostMapping("")
    public String userSave(
            @RequestParam("userId") User user,
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            Model model) {
        try {
            user.setUsername(username);

            Set<String> roles = Arrays.stream(Role.values())
                    .map(Role::name)
                    .collect(Collectors.toSet());

            user.getRoles().clear();
            user.getRoles().add(Role.USER);
            for (String key : form.keySet()) {
                if (roles.contains(key)) {
                    user.getRoles().add(Role.valueOf(key));
                }
            }
            userService.saveUser(user);
            return "redirect:/admin/user";
        } catch (Exception e) {
            String errorTitle = "Ошибка 403";
            String errorMessage = "Ошибка доступа! Вернитесь на предыдущую страницу.";
            model.addAttribute("errorTitle", errorTitle);
            model.addAttribute("errorMessage", errorMessage);
            return "error";
        }
    }
}
