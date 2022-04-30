package org.fjala.prog102.store.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long productId;

    @Column(name = "Name", length = 150)
    private String name;

    @Column(name = "Presentation", length = 100)
    private String presentation;

    @Column(name = "Description", length = 300)
    private String description;

    @NotNull
    @Digits(integer=9, fraction=2)
    @Column(name = "Price", precision = 9, scale = 2)
    private double price;

    @NotNull
    @Column(name = "Active", columnDefinition = "boolean default true")
    private Boolean active;
}
