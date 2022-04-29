package org.fjala.prog102.store.models;

import java.sql.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long discountId;
    private double percentage;
    private Date startDate;
    private Date endDate;
    private String description;
}
