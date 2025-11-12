package com.example.tourmanagement.service;

import com.example.tourmanagement.model.Tour;
import com.example.tourmanagement.repository.TourRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TourService {

    private final TourRepository tourRepository;

    public TourService(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    public List<Tour> getAllTours() {
        return tourRepository.findAll();
    }

    public Tour getTourById(Long id) {
        return tourRepository.findById(id).orElse(null);
    }

    public Tour createTour(Tour tour) {
        return tourRepository.save(tour);
    }

    public Tour updateTour(Long id, Tour updatedTour) {
        Tour existing = tourRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(updatedTour.getName());
            existing.setStartLocation(updatedTour.getStartLocation());
            existing.setDestination(updatedTour.getDestination());
            existing.setDescription(updatedTour.getDescription());
            return tourRepository.save(existing);
        }
        return null;
    }

    public void deleteTour(Long id) {
        tourRepository.deleteById(id);
    }
}
