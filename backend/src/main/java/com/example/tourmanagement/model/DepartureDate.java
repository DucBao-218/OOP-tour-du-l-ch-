package com.example.tourmanagement.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "departure_dates")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepartureDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Ngày khởi hành
    @Column(nullable = false)
    private LocalDate departureDay;

    // Giá vé cho ngày đó
    @Column(nullable = false)
    private Double price;

    // Số ghế còn lại
    @Column(nullable = false)
    private Integer availableSeats;

    // Liên kết với Tour
    @ManyToOne
    @JoinColumn(name = "tour_id", nullable = false)
    private Tour tour;
}
