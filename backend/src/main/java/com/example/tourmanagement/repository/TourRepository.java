package com.example.tourmanagement.repository;

import com.example.tourmanagement.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {
    // Tìm tour theo điểm đến (destination)
    List<Tour> findByDestinationContainingIgnoreCase(String destination);
}
