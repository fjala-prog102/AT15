package org.fjala.prog102.store.crontrollers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.fjala.prog102.store.models.Category;
import org.fjala.prog102.store.services.CategoryServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@SpringBootTest
@AutoConfigureMockMvc
public class CategoryControllerTest {
    private static final int NUMBER_3 = 3;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryServices categoryServices;


    @Test
    public void getAllCategories() throws Exception {
        Category category1 = new Category();
        category1.setName("category1");
        category1.setDescription("description1");
        Category category2 = new Category();
        category2.setName("category2");
        category2.setDescription("description2");
        Category category3 = new Category();
        category3.setName("category3");
        category3.setDescription("description3");
        List<Category> categories = new ArrayList<>(Arrays.asList(category1, category2, category3));

        given(categoryServices.getCategories()).willReturn(categories);


        mockMvc.perform(get("/categories")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(NUMBER_3)))
                .andExpect(jsonPath("$[2].name").value("category3"));
    }

    @Test
    public void deleteCategoriesByName() throws Exception {
        Category category10 = new Category();
        category10.setName("category10");
        category10.setDescription("description10");
        categoryServices.saveCategory(category10);
        this.mockMvc.perform(delete("/categories/" + category10.getName()))
        .andDo(print())
        .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void saveCategory() throws Exception {
        String stringBody = "{";
        stringBody += "\"name\":\"Example\",";
        stringBody += "\"description\":\"Examples\"";
        stringBody += "}";

        this.mockMvc.perform(
            post("/categories")
            .content(stringBody)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isCreated());
    }

    @Test
    public void updateCategory() throws Exception {
        Category category1 = new Category();
        category1.setName("category1");
        category1.setDescription("description1");

        given(categoryServices.updateCategory(any(Category.class))).willReturn(category1);


        mockMvc.perform(put("/categories")
                        .content(new ObjectMapper().writeValueAsString(category1))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").exists());
    }

}








