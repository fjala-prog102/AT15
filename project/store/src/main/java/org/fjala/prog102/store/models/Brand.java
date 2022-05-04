package org.fjala.prog102.store.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "brands")
public class Brand {
    @Id
    @Column(unique = true, nullable = false, length = 100)
    private String name;

    @Column(length = 200)
    private String description;

    @Column(length = 100)
    private String website;

    @OneToMany(mappedBy = "brand")
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    private Set<Product> products;
}
