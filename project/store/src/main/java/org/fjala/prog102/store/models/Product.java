package org.fjala.prog102.store.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long product_id;

    @Column(name = "Name", length = 100)
    private String name;

    @Column(name = "Presentation", length = 150)
    private String presentation;

    @Column(name = "Description", length = 200)
    private String description;

    @Column(name = "Price")
    private int price;

    @Column(name = "Active")
    private boolean active;
}
