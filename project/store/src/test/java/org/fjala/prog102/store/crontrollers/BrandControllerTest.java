package org.fjala.prog102.store.crontrollers;

import org.fjala.prog102.store.models.Brand;
import org.fjala.prog102.store.services.BrandServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
public class BrandControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BrandServices brandServices;

    @Test
    public void itShouldGetBrands() throws Exception{
        this.mockMvc.perform(get("/brands"))
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Test
    public void itShouldCreateABrand() throws Exception {
        Brand brand = new Brand();
        brand.setName("Samsung");
        brand.setDescription("Electronic products");
        brand.setWebsite("www.samsung.com");
        brandServices.saveBrand(brand);

        String stringBody = "{";
        stringBody += "\"name\":\"Samsung\",";
        stringBody += "\"description\":\"Electronic products\",";
        stringBody += "\"website\":\"www.samsung.com\"";
        stringBody += "}";

        this.mockMvc.perform(
            post("/brands")
            .content(stringBody)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isCreated());
    }

    @Test
    public void itShouldGetABrandByName() throws Exception {
        Brand brand = new Brand();
        brand.setName( "Samsung");
        brand.setDescription("Electronic Products");
        brand.setWebsite("www.samsung.com");
        brandServices.saveBrand(brand);

        this.mockMvc.perform(get("/brands/Samsung"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("samsung.com")));
    }

    @Test
    public void itShouldDeleteABrand() throws Exception {
        Brand brand = new Brand();
        brand.setName( "Samsung");
        brand.setDescription("Electronic Products");
        brand.setWebsite("www.samsung.com");
        brandServices.saveBrand(brand);

        this.mockMvc.perform(delete("/brands/" + brand.getName()))
        .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void itShouldNotDeleteANonExistentBrand() throws Exception {
        this.mockMvc.perform(delete("/brands/sony"))
        .andExpect(status().isNotFound());
    }

    @Test
    public void itShouldUpdateABrand() throws Exception {
        Brand brand = new Brand();
        brand.setName("Xiaomi");
        brand.setDescription("Smartphones");
        brand.setWebsite("www.xioami.com");
        brandServices.saveBrand(brand);

        String stringBody = "{";
        stringBody += "\"name\":\"Xiaomi\",";
        stringBody += "\"description\":\"Smartphones and computers\",";
        stringBody += "\"website\":\"www.xiaomi.com\"";
        stringBody += "}";

        this.mockMvc.perform(
            put("/brands")
            .content(stringBody)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Test
    public void itShouldNotUpdateANonExistentBrand() throws Exception {
        String stringBody = "{";
        stringBody += "\"name\":\"HP\",";
        stringBody += "\"description\":\"Computers\",";
        stringBody += "\"website\":\"www.hp.com\"";
        stringBody += "}";

        this.mockMvc.perform(
            put("/brands")
            .content(stringBody)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isNotFound());
    }
}
