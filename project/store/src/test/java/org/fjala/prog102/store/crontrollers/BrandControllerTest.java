package org.fjala.prog102.store.crontrollers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.fjala.prog102.store.models.Brand;
import org.fjala.prog102.store.services.BrandServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

public class BrandControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BrandServices brandServices;


    // @Test
    // public void itShouldGetBrands() throws Exception{
    //     this.mockMvc.perform(get("/brands"))
    //         .andDo(print())
    //         .andExpect(status().isOk());
    // }

}
