package com.example.tourmanagement.controller;

import com.example.tourmanagement.model.Tour;
import com.example.tourmanagement.service.TourService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tours")
@CrossOrigin(origins = "http://localhost:5173")
public class TourController {
    private final TourService service;

    public TourController(TourService service) {
        this.service = service;
    }

    @GetMapping
    public List<Tour> getAllTours() {
        return service.getAllTours();
    }

    @GetMapping("/{id}")
    public Tour getTourById(@PathVariable Long id) {
        return service.getTourById(id);
    }

    @PostMapping
    public Tour createTour(@RequestBody Tour tour) {
        return service.createTour(tour);
    }

    @PutMapping("/{id}")
    public Tour updateTour(@PathVariable Long id, @RequestBody Tour tour) {
        return service.updateTour(id, tour);
    }

    @DeleteMapping("/{id}")
    public void deleteTour(@PathVariable Long id) {
        service.deleteTour(id);
    }

    // API tìm kiếm tour theo điểm đến
    @GetMapping("/search")
    public List<Tour> searchTours(@RequestParam String destination) {
        return service.searchByDestination(destination);
    }
}
