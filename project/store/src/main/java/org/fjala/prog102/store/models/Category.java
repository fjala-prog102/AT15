package org.fjala.prog102.store.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonIdentityInfo;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
//import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "categories")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "name")
public class Category {
    @Id
    @Column(unique = true, nullable = false)
    private String name;

    @Column(length = 300)
    private String description;

    @ManyToMany(mappedBy = "categories")
    //@JsonIgnore
    //@EqualsAndHashCode.Exclude
    private Set<Product> products;
}