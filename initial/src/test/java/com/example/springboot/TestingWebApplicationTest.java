package com.example.springboot;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.springboot.Operation.OperationDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class TestingWebApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Greetings from Spring Boot!")));
    }

    @Test
    public void shouldReturnIdNotEmpty() throws Exception {
        OperationDTO opeationDTO = new OperationDTO();
        String operationID=Long.toHexString(Double.doubleToLongBits(Math.random()));
        //opeationDTO.setOperationId();
        opeationDTO.setOperation("addition");
        opeationDTO.setLeft(4);
        opeationDTO.setRight(5);
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(opeationDTO);
            System.out.println("ResultingJSONstring = " + json);
        this.mockMvc.perform(post("/operations")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.operationId").isNotEmpty());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
