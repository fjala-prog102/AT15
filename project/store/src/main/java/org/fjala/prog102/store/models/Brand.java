package org.fjala.prog102.store.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class Brand {
    @Id
    @Column(unique = true, nullable = false, length = 100, name = "Name")
    @NotNull(message = "Name cannot be null")
    private String name;

    @Column(name = "Description", length = 200)
    private String description;

    @Column(name = "Website", length = 100)
    private String website;
}
