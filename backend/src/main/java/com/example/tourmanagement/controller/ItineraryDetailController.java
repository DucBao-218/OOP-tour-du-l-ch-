package com.example.tourmanagement.controller;

import com.example.tourmanagement.model.ItineraryDetail;
import com.example.tourmanagement.service.ItineraryDetailService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itinerary-details")
@CrossOrigin(origins = "http://localhost:5173")
public class ItineraryDetailController {
    private final ItineraryDetailService service;

    public ItineraryDetailController(ItineraryDetailService service) {
        this.service = service;
    }

    @GetMapping("/itinerary/{itineraryId}")
    public List<ItineraryDetail> getDetailsByItinerary(@PathVariable Long itineraryId) {
        return service.getDetailsByItinerary(itineraryId);
    }

    @PostMapping
    public ItineraryDetail addDetail(@RequestBody ItineraryDetail detail) {
        return service.addDetail(detail);
    }

    @DeleteMapping("/{id}")
    public void deleteDetail(@PathVariable Long id) {
        service.deleteDetail(id);
    }
}
