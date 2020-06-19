package com.myapp.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.api.ProductRestController;
import com.myapp.dao.ProductRepository;
import com.myapp.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductTest {

    @Autowired
    private ProductRestController productRestController;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testSearch(){
        Product p = new Product("kinder", null);
        p = productRestController.add(p);

        assertEquals(true, productRepository.existsById(p.getId()));

        assertEquals(p.getName(), ((Product)productRepository.findById(p.getId()).get()).getName());

    }

    @Test
    public void testCreate(){
        Product p = new Product("kinder", null);
        p = productRestController.add(p);

        assertEquals(true, productRepository.existsById(p.getId()));
    }

    @Test
    public void testDelete(){
        Product p = new Product("kinder", null);
        p = productRestController.add(p);

        assertEquals(true, productRepository.existsById(p.getId()));

        productRestController.delete((int) p.getId());

        assertEquals(false, productRepository.existsById(p.getId()));
    }

    @Test
    public void mock() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Product myProduct = new Product();
        String myJSON = mapper.writeValueAsString(myProduct);
        this.mockMvc.perform(
                put("/products/product/3")
                        .contentType(MediaType.APPLICATION_JSON).content(myJSON)
        )
                .andExpect(status().isOk());
    }


}
