package com.example.tourmanagement.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketDTO {
    private Long id;

    // Thông tin tour
    private String tourName;
    private String startLocation;
    private String destination;

    // Ngày khởi hành
    private LocalDate departureDate;

    // Thông tin khách hàng
    private String customerName;
    private String identityType;   // từ DocumentType (enum)
    private String identityNumber;
    private String phone;
    private String email;
    private String address;

    // Giá vé
    private Double pricePerPerson;
    private Double totalAmount;

    // Trạng thái vé
    private String status;

    private Long ticketsCount;
}
