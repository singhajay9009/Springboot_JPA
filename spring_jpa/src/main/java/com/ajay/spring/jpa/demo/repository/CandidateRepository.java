package com.ajay.spring.jpa.demo.repository;

import com.ajay.spring.jpa.demo.entity.relationship.Candidate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends CrudRepository<Candidate, Integer> {
}
