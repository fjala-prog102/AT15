package org.fjala.prog102.store.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.fjala.prog102.store.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, String> {

    public abstract List<Category> findByName(String name);

    public abstract List<Category> deleteByName(String name);

}
