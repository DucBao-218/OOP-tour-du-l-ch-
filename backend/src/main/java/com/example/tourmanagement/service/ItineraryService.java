package com.example.tourmanagement.service;

import com.example.tourmanagement.model.Itinerary;
import com.example.tourmanagement.repository.ItineraryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ItineraryService {
    private final ItineraryRepository itineraryRepository;

    public ItineraryService(ItineraryRepository itineraryRepository) {
        this.itineraryRepository = itineraryRepository;
    }

    public List<Itinerary> getItineraryByTour(Long tourId) {
        return itineraryRepository.findByTourId(tourId);
    }

    public Itinerary addItinerary(Itinerary itinerary) {
        return itineraryRepository.save(itinerary);
    }

    public void deleteItinerary(Long id) {
        itineraryRepository.deleteById(id);
    }
}
