package org.fjala.prog102.store.crontrollers;

import org.fjala.prog102.store.models.Client;
import org.fjala.prog102.store.services.ClientServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.contains;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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

    @Test
    public void itShouldDeleteAClientById() throws Exception {
        this.mockMvc.perform(delete("/clients/delete/1000"))
                .andExpect(status().isNotFound())
                .andExpect(content().string(contains("A client identificationNumber must be specified")));


        Client client = new Client();
        client.setIdentificationNumber(39509979L);
        client.setFirstName("Agustin");
        client.setLastName("Mediotti");
        client.setAddress("43, 845 LP");
        clientServices.saveClient(client);

        mockMvc.perform(delete("/clients/delete/" + client.getIdentificationNumber()))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void itShouldFindAClientById() throws Exception {
        this.mockMvc.perform(get("/clients/find/1000"))
                .andExpect(status().is4xxClientError());


        Client client = new Client();
        client.setIdentificationNumber(39509979L);
        client.setFirstName("Agustin");
        client.setLastName("Mediotti");
        client.setAddress("43, 845 LP");
        clientServices.saveClient(client);

        mockMvc.perform(get("/clients/find/" + client.getIdentificationNumber()))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void itShouldUpdateAClient() throws Exception {
        Client client = new Client();
        client.setIdentificationNumber(123L);
        client.setFirstName("juan");
        client.setLastName("perez");
        client.setAddress("jala");
        clientServices.saveClient(client);

        String updateBody = "{";
        updateBody += "\"identificationNumber\":" + client.getIdentificationNumber() + ",";
        updateBody += "\"firstName\":\"juancho\",";
        updateBody += "\"lastName\":\"perez\",";
        updateBody += "\"address\":\"jala\"";
        updateBody += "}";

        this.mockMvc.perform(
            put("/clients/find/" + client.getIdentificationNumber())
            .content(updateBody)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    }

    @Test
    public void itShouldNotUpdateAClienttWithUnexistingId() throws Exception{
        String updateBody = "{";
        updateBody += "\"identificationNumber\":123,";
        updateBody += "\"firstName\":\"juancho\",";
        updateBody += "\"lastName\":\"perez\",";
        updateBody += "\"address\":\"jala\"";
        updateBody += "}";

        this.mockMvc.perform(
            put("/clients/find/123")
            .content(updateBody)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNotFound())
            .andExpect(content().string(contains("The provided Client doesn't exist")));
    }

    @Test void itShouldNotCreateAClientWithGivenId() throws Exception {
        String stringBody = "{";
        stringBody += "\"firstName\":\"juancho\",";
        stringBody += "\"lastName\":\"perez\",";
        stringBody += "\"address\":\"jala\"";
        stringBody += "}";
        this.mockMvc.perform(
            post("/clients")
            .content(stringBody)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNotFound())
            .andExpect(content().string(contains("A new client needs to have an identificationNumber")));
    }
}
