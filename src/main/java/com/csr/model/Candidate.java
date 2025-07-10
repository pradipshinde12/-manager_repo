package com.csr.model;

//import javax.persistence.Entity;
//import javax.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Candidate {

    @Id
    private Long id;          // Unique ID for each candidate
    private String name;      // Name of the candidate
    private int votes;        // Number of votes the candidate has received

    // Default constructor
    public Candidate() {
    }

    // Constructor to initialize Candidate with name and votes
    public Candidate(String name) {
        this.name = name;
        this.votes = 0; // Initially, votes are 0
    }

    // Getter and Setter methods
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }
}
