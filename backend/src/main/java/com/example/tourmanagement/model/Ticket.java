package com.example.tourmanagement.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "tickets")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Ngày đặt vé
    @Column(nullable = false)
    private LocalDate bookingDate;

    // Liên kết với Customer (một khách hàng có thể có nhiều vé)
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    // Liên kết với DepartureDate (một ngày khởi hành có nhiều vé)
    @ManyToOne
    @JoinColumn(name = "departure_date_id", nullable = false)
    private DepartureDate departureDate;

    @Column(nullable = false)
    private String status = "BOOKED"; // mặc định khi tạo vé

}
