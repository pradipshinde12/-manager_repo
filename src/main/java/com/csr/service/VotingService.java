package com.csr.service;

import com.csr.model.Candidate;
import com.csr.model.Student;
import com.csr.model.Vote;
import com.csr.repository.CandidateRepository;
import com.csr.repository.StudentRepository;
import com.csr.repository.VoteRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VotingService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private VoteRepository voteRepository;

    // Vote for a candidate
    public String vote(String studentId, String studentName, String candidateName) {
        // Check if the candidate exists
        Candidate candidate = candidateRepository.findByName(candidateName);
        if (candidate == null) {
            return "Candidate not found!";
        }

        // Check if the student has already voted (we can store the student ID in the Vote table)
        Student student = studentRepository.findByStudentId(studentId);
        if (student == null) {
            // Save the student if they don't exist in the database
            student = new Student();
            student.setStudentId(studentId);
            student.setStudentName(studentName);
            studentRepository.save(student);
        }

        // Save the vote
        Vote vote = new Vote();
        vote.setStudent(student);
        vote.setCandidate(candidate);
        voteRepository.save(vote);

        // Increment the vote count for the candidate
        candidate.setVotes(candidate.getVotes() + 1);
        candidateRepository.save(candidate);

        return "Vote submitted successfully for " + candidateName;
    }

    // Get voting results
    public String getResults() {
        List<Candidate> candidates = candidateRepository.findAll();
        StringBuilder results = new StringBuilder();

        for (Candidate candidate : candidates) {
            results.append(candidate.getName()).append(": ").append(candidate.getVotes()).append(" votes\n");
        }
        return results.toString();
    }

    // Get all candidates for displaying in the voting page
    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }
}
