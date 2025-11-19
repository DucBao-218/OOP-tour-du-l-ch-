package com.example.tourmanagement.service;

import com.example.tourmanagement.dto.TicketDTO;
import com.example.tourmanagement.mapper.TicketMapper;
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
    private final TicketMapper ticketMapper;

    public TicketService(TicketRepository ticketRepo,
                         DepartureDateRepository departureDateRepo,
                         TicketMapper ticketMapper) {
        this.ticketRepo = ticketRepo;
        this.departureDateRepo = departureDateRepo;
        this.ticketMapper = ticketMapper;
    }

    // Trả về DTO thay vì entity
    public List<TicketDTO> getAllTickets() {
        return ticketRepo.findAll()
                         .stream()
                         .map(ticket -> {
                             TicketDTO dto = ticketMapper.toDTO(ticket);
                             dto.setTicketsCount(ticketRepo.countByCustomer(ticket.getCustomer()));
                             return dto;
                         })
                         .toList();
    }

    public TicketDTO getTicketById(Long id) {
        return ticketRepo.findById(id)
                         .map(ticket -> {
                             TicketDTO dto = ticketMapper.toDTO(ticket);
                             dto.setTicketsCount(ticketRepo.countByCustomer(ticket.getCustomer()));
                             return dto;
                         })
                         .orElse(null);
    }

    public TicketDTO createTicket(Ticket ticket) {
        DepartureDate departureDate = departureDateRepo.findById(ticket.getDepartureDate().getId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy ngày khởi hành"));

        if (departureDate.getAvailableSeats() <= 0) {
            throw new RuntimeException("Không có chỗ ngồi nào cho ngày khởi hành này");
        }

        departureDate.setAvailableSeats(departureDate.getAvailableSeats() - 1);
        departureDateRepo.save(departureDate);

        ticket.setStatus("BOOKED");
        Ticket saved = ticketRepo.save(ticket);

        TicketDTO dto = ticketMapper.toDTO(saved);
        dto.setTicketsCount(ticketRepo.countByCustomer(saved.getCustomer()));
        return dto;
    }

    public TicketDTO updateTicket(Long id, Ticket updated) {
        Ticket existing = ticketRepo.findById(id).orElse(null);
        if (existing != null) {
            existing.setBookingDate(updated.getBookingDate());
            existing.setCustomer(updated.getCustomer());
            existing.setDepartureDate(updated.getDepartureDate());
            Ticket saved = ticketRepo.save(existing);

            TicketDTO dto = ticketMapper.toDTO(saved);
            dto.setTicketsCount(ticketRepo.countByCustomer(saved.getCustomer()));
            return dto;
        }
        return null;
    }

    public void deleteTicket(Long id) {
        ticketRepo.deleteById(id);
    }

    public TicketDTO cancelTicket(Long id) {
        Ticket ticket = ticketRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy vé"));

        ticket.setStatus("CANCELLED");

        DepartureDate departureDate = ticket.getDepartureDate();
        departureDate.setAvailableSeats(departureDate.getAvailableSeats() + 1);
        departureDateRepo.save(departureDate);

        Ticket saved = ticketRepo.save(ticket);

        TicketDTO dto = ticketMapper.toDTO(saved);
        dto.setTicketsCount(ticketRepo.countByCustomer(saved.getCustomer()));
        return dto;
    }
}
