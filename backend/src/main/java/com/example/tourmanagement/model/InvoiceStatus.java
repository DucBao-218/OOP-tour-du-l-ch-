package com.example.tourmanagement.model;

public enum InvoiceStatus {
    PAID,       // Hóa đơn đã thanh toán
    UNPAID,     // Hóa đơn chưa thanh toán
    CANCELLED   // Hóa đơn bị hủy (do khách hủy vé, có phí phạt)
}
