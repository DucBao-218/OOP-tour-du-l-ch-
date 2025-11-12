package com.example.tourmanagement.repository;

import com.example.tourmanagement.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
