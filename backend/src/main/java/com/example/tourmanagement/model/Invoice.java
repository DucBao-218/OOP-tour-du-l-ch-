package com.example.tourmanagement.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "invoices")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Ngày xuất hóa đơn
    @Column(nullable = false)
    private LocalDate invoiceDate;

    // Giá vé đơn vị (lấy từ DepartureDate.price)
    @Column(nullable = false)
    private Double amount;

    // Số lượng khách
    @Column(nullable = false)
    private Integer quantity;

    // Tổng tiền = amount * quantity
    @Column(nullable = false)
    private Double totalAmount;

    // Phương thức thanh toán (Cash, Credit Card, Bank Transfer...)
    @Column(nullable = false)
    private String paymentMethod;

    // Liên kết 1-1 với Ticket
    @OneToOne
    @JoinColumn(name = "ticket_id", nullable = false, unique = true)
    private Ticket ticket;
}
