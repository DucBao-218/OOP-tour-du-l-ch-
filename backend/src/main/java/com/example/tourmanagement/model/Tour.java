package com.example.tourmanagement.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tours")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name; // Tên tour

    @Column(nullable = false)
    private String startLocation; // Điểm khởi hành

    @Column(nullable = false)
    private String destination; // Điểm đến

    @Column(length = 1000)
    private String description; // Mô tả chi tiết
}

