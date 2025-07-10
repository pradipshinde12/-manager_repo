package com.csr.controller;

import com.csr.service.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class VotingController {

    @Autowired
    private VotingService votingService;

    @GetMapping("/")
    public String showVotingPage(Model model) {
        model.addAttribute("candidates", votingService.getAllCandidates());
        return "index"; // This refers to the `index.html` template
    }

    @PostMapping("/vote")
    public String vote(@RequestParam String studentId, @RequestParam String studentName, @RequestParam String candidateName, Model model) {
        String message = votingService.vote(studentId, studentName, candidateName);
        model.addAttribute("message", message);
        return "result"; // Show the result page after voting
    }

    @GetMapping("/results")
    public String showResults(Model model) {
        String results = votingService.getResults();
        model.addAttribute("results", results);
        return "results"; // Show the results page
    }
}
