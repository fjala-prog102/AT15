package org.fjala.prog102.store.crontrollers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DiscountApplicationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void itShouldGetDiscounts() throws Exception {
        this.mockMvc.perform(get("/discounts"))
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Test
    public void itShouldCreateADiscount() throws Exception {
        String stringBody = "{\n\"percentage\": 0.2,\n";
        stringBody += "\"startDate\": \"2022-03-31\",\n";
        stringBody += "\"endDate\": \"2022-04-01\",\n";
        stringBody += "\"description\": \"winter discount\"\n";
        stringBody += "}";
        this.mockMvc.perform(
            post("/discounts")
            .content(stringBody)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    }
}
