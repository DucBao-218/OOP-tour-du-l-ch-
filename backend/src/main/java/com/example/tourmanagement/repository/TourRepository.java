package com.example.tourmanagement.repository;

import com.example.tourmanagement.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {
    // Có thể thêm các hàm tìm kiếm tùy chọn sau này, ví dụ:
    // List<Tour> findByDestinationContainingIgnoreCase(String keyword);
}
