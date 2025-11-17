package com.example.tourmanagement.repository;

import com.example.tourmanagement.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    // Nếu cần thêm query tuỳ chỉnh thì viết ở đây
    // Ví dụ: tìm tất cả ticket theo customerId
    // List<Ticket> findByCustomerId(Long customerId);
}
