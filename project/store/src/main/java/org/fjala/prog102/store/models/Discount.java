package org.fjala.prog102.store.models;

import java.sql.Date;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "discounts")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long discountId;

    @Min(value = 0)
    @Max(value = 1)
    @NotNull
    private double percentage;

    @NotNull
    private Date startDate;

    @NotNull
    private Date endDate;

    @NotEmpty
    private String description;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = true)
    @EqualsAndHashCode.Exclude
    private Product product;

    @ManyToOne
    @JoinColumn(name = "brand_name", nullable = true)
    @EqualsAndHashCode.Exclude
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "category_name", nullable = true)
    @EqualsAndHashCode.Exclude
    private Category category;
}
