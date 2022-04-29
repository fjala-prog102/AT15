package org.fjala.prog102.store.models;

import java.sql.Date;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long discountId;

    @Min(value = 0)
    @Max(value = 1)
    private double percentage;

    @NotNull
    private Date startDate;

    @NotNull
    private Date endDate;

    @NotEmpty
    private String description;
}
