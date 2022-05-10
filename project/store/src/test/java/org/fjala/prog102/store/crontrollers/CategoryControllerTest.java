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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


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
    public void deleteCategoriesByNameOk() throws Exception {
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


        mockMvc.perform(delete("/categories/category2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
        mockMvc.perform(get("/categories/category2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

    }

    @Test
    public void saveCategory() throws Exception {
        Category category1 = new Category();
        category1.setName("category1");
        category1.setDescription("description1");

        given(categoryServices.saveCategory(any(Category.class))).willReturn(category1);


        mockMvc.perform(post("/categories")
                        .content(new ObjectMapper().writeValueAsString(category1))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").exists());
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







