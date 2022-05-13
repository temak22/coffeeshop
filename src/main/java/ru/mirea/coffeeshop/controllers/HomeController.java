package ru.mirea.coffeeshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mirea.coffeeshop.entities.Item;
import ru.mirea.coffeeshop.entities.User;
import ru.mirea.coffeeshop.repositories.ItemRepository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.mirea.coffeeshop.entities.Item;
import ru.mirea.coffeeshop.repositories.ItemRepository;
import java.util.Map;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/home")
    public String home(Map<String, Object> model) {
        Iterable<Item> items = itemRepository.findAll();
        model.put("items", items);
        return "home";
    }

    @GetMapping("/")
    public String homeRedirect() {
        return "redirect:/home";
    }
}
