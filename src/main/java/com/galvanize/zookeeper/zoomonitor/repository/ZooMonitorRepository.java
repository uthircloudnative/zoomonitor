package com.galvanize.zookeeper.zoomonitor.repository;

import com.galvanize.zookeeper.zoomonitor.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZooMonitorRepository extends JpaRepository<Animal,String> {
}
