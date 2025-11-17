package com.example.tourmanagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "itinerary_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItineraryDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Liên kết tới lịch trình (ngày + địa điểm)
    @ManyToOne
    @JoinColumn(name = "itinerary_id", nullable = false)
    @JsonBackReference
    private Itinerary itinerary;

    // Liên kết tới tiện ích/dịch vụ
    @ManyToOne
    @JoinColumn(name = "amenity_id", nullable = false)
    private Amenity amenity;

    // Nhà cung cấp dịch vụ
    private String providerName;

    // Giá dịch vụ
    private Double price;
}
