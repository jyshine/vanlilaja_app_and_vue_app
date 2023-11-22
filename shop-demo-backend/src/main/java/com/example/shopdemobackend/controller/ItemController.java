package com.example.shopdemobackend.controller;

import com.example.shopdemobackend.entity.Item;
import com.example.shopdemobackend.repository.ItemRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ItemController {
    private final ItemRepository itemRepository;

    @GetMapping("/api/items")
    public List<Item> getItems() {
        return itemRepository.findAll();
    }
}
