package org.fjala.prog102.store.controllers;

import java.util.List;

import org.fjala.prog102.store.models.Brand;
import org.fjala.prog102.store.services.BrandServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private BrandServices brandServices;

    @GetMapping
    public List<Brand> getBrands() {
        return brandServices.getBrands();
    }

    @PostMapping
    public Brand saveBrand(@RequestBody Brand brand) {
        return brandServices.saveBrand(brand);
    }
}
