package com.example.tourmanagement.service;

import com.example.tourmanagement.model.ItineraryDetail;
import com.example.tourmanagement.repository.ItineraryDetailRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItineraryDetailService {
    private final ItineraryDetailRepository repo;

    public ItineraryDetailService(ItineraryDetailRepository repo) {
        this.repo = repo;
    }

    public List<ItineraryDetail> getDetailsByItinerary(Long itineraryId) {
        return repo.findByItineraryId(itineraryId);
    }

    public ItineraryDetail addDetail(ItineraryDetail detail) {
        return repo.save(detail);
    }

    public void deleteDetail(Long id) {
        repo.deleteById(id);
    }
}
