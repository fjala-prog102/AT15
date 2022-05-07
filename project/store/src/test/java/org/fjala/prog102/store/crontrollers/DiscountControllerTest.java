package org.fjala.prog102.store.crontrollers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.NestedServletException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@AutoConfigureMockMvc
public class DiscountControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void itShouldGetDiscounts() throws Exception {
        this.mockMvc.perform(get("/discounts"))
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Test
    public void itShouldGetAdiscountById() throws Exception {
        String stringBody = "{";
        stringBody += "\"percentage\":0.2,";
        stringBody += "\"startDate\":\"2022-03-31\",";
        stringBody += "\"endDate\":\"2022-04-01\",";
        stringBody += "\"description\":\"Summer discount\"";
        stringBody += "}";

        this.mockMvc.perform(
            post("/discounts")
            .content(stringBody)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON));

        this.mockMvc.perform(get("/discounts/1"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("Summer discount")));
    }

    @Test
    public void itShouldCreateADiscount() throws Exception {
        String stringBody = "{";
        stringBody += "\"percentage\":0.2,";
        stringBody += "\"startDate\":\"2022-03-31\",";
        stringBody += "\"endDate\":\"2022-04-01\",";
        stringBody += "\"description\":\"winter discount\"";
        stringBody += "}";

        this.mockMvc.perform(
            post("/discounts")
            .content(stringBody)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    }

    @Test
    public void itShouldNotCreateADiscountWithId() throws Exception {
        Exception exception = assertThrows(NestedServletException.class, () -> {
            String stringBody = "{";
            stringBody += "\"discountId\":1000,";
            stringBody += "\"percentage\":0.2,";
            stringBody += "\"startDate\":\"2022-03-31\",";
            stringBody += "\"endDate\":\"2022-04-01\",";
            stringBody += "\"description\":\"winter discount\"";
            stringBody += "}";
            this.mockMvc.perform(
                post("/discounts")
                .content(stringBody)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));
        });

        String expectedMessage = "To create a new discount, you do not have to set an ID";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
