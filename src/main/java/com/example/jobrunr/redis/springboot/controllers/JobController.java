/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.jobrunr.redis.springboot.controllers;

import com.example.jobrunr.redis.springboot.services.JobService;
import org.jobrunr.scheduling.JobScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author user
 */
@RestController
@RequestMapping("/jobs")
public class JobController {
    
    @Autowired
    private JobService jobService;
    
    @Autowired
    private JobScheduler jobScheduler;
    
    @GetMapping
    public ResponseEntity<?> index() {
        
        // Queue Job
        this.jobScheduler.enqueue(() -> jobService.sendMail("dev@code.com"));
        
        return ResponseEntity.ok().body("Operation succeeded");
    }
}
