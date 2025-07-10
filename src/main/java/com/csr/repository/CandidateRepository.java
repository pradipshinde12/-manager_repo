package com.csr.repository;

import com.csr.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    // Spring Data JPA automatically implements this based on naming convention
    Candidate findByName(String name); // Will automatically generate a query to find by name
}
