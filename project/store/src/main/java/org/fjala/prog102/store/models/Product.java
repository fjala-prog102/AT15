package org.fjala.prog102.store.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

//import com.fasterxml.jackson.annotation.JsonIdentityInfo;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
//import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "products")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "productId")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long productId;

    @Column(length = 150)
    private String name;

    @Column(length = 100)
    private String presentation;

    @Column(length = 300)
    private String description;

    @NotNull
    @Digits(integer = 9, fraction = 2)
    @Column(precision = 9, scale = 2)
    private double price;

    @NotNull
    @Column(columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "brand_name", nullable = false)
    //@EqualsAndHashCode.Exclude
    private Brand brand;

    @ManyToMany
    @JoinTable(name = "products_categories", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_name"))
    //@JsonIgnore
    //@EqualsAndHashCode.Exclude
    private Set<Category> categories;
}
