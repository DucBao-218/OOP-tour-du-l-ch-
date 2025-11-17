package com.example.tourmanagement.service;

import com.example.tourmanagement.model.Invoice;
import com.example.tourmanagement.model.Ticket;
import com.example.tourmanagement.repository.InvoiceRepository;
import com.example.tourmanagement.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {
    private final InvoiceRepository invoiceRepo;
    private final TicketRepository ticketRepo;

    public InvoiceService(InvoiceRepository invoiceRepo, TicketRepository ticketRepo) {
        this.invoiceRepo = invoiceRepo;
        this.ticketRepo = ticketRepo;
    }

    public List<Invoice> getAllInvoices() {
        return invoiceRepo.findAll();
    }

    public Invoice getInvoiceById(Long id) {
        return invoiceRepo.findById(id).orElse(null);
    }

    public Invoice createInvoice(Invoice invoice) {
        // Lấy ticket từ DB bằng id
        Long ticketId = invoice.getTicket().getId();
        Ticket ticket = ticketRepo.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        // Lấy giá từ DepartureDate
        Double price = ticket.getDepartureDate().getPrice();

        // Gán lại ticket đầy đủ vào invoice
        invoice.setTicket(ticket);
        invoice.setAmount(price);
        invoice.setTotalAmount(price * invoice.getQuantity());

        return invoiceRepo.save(invoice);
    }

    public Invoice updateInvoice(Long id, Invoice updated) {
        Invoice existing = invoiceRepo.findById(id).orElse(null);
        if (existing != null) {
            existing.setInvoiceDate(updated.getInvoiceDate());
            existing.setPaymentMethod(updated.getPaymentMethod());
            existing.setQuantity(updated.getQuantity());

            // Lấy ticket từ DB bằng id
            Long ticketId = updated.getTicket().getId();
            Ticket ticket = ticketRepo.findById(ticketId)
                    .orElseThrow(() -> new RuntimeException("Ticket not found"));

            Double price = ticket.getDepartureDate().getPrice();

            existing.setTicket(ticket);
            existing.setAmount(price);
            existing.setTotalAmount(price * updated.getQuantity());

            return invoiceRepo.save(existing);
        }
        return null;
    }

    public void deleteInvoice(Long id) {
        invoiceRepo.deleteById(id);
    }
}
