package ru.mirea.coffeeshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.mirea.coffeeshop.entities.Item;
import ru.mirea.coffeeshop.repositories.ItemRepository;

import java.util.Map;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminHomeController {
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/home")
    public String home(Map<String, Object> model) {
        Iterable<Item> items = itemRepository.findAll();
        model.put("items", items);
        return "adminHome";
    }

    @GetMapping("/")
    public String homeRedirect() {
        return "redirect:/admin/home";
    }

    @PostMapping("/home")
    public String addItem(
            @RequestParam String title,
            @RequestParam int cost,
            @RequestParam String description,
            Map<String, Object> model) {

        Item item = new Item(title, cost, description);
        itemRepository.save(item);

        Iterable<Item> items = itemRepository.findAll();
        model.put("items", items);
        return "adminHome";
    }
}
