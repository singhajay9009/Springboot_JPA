package com.ajay.spring.jpa.demo.repository;

import com.ajay.spring.jpa.demo.entity.relationship.manyToMany.Programmer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.websocket.server.ServerEndpoint;

@Repository
public interface ProgrammerRepository extends CrudRepository<Programmer, Integer> {
}
