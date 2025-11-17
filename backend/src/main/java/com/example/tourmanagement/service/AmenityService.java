package com.example.tourmanagement.service;

import com.example.tourmanagement.model.Amenity;
import com.example.tourmanagement.repository.AmenityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmenityService {
    private final AmenityRepository repo;

    public AmenityService(AmenityRepository repo) {
        this.repo = repo;
    }

    public List<Amenity> getAllAmenities() {
        return repo.findAll();
    }

    public Amenity getAmenityById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Amenity createAmenity(Amenity a) {
        return repo.save(a);
    }

    public Amenity updateAmenity(Long id, Amenity updated) {
        Amenity existing = repo.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(updated.getName());
            existing.setDescription(updated.getDescription());
            existing.setTour(updated.getTour());
            return repo.save(existing);
        }
        return null;
    }

    public void deleteAmenity(Long id) {
        repo.deleteById(id);
    }

    public List<Amenity> getAmenitiesByTour(Long tourId) {
        return repo.findByTourId(tourId);
    }
}
