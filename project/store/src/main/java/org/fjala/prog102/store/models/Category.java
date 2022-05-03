package org.fjala.prog102.store.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @Column(unique = true, nullable = false)
    private String name;

    @Column(length = 300)
    private String description;
}