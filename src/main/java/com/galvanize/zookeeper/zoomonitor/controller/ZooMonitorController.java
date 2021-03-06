package com.galvanize.zookeeper.zoomonitor.controller;

import com.galvanize.zookeeper.zoomonitor.model.Animal;
import com.galvanize.zookeeper.zoomonitor.service.ZooMonitorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/zoo/animals")
public class ZooMonitorController {

    private ZooMonitorService zooMonitorService;

    public ZooMonitorController(ZooMonitorService zooMonitorService) {
        this.zooMonitorService = zooMonitorService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Animal addAnimal(@RequestBody Animal animal){
        return zooMonitorService.addAnimal(animal);
    }

    @GetMapping
    public List<Animal> getAllAnimals(){
        return zooMonitorService.getAllAnimals();
    }
}
