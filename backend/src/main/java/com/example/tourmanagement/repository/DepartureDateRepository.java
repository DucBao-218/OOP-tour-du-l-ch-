package com.example.tourmanagement.repository;

import com.example.tourmanagement.model.DepartureDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartureDateRepository extends JpaRepository<DepartureDate, Long> {
    List<DepartureDate> findByTourId(Long tourId); // Lấy danh sách ngày khởi hành theo tour
}
