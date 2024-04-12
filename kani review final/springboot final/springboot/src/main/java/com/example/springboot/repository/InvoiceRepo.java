package com.example.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.model.Invoice;

public interface InvoiceRepo extends JpaRepository<Invoice, Integer> {

    List<Invoice> findByAddressOrAccountNumber(String address, String accountNumber);





}
