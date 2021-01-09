package com.galvanize.zookeeper.zoomonitor.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.zookeeper.zoomonitor.model.Animal;
import com.galvanize.zookeeper.zoomonitor.repository.ZooMonitorRepository;
import com.galvanize.zookeeper.zoomonitor.service.ZooMonitorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class ZooMonitorControllerTest {

    @Autowired
    private MockMvc mockMvc;

   @Autowired
   private ObjectMapper objectMapper;

   @Autowired
   private ZooMonitorRepository zooMonitorRepository;


    @Test
    void addAnimal_Test() throws Exception {
        Animal animal = new Animal("Lion","Walking");

        mockMvc.perform(post("/zoo/animals")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8")
                .content(objectMapper.writeValueAsString(animal)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").value("Lion"))
                .andExpect(jsonPath("$.type").value("Walking"));

    }

    @Test
    void getAllAnimals_Test() throws Exception {
        Animal animal = new Animal("Lion","Walking");
        zooMonitorRepository.save(animal);

        animal = new Animal("Parrot","Flying");
        zooMonitorRepository.save(animal);

        mockMvc.perform(get("/zoo/animals"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").exists())
                .andExpect(jsonPath("$[0].name").value("Lion"))
                .andExpect(jsonPath("$[0].type").value("Walking"))
                .andExpect(jsonPath("$[1].id").exists())
                .andExpect(jsonPath("$[1].name").value("Parrot"))
                .andExpect(jsonPath("$[1].type").value("Flying"));



    }





}
