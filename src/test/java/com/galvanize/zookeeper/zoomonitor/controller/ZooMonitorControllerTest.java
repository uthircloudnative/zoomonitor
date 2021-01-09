package com.galvanize.zookeeper.zoomonitor.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.zookeeper.zoomonitor.model.Animal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
public class ZooMonitorControllerTest {

    @Autowired
    private MockMvc mockMvc;

//    @MockBean
//    private ZooMonitorService zooMonitorService;


   @Autowired
   private ObjectMapper objectMapper;


    @Test
    void addAnimal_Test() throws Exception {
        Animal animal = new Animal("Lion","Walking");

        mockMvc.perform(post("/zoo/animals")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8")
                .content(objectMapper.writeValueAsString(animal)))
                .andExpect(status().isCreated());


    }

}
