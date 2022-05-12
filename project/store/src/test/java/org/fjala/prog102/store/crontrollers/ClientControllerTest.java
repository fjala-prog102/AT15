package org.fjala.prog102.store.crontrollers;

import org.fjala.prog102.store.models.Brand;
import org.fjala.prog102.store.services.ClientServices;
import org.fjala.prog102.store.services.ProductServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ClientServices clientServices;

    @Test
    public void itShouldListClients() throws Exception {
        this.mockMvc.perform(get("/clients"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void itShouldCreateAClient() throws Exception {

        String stringBody = "{";
        stringBody += "\"identificationNumber\":39509979,";
        stringBody += "\"firstName\":\"Agustin\",";
        stringBody += "\"lastName\":\"Mediotti\",";
        stringBody += "\"address\":\"43, 845 LP\"";
        stringBody += "}";

        this.mockMvc.perform(
                        post("/clients")
                                .content(stringBody)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }
}
