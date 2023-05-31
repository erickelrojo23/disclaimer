package com.demo.disclaimer.controller;

import com.demo.disclaimer.model.api.Disclaimer;
import com.demo.disclaimer.service.DisclaimerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/disclaimers")
public class DisclaimerController {

    @Autowired
    DisclaimerService disclaimerService;

    @GetMapping
    public ResponseEntity<List<Disclaimer>> getAllDisclaimers(@RequestParam(required = false, name = "text") String text) {
        List<Disclaimer> disclaimers = disclaimerService.getAllDisclaimers(text);
        return new ResponseEntity<>(disclaimers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Disclaimer> getDisclaimerById(@PathVariable Long id) {
        Disclaimer disclaimer = disclaimerService.getDisclaimerById(id);
        if (disclaimer != null) {
            return new ResponseEntity<>(disclaimer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Disclaimer> createDisclaimer(@RequestBody Disclaimer disclaimer) {
        Disclaimer createdDisclaimer = disclaimerService.createDisclaimer(disclaimer);
        return new ResponseEntity<>(createdDisclaimer, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Disclaimer> updateDisclaimer(@PathVariable Long id, @RequestBody Disclaimer disclaimer) {
        Disclaimer updatedDisclaimer = disclaimerService.updateDisclaimer(id, disclaimer);
        if (updatedDisclaimer != null) {
            return new ResponseEntity<>(updatedDisclaimer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDisclaimer(@PathVariable Long id) {
        disclaimerService.deleteDisclaimer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
