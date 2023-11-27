package com.example.shopdemobackend.repository;


import com.example.shopdemobackend.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
