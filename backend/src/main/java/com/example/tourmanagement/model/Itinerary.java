package com.example.tourmanagement.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "itineraries")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Itinerary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer dayOrder; // Thứ tự ngày trong lịch trình

    @ManyToOne
    @JoinColumn(name = "tour_id", nullable = false)
    private Tour tour;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;
}
