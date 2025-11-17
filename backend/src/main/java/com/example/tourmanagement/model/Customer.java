package com.example.tourmanagement.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Tên đại diện đoàn
    @Column(nullable = false)
    private String representativeName;

    // Số CMND/CCCD/Hộ chiếu
    @Column(nullable = false, unique = true, length = 20)
    private String documentNumber;

    // Loại giấy tờ (CMND/CCCD/Hộ chiếu)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private DocumentType documentType;

    // Địa chỉ khách hàng
    @Column(nullable = false)
    private String address;

    // Số điện thoại
    @Column(nullable = false)
    private String phone;

    // Email
    @Column(nullable = false)
    private String email;
}
