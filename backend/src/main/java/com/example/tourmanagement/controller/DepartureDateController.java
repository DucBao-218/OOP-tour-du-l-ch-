package com.example.tourmanagement.controller;

import com.example.tourmanagement.model.DepartureDate;
import com.example.tourmanagement.service.DepartureDateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departure-dates")
@CrossOrigin(origins = "http://localhost:5173") // Cho phép frontend React gọi API
public class DepartureDateController {

    private final DepartureDateService departureDateService;

    public DepartureDateController(DepartureDateService departureDateService) {
        this.departureDateService = departureDateService;
    }

    @GetMapping
    public List<DepartureDate> getAllDepartureDates() {
        return departureDateService.getAllDepartureDates();
    }

    @GetMapping("/tour/{tourId}")
    public List<DepartureDate> getDepartureDatesByTour(@PathVariable Long tourId) {
        return departureDateService.getDepartureDatesByTour(tourId);
    }

    @GetMapping("/{id}")
    public DepartureDate getDepartureDateById(@PathVariable Long id) {
        return departureDateService.getDepartureDateById(id);
    }

    @PostMapping
    public DepartureDate createDepartureDate(@RequestBody DepartureDate departureDate) {
        return departureDateService.createDepartureDate(departureDate);
    }

    @PutMapping("/{id}")
    public DepartureDate updateDepartureDate(@PathVariable Long id, @RequestBody DepartureDate departureDate) {
        return departureDateService.updateDepartureDate(id, departureDate);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartureDate(@PathVariable Long id) {
        departureDateService.deleteDepartureDate(id);
    }
}
