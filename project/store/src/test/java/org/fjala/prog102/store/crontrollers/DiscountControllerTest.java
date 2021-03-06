package org.fjala.prog102.store.crontrollers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.NestedServletException;
import org.fjala.prog102.store.models.Discount;
import org.fjala.prog102.store.services.DiscountServices;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.contains;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@AutoConfigureMockMvc
public class DiscountControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DiscountServices discountServices;

    @Test
    public void itShouldGetDiscounts() throws Exception {
        this.mockMvc.perform(get("/discounts"))
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Test
    public void itShouldGetAdiscountById() throws Exception {
        Discount discount = new Discount();
        discount.setPercentage(0.1);
        discount.setStartDate(new Date(1649044800000L));
        discount.setEndDate(new Date(1651464000000L));
        discount.setDescription("crazy summer discount");
        discountServices.saveDiscount(discount);

        this.mockMvc.perform(get("/discounts/" + discount.getDiscountId()))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("crazy summer discount")));
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
            .andExpect(status().isCreated()
        );
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
                .accept(MediaType.APPLICATION_JSON)
            );
        });

        String expectedMessage = "To create a new discount, you do not have to set an ID";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void itShouldUpdateADiscount() throws Exception {
        String updateBody = "{";
        updateBody += "\"discountId\":1,";
        updateBody += "\"percentage\":0.2,";
        updateBody += "\"startDate\":\"2022-03-31\",";
        updateBody += "\"endDate\":\"2022-04-01\",";
        updateBody += "\"description\":\"Summer discount\"";
        updateBody += "}";

        this.mockMvc.perform(
            put("/discounts")
            .content(updateBody)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
        )
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Test
    public void itShouldDeleteADiscount() throws Exception {
        Discount discount = new Discount();
        discount.setPercentage(0.1);
        discount.setStartDate(new Date(1649044800000L));
        discount.setEndDate(new Date(1651464000000L));
        discount.setDescription("crazy summer discount");
        discountServices.saveDiscount(discount);
        this.mockMvc.perform(delete("/discounts/" + discount.getDiscountId()))
        .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void itShouldNotDeleteADiscount() throws Exception {
        this.mockMvc.perform(delete("/discounts/1234"))
        .andDo(print())
        .andExpect(status().isNotFound())
        .andExpect(content().string(contains("The discount with the given id was not found")));
    }
}
