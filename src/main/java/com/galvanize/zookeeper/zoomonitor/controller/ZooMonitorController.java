package com.galvanize.zookeeper.zoomonitor.controller;

import com.galvanize.zookeeper.zoomonitor.model.Animal;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/zoo/animals")
public class ZooMonitorController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Animal addAnimal(@RequestBody Animal animal){
        return animal;
    }
}
