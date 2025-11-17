package com.example.tourmanagement.controller;

import com.example.tourmanagement.model.Amenity;
import com.example.tourmanagement.service.AmenityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/amenities")
@CrossOrigin(origins = "http://localhost:5173")
public class AmenityController {
    private final AmenityService service;

    public AmenityController(AmenityService service) {
        this.service = service;
    }

    @GetMapping
    public List<Amenity> getAllAmenities() {
        return service.getAllAmenities();
    }

    @GetMapping("/{id}")
    public Amenity getAmenityById(@PathVariable Long id) {
        return service.getAmenityById(id);
    }

    @PostMapping
    public Amenity createAmenity(@RequestBody Amenity a) {
        return service.createAmenity(a);
    }

    @PutMapping("/{id}")
    public Amenity updateAmenity(@PathVariable Long id, @RequestBody Amenity a) {
        return service.updateAmenity(id, a);
    }

    @DeleteMapping("/{id}")
    public void deleteAmenity(@PathVariable Long id) {
        service.deleteAmenity(id);
    }

    // Lấy tiện ích theo Tour
    @GetMapping("/tour/{tourId}")
    public List<Amenity> getAmenitiesByTour(@PathVariable Long tourId) {
        return service.getAmenitiesByTour(tourId);
    }
}
