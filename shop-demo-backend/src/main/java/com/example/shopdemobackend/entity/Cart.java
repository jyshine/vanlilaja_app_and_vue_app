package com.example.shopdemobackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CART")
public class Cart {

    @Id
    @GeneratedValue
    private Long id;

    private String memberId;

    private String itemId;

}
