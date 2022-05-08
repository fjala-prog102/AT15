package org.fjala.prog102.store.services;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

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

        Product product = new Product();
        product.setActive(true);
        product.setPrice(1);
        product.setBrand(brand);
        productServices.saveProduct(product);
        assertNotNull(product);
        assertTrue(product.getCategories() == null || product.getCategories().size() == 0);
    }

    @Test
    public void saveProductTestExepction() {
        Brand brand = new Brand();
        brand.setName("Sony");
        brandServices.saveBrand(brand);

        String expectedMessage = "To create a new product, you do not have to set an ID";
        try {
            Product product = new Product();
            product.setProductId(1L);
            product.setActive(true);
            product.setPrice(1);
            product.setBrand(brand);
            productServices.saveProduct(product);
        } catch (RuntimeException myrRuntimeException) {
            assertEquals(expectedMessage, myrRuntimeException.getMessage());
        }
    }

    @Test
    public void getProductByIdTest() {
        Brand brand = new Brand();
        brand.setName("Sony");
        brandServices.saveBrand(brand);

        Product product = new Product();
        product.setActive(true);
        product.setPrice(1);
        product.setBrand(brand);
        productServices.saveProduct(product);
        Optional<Product> optional = productServices.getById(product.getProductId());
        assertNotNull(optional);
    }
}
