package com.example.tourmanagement.controller;

import com.example.tourmanagement.dto.TicketDTO;
import com.example.tourmanagement.model.Ticket;
import com.example.tourmanagement.service.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@CrossOrigin(origins = "http://localhost:5173")
public class TicketController {
    private final TicketService service;

    public TicketController(TicketService service) {
        this.service = service;
    }

    @GetMapping
    public List<TicketDTO> getAllTickets() {
        return service.getAllTickets();
    }

    @GetMapping("/{id}")
    public TicketDTO getTicketById(@PathVariable Long id) {
        return service.getTicketById(id);
    }

    @PostMapping
    public TicketDTO createTicket(@RequestBody Ticket ticket) {
        return service.createTicket(ticket);
    }

    @PutMapping("/{id}")
    public TicketDTO updateTicket(@PathVariable Long id, @RequestBody Ticket ticket) {
        return service.updateTicket(id, ticket);
    }

    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable Long id) {
        service.deleteTicket(id);
    }

    @PutMapping("/{id}/cancel")
    public TicketDTO cancelTicket(@PathVariable Long id) {
        return service.cancelTicket(id);
    }
}
