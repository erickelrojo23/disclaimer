package com.demo.disclaimer.controller;

import com.demo.disclaimer.model.api.Acceptance;
import com.demo.disclaimer.service.AcceptanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/acceptances")
public class AcceptanceController {

    @Autowired
    private AcceptanceService acceptanceService;

    @PostMapping
    public ResponseEntity<Acceptance> createAcceptance(@RequestBody Acceptance acceptance) {
        Acceptance createdAcceptance = acceptanceService.createAcceptance(acceptance);
        return new ResponseEntity<>(createdAcceptance, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Acceptance>> listAcceptances(@RequestParam(value = "user_id", required = false) Long userId) {
        List<Acceptance> acceptances = acceptanceService.listAcceptances(userId);
        return new ResponseEntity<>(acceptances, HttpStatus.OK);
    }
}
