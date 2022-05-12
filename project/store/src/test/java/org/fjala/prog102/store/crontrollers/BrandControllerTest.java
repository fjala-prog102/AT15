package org.fjala.prog102.store.crontrollers;

import org.fjala.prog102.store.models.Brand;
import org.fjala.prog102.store.services.BrandServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
// import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
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


}
