package com.virtusa.CommunicationService.Controller;

import com.virtusa.CommunicationService.Service.CommunicationPreferencesService;
import com.virtusa.CommunicationService.model.CommunicationPreferences;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/communication/preferences")
public class CommunicationController {

    private final CommunicationPreferencesService communicationPreferencesService;

    public CommunicationController(CommunicationPreferencesService communicationPreferencesService) {
        this.communicationPreferencesService = communicationPreferencesService;
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<CommunicationPreferences> getCommunicationPreferences(@PathVariable Long patientId) {
        CommunicationPreferences communicationPreferences = communicationPreferencesService.getCommunicationPreferences(patientId);
        if (communicationPreferences != null) {
            return ResponseEntity.ok(communicationPreferences);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{patientId}")
    public ResponseEntity<CommunicationPreferences> updateCommunicationPreferences(
            @PathVariable Long patientId,
            @RequestBody CommunicationPreferences communicationPreferences
    ) {
        CommunicationPreferences updatedPreferences = communicationPreferencesService.updateCommunicationPreferences(patientId, communicationPreferences);
        if (updatedPreferences != null) {
            return ResponseEntity.ok(updatedPreferences);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

