package com.airline.baggage.controller;

import com.airline.baggage.model.Baggage;
import com.airline.baggage.repository.BaggageRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/baggage")
@CrossOrigin(origins = "*")
public class BaggageController {

    private final BaggageRepository repository;

    public BaggageController(BaggageRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Baggage> getAllBaggage() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Baggage> getBaggageById(
            @PathVariable Long id) {

        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Baggage createBaggage(
            @RequestBody Baggage baggage) {

        return repository.save(baggage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Baggage> updateBaggage(
            @PathVariable Long id,
            @RequestBody Baggage updatedBaggage) {

        return repository.findById(id)
                .map(existing -> {

                    existing.setPassengerName(
                            updatedBaggage.getPassengerName());

                    existing.setFlightNumber(
                            updatedBaggage.getFlightNumber());

                    existing.setBaggageTag(
                            updatedBaggage.getBaggageTag());

                    existing.setWeight(
                            updatedBaggage.getWeight());

                    existing.setStatus(
                            updatedBaggage.getStatus());

                    return ResponseEntity.ok(
                            repository.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBaggage(
            @PathVariable Long id) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
