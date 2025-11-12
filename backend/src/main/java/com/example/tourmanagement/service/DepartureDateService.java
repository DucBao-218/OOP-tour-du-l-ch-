package com.example.tourmanagement.service;

import com.example.tourmanagement.model.DepartureDate;
import com.example.tourmanagement.repository.DepartureDateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartureDateService {

    private final DepartureDateRepository departureDateRepository;

    public DepartureDateService(DepartureDateRepository departureDateRepository) {
        this.departureDateRepository = departureDateRepository;
    }

    public List<DepartureDate> getAllDepartureDates() {
        return departureDateRepository.findAll();
    }

    public List<DepartureDate> getDepartureDatesByTour(Long tourId) {
        return departureDateRepository.findByTourId(tourId);
    }

    public DepartureDate getDepartureDateById(Long id) {
        return departureDateRepository.findById(id).orElse(null);
    }

    public DepartureDate createDepartureDate(DepartureDate departureDate) {
        return departureDateRepository.save(departureDate);
    }

    public DepartureDate updateDepartureDate(Long id, DepartureDate updated) {
        DepartureDate existing = departureDateRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setDepartureDay(updated.getDepartureDay());
            existing.setPrice(updated.getPrice());
            existing.setTour(updated.getTour());
            return departureDateRepository.save(existing);
        }
        return null;
    }

    public void deleteDepartureDate(Long id) {
        departureDateRepository.deleteById(id);
    }
}
