package com.example.pfev2.controllers;
import com.example.pfev2.entites.Communication;
import com.example.pfev2.repositorys.CommunicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/communications")
@CrossOrigin(origins = "http://localhost:4200")
public class CommunicationController {
    @Autowired
    private CommunicationRepository communicationRepository;
    @GetMapping
    public List<Communication> getAllCommunications() {
        return communicationRepository.findAll();
    }
    @GetMapping("/{id}")
    public Communication getCommunicationById(@PathVariable Long id) {
        return communicationRepository.findById(id);
    }
    @PostMapping
    public Communication createCommunication(@RequestBody Communication communication) {
        return communicationRepository.save(communication);
    }
    @PutMapping("/{id}")
    public Communication updateCommunication(@PathVariable Long id, @RequestBody Communication communication) {
        communication.setId(id);
        return communicationRepository.save(communication);
    }
    @DeleteMapping("/{id}")
    public void deleteCommunication(@PathVariable Integer id) {
        communicationRepository.deleteById(id);
    }
}