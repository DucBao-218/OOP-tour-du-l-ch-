package com.example.tourmanagement.controller;

import com.example.tourmanagement.model.Itinerary;
import com.example.tourmanagement.service.ItineraryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itineraries")
@CrossOrigin(origins = "http://localhost:5173")
public class ItineraryController {
    private final ItineraryService itineraryService;

    public ItineraryController(ItineraryService itineraryService) {
        this.itineraryService = itineraryService;
    }

    @GetMapping("/tour/{tourId}")
    public List<Itinerary> getItineraryByTour(@PathVariable Long tourId) {
        return itineraryService.getItineraryByTour(tourId);
    }

    @PostMapping
    public Itinerary addItinerary(@RequestBody Itinerary itinerary) {
        return itineraryService.addItinerary(itinerary);
    }

    @DeleteMapping("/{id}")
    public void deleteItinerary(@PathVariable Long id) {
        itineraryService.deleteItinerary(id);
    }
}
