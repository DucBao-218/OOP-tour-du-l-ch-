package com.example.tourmanagement.repository;

import com.example.tourmanagement.model.Customer;
import com.example.tourmanagement.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Long countByCustomer(Customer customer);
}
