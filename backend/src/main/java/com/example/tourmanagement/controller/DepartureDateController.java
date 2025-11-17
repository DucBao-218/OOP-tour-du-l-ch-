package com.example.tourmanagement.controller;

import com.example.tourmanagement.model.DepartureDate;
import com.example.tourmanagement.service.DepartureDateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departure-dates")
@CrossOrigin(origins = "http://localhost:5173")
public class DepartureDateController {
    private final DepartureDateService service;

    public DepartureDateController(DepartureDateService service) {
        this.service = service;
    }

    @GetMapping
    public List<DepartureDate> getAllDepartureDates() {
        return service.getAllDepartureDates();
    }

    @GetMapping("/{id}")
    public DepartureDate getDepartureDateById(@PathVariable Long id) {
        return service.getDepartureDateById(id);
    }

    @PostMapping
    public DepartureDate createDepartureDate(@RequestBody DepartureDate departureDate) {
        return service.createDepartureDate(departureDate);
    }

    @PutMapping("/{id}")
    public DepartureDate updateDepartureDate(@PathVariable Long id, @RequestBody DepartureDate departureDate) {
        return service.updateDepartureDate(id, departureDate);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartureDate(@PathVariable Long id) {
        service.deleteDepartureDate(id);
    }

    // Lấy tất cả ngày khởi hành theo tour
    @GetMapping("/tour/{tourId}")
    public List<DepartureDate> getDepartureDatesByTour(@PathVariable Long tourId) {
        return service.getDepartureDatesByTour(tourId);
    }
}
