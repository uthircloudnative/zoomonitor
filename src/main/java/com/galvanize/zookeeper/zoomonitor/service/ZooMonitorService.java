package com.galvanize.zookeeper.zoomonitor.service;

import com.galvanize.zookeeper.zoomonitor.model.Animal;
import com.galvanize.zookeeper.zoomonitor.repository.ZooMonitorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZooMonitorService {

    private ZooMonitorRepository zooMonitorRepository;

    public ZooMonitorService(ZooMonitorRepository zooMonitorRepository) {
        this.zooMonitorRepository = zooMonitorRepository;
    }

    public Animal addAnimal(Animal animal){
        return zooMonitorRepository.save(animal);
    }

    public List<Animal> getAllAnimals() {
        return zooMonitorRepository.findAll();
    }
}
