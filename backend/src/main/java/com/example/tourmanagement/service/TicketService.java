package com.example.tourmanagement.service;

import com.example.tourmanagement.model.Ticket;
import com.example.tourmanagement.model.DepartureDate;
import com.example.tourmanagement.repository.TicketRepository;
import com.example.tourmanagement.repository.DepartureDateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    private final TicketRepository ticketRepo;
    private final DepartureDateRepository departureDateRepo;

    public TicketService(TicketRepository ticketRepo, DepartureDateRepository departureDateRepo) {
        this.ticketRepo = ticketRepo;
        this.departureDateRepo = departureDateRepo;
    }

    public List<Ticket> getAllTickets() {
        return ticketRepo.findAll();
    }

    public Ticket getTicketById(Long id) {
        return ticketRepo.findById(id).orElse(null);
    }

    public Ticket createTicket(Ticket ticket) {
        // Lấy DepartureDate từ DB
        DepartureDate departureDate = departureDateRepo.findById(ticket.getDepartureDate().getId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy ngày khởi hành"));

        // Kiểm tra số ghế còn lại
        if (departureDate.getAvailableSeats() <= 0) {
            throw new RuntimeException("Không có chỗ ngồi nào cho ngày khởi hành này");
        }

        // Giảm số ghế
        departureDate.setAvailableSeats(departureDate.getAvailableSeats() - 1);
        departureDateRepo.save(departureDate);

        // Lưu Ticket
        return ticketRepo.save(ticket);
    }

    public Ticket updateTicket(Long id, Ticket updated) {
        Ticket existing = ticketRepo.findById(id).orElse(null);
        if (existing != null) {
            existing.setBookingDate(updated.getBookingDate());
            existing.setCustomer(updated.getCustomer());
            existing.setDepartureDate(updated.getDepartureDate());
            return ticketRepo.save(existing);
        }
        return null;
    }

    public void deleteTicket(Long id) {
        ticketRepo.deleteById(id);
    }
}
