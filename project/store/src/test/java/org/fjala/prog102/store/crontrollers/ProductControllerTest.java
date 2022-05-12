package org.fjala.prog102.store.crontrollers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.contains;

import org.fjala.prog102.store.models.Brand;
import org.fjala.prog102.store.models.Product;
import org.fjala.prog102.store.services.BrandServices;
import org.fjala.prog102.store.services.ProductServices;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BrandServices brandServices;
    @Autowired
    private ProductServices productServices;

    @Test
    public void itShouldListProducts() throws Exception {
        this.mockMvc.perform(get("/products"))
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Test
    public void itShouldCreateAProduct() throws Exception {
        Brand brand = new Brand();
        brand.setName("Vital");
        brandServices.saveBrand(brand);

        String stringBody = "{";
        stringBody += "\"name\":\"Agua\",";
        stringBody += "\"price\":6,";
        stringBody += "\"active\":true,";
        stringBody += "\"brand\": {";
        stringBody += "\"name\":\"Vital\"";
        stringBody += "}";
        stringBody += "}";

        this.mockMvc.perform(
            post("/products")
            .content(stringBody)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isCreated());
    }

    @Test void itShouldNotCreateAProductWithGivenId() throws Exception {
        String stringBody = "{";
        stringBody += "\"productId\":789,";
        stringBody += "\"name\":\"Agua\",";
        stringBody += "\"price\":6,";
        stringBody += "\"active\":true,";
        stringBody += "\"brand\": {";
        stringBody += "\"name\":\"Vital\"";
        stringBody += "}";
        stringBody += "}";
        this.mockMvc.perform(
            post("/products")
            .content(stringBody)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNotFound())
            .andExpect(content().string(contains("To create a new product, you do not have to set an ID")));
    }

    @Test
    public void itShouldUpdateAProduct() throws Exception {
        Brand brand = new Brand();
        brand.setName("Vital");
        brandServices.saveBrand(brand);

        Product product = new Product();
        product.setName("Agua");
        product.setActive(true);
        product.setPrice(1);
        product.setBrand(brand);
        productServices.saveProduct(product);

        String updateBody = "{";
        updateBody += "\"productId\":" + product.getProductId() + ",";
        updateBody += "\"name\":\"Agua Mineral\",";
        updateBody += "\"price\":6,";
        updateBody += "\"active\":true,";
        updateBody += "\"brand\": {";
        updateBody += "\"name\":\"Vital\"";
        updateBody += "}";
        updateBody += "}";

        this.mockMvc.perform(
            put("/products")
            .content(updateBody)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    }

    @Test
    public void itShouldNotUpdateAProductWithUnexistingId() throws Exception{
        String updateBody = "{";
        updateBody += "\"productId\":88,";
        updateBody += "\"name\":\"Agua Mineral\",";
        updateBody += "\"price\":6,";
        updateBody += "\"active\":true,";
        updateBody += "\"brand\": {";
        updateBody += "\"name\":\"Vital\"";
        updateBody += "}";
        updateBody += "}";

        this.mockMvc.perform(
            put("/products")
            .content(updateBody)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNotFound())
            .andExpect(content().string(contains("The providen Product does not exists")));
    }

    @Test
    public void itShouldGetAProductById() throws Exception {
        Brand brand = new Brand();
        brand.setName("Vital");
        brandServices.saveBrand(brand);

        Product product = new Product();
        product.setName("Agua Mineral");
        product.setActive(true);
        product.setPrice(1);
        product.setBrand(brand);
        productServices.saveProduct(product);

        this.mockMvc.perform(get("/products/" + product.getProductId()))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("Agua Mineral")));
    }

    @Test
    public void itShouldDeleteAProductById() throws Exception {
        this.mockMvc.perform(delete("/products/1000"))
        .andDo(print())
        .andExpect(status().isNotFound())
        .andExpect(content().string(contains("The product with the providen id was not found")));

        Brand brand = new Brand();
        brand.setName("Vital");
        brandServices.saveBrand(brand);

        Product product = new Product();
        product.setName("Agua");
        product.setActive(true);
        product.setPrice(1);
        product.setBrand(brand);
        productServices.saveProduct(product);
        this.mockMvc.perform(delete("/products/" + product.getProductId()))
        .andDo(print())
        .andExpect(status().is2xxSuccessful());
    }
}
