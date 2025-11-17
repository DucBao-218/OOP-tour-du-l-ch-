package com.example.tourmanagement.service;

import com.example.tourmanagement.model.DepartureDate;
import com.example.tourmanagement.repository.DepartureDateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartureDateService {
    private final DepartureDateRepository repo;

    public DepartureDateService(DepartureDateRepository repo) {
        this.repo = repo;
    }

    public List<DepartureDate> getAllDepartureDates() {
        return repo.findAll();
    }

    public DepartureDate getDepartureDateById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public DepartureDate createDepartureDate(DepartureDate departureDate) {
        return repo.save(departureDate);
    }

    public DepartureDate updateDepartureDate(Long id, DepartureDate updated) {
        DepartureDate existing = repo.findById(id).orElse(null);
        if (existing != null) {
            existing.setDepartureDay(updated.getDepartureDay());
            existing.setPrice(updated.getPrice());
            existing.setAvailableSeats(updated.getAvailableSeats());
            existing.setTour(updated.getTour());
            return repo.save(existing);
        }
        return null;
    }

    public void deleteDepartureDate(Long id) {
        repo.deleteById(id);
    }

    public List<DepartureDate> getDepartureDatesByTour(Long tourId) {
        return repo.findByTourId(tourId);
    }
}
