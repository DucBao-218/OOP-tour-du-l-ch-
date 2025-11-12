package com.example.tourmanagement.repository;

import com.example.tourmanagement.model.Itinerary;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ItineraryRepository extends JpaRepository<Itinerary, Long> {
    List<Itinerary> findByTourId(Long tourId);
}
