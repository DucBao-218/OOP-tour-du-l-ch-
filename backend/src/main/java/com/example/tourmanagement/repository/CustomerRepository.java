package com.example.tourmanagement.repository;

import com.example.tourmanagement.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Tìm khách hàng theo email
    Customer findByEmail(String email);

    // Tìm khách hàng theo số điện thoại
    Customer findByPhone(String phone);

    // Tìm khách hàng theo tên đại diện đoàn
    List<Customer> findByRepresentativeNameContainingIgnoreCase(String name);
}
