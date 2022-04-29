package org.fjala.prog102.store.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Client {

    @Id
    @Column(unique = true, nullable = false)
    private Long identification_number;

    @Column(name = "First_name", length = 100)
    private String first_name;

    @Column(name = "Last_name", length = 100)
    private String last_name;

    @Column(name = "Address", length = 200)
    private String address;
}
