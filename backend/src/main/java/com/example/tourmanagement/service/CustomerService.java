package com.example.tourmanagement.service;

import com.example.tourmanagement.model.Customer;
import com.example.tourmanagement.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository repo;

    public CustomerService(CustomerRepository repo) {
        this.repo = repo;
    }

    public List<Customer> getAllCustomers() {
        return repo.findAll();
    }

    public Customer getCustomerById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Customer createCustomer(Customer customer) {
        return repo.save(customer);
    }

    public Customer updateCustomer(Long id, Customer updated) {
        Customer existing = repo.findById(id).orElse(null);
        if (existing != null) {
            existing.setRepresentativeName(updated.getRepresentativeName());
            existing.setDocumentNumber(updated.getDocumentNumber());
            existing.setDocumentType(updated.getDocumentType());
            existing.setAddress(updated.getAddress());
            existing.setPhone(updated.getPhone());
            existing.setEmail(updated.getEmail());
            return repo.save(existing);
        }
        return null;
    }

    public void deleteCustomer(Long id) {
        repo.deleteById(id);
    }
}
