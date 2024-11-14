package com.example.agencyapi.controller;

import com.example.agencyapi.model.Agency;
import com.example.agencyapi.service.AgencyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agency")
public class AgencyApiController {

    @Autowired
    private AgencyService agencyService;

    /**
     * Get a list of all agencies.
     */
    @GetMapping("/all")
    public List<Agency> getAllAgencies() {
        return agencyService.getAllAgencies();
    }

    /**
     * Add a new agency. Returns an error if the agency already exists with the same name or code.
     */
    @PostMapping("/add")
    public String addAgency(@Valid @RequestBody Agency agency) {
        return agencyService.addAgency(agency);
    }

    /**
     * Update an existing agency. Returns an error if updates are not allowed or if the agency is not found.
     */
    @PutMapping("/update")
    public String updateAgency(@Valid @RequestBody Agency agency) {
        return agencyService.updateAgency(agency);
    }
}