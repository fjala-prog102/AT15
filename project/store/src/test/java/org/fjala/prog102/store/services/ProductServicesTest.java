package org.fjala.prog102.store.services;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.fjala.prog102.store.models.Brand;
import org.fjala.prog102.store.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductServicesTest {

    @Autowired
    private ProductServices productServices;
    @Autowired
    private BrandServices brandServices;

    @Test
    public void getProductsTest() {
        List<Product> products = productServices.getProducts();
        assertNotNull(products);
        assertTrue(products.size() >= 0);
    }

    @Test
    public void saveProductTest() {
        Brand brand = new Brand();
        brand.setName("Sony");
        brandServices.saveBrand(brand);

        final long productId = 7777L;

        Product product = new Product();
        product.setProductId(productId);
        product.setActive(true);
        product.setPrice(1);
        product.setBrand(brand);
        productServices.saveProduct(product);
        assertNotNull(product);
        assertTrue(product.getCategories() == null || product.getCategories().size() == 0);
    }
}
