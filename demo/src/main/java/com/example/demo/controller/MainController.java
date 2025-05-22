package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Item;
import com.example.demo.model.Store;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.StoreRepository;

import jakarta.annotation.PostConstruct;

@Controller
public class MainController {
	@Autowired
    private ItemRepository itemRepository;

    @Autowired
    private StoreRepository storeRepository;

    @PostConstruct
    public void init() {
        if (storeRepository.count() == 0) {
            storeRepository.save(new Store("Super King"));
            storeRepository.save(new Store("Costco"));
        }
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "index";
    }

    @GetMapping("/addItem")
    public String addItemForm(Model model) {
        List<Store> stores = storeRepository.findAll();
        model.addAttribute("stores", stores);
        model.addAttribute("item", new Item());
        return "addItem";
    }

    @PostMapping("/addItem")
    public String addItem(@ModelAttribute Item item, @RequestParam("storeName") String storeName, @RequestParam("newStoreName") String newStoreName) {
        Store store;
        if (!newStoreName.isEmpty()) {
            store = new Store(newStoreName);
            storeRepository.save(store);
        } else {
        	Long storeId = Long.parseLong(storeName);
            store = storeRepository.findById(storeId).orElseThrow();
        }
        item.setStore(store);
        itemRepository.save(item);
        return "redirect:/";
    }

    @GetMapping("/deleteItem/{id}")
    public String deleteItem(@PathVariable Integer id) {
        itemRepository.deleteById(id);
        return "redirect:/";
    }
}