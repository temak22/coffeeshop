package ru.mirea.coffeeshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.mirea.coffeeshop.entities.Item;
import ru.mirea.coffeeshop.services.ItemService;

import java.util.Map;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminHomeController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/home")
    public String home(Map<String, Object> model) {
        Iterable<Item> items = itemService.getAllItems();
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
        itemService.saveItem(item);

        Iterable<Item> items = itemService.getAllItems();
        model.put("items", items);
        return "adminHome";
    }
}
