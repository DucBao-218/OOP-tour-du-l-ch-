package com.example.tourmanagement.service;

import com.example.tourmanagement.model.Tour;
import com.example.tourmanagement.repository.TourRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourService {
    private final TourRepository repo;

    public TourService(TourRepository repo) {
        this.repo = repo;
    }

    public List<Tour> getAllTours() {
        return repo.findAll();
    }

    public Tour getTourById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Tour createTour(Tour tour) {
        return repo.save(tour);
    }

    public Tour updateTour(Long id, Tour updated) {
        Tour existing = repo.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(updated.getName());
            existing.setStartLocation(updated.getStartLocation());
            existing.setDestination(updated.getDestination());
            existing.setDescription(updated.getDescription());
            return repo.save(existing);
        }
        return null;
    }

    public void deleteTour(Long id) {
        repo.deleteById(id);
    }

    public List<Tour> searchByDestination(String destination) {
        return repo.findByDestinationContainingIgnoreCase(destination);
    }
}
