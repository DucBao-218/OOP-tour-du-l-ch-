package com.example.tourmanagement.repository;

import com.example.tourmanagement.model.ItineraryDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ItineraryDetailRepository extends JpaRepository<ItineraryDetail, Long> {
    List<ItineraryDetail> findByItineraryId(Long itineraryId);
}
