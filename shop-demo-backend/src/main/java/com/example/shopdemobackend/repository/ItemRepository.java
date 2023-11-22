package com.example.shopdemobackend.repository;


import com.example.shopdemobackend.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
