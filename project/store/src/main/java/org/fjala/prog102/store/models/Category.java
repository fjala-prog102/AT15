package org.fjala.prog102.store.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "category")
public class Category {
    @Id
    @Column(unique = true, nullable = false, name = "Name")
    private String name;
    @Column(name = "Description")
    private String description;
}
