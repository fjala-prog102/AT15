package com.jalasoft.restfulpoc.repositories;

import java.util.List;

import com.jalasoft.restfulpoc.models.ProductModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductModel, Long>{
    public abstract List<ProductModel> findByName(String name);
}
