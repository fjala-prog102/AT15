package org.fjala.prog102.store.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Brand {

    @Id
    @Column(unique = true, nullable = false, length = 100, name = "Name")
    private String name;

    @Column(name = "Description", length = 200)
    private String description;
}
