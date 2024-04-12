package com.example.springboot.service;

import com.example.springboot.model.Invoice;
import com.example.springboot.repository.InvoiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepo invoiceRepo;

    public Invoice create(Invoice invoice) {
        return invoiceRepo.save(invoice);
    }

    public List<Invoice> getAllDetails() {
        return invoiceRepo.findAll();
    }

    public Invoice getInvoiceById(int id) {
        return invoiceRepo.findById(id).orElse(null);
    }

    public List<Invoice> getsort(int pageNumber, int pageSize, String productName) {
        return invoiceRepo.findAll(PageRequest.of(pageNumber, pageSize)
                .withSort(Sort.by(Sort.Direction.ASC, productName))).getContent();
    }

    public List<Invoice> sort(String productName)
    {
        Sort sort=Sort.by(Sort.Direction.ASC,productName);
        return invoiceRepo.findAll(sort);
    }


    public List<Invoice> page(int pageSize,int pageNumber)
    {
        Pageable page=PageRequest.of(pageNumber, pageSize);
        return invoiceRepo.findAll(page).getContent();
    }


    
   

    public List <Invoice> getDetails(String address, String accountNumber){
        return invoiceRepo.findByAddressOrAccountNumber(address,accountNumber);
    }

    

    public boolean updateDetails(int id, Invoice invoice) {
        if (!invoiceRepo.existsById(id)) {
            return false;
        }
        invoice.setProductId(id); // Ensure the invoice object has the correct ID
        invoiceRepo.save(invoice);
        return true;
    }

    public boolean deleteInvoice(int id) {
        if (!invoiceRepo.existsById(id)) {
            return false;
        }
        invoiceRepo.deleteById(id);
        return true;
    }

    public boolean deletePassenger(int productId) {
        
        throw new UnsupportedOperationException("Unimplemented method 'deletePassenger'");
    }

    public List<Invoice> getdetails(String address, String accountNumber) {
        throw new UnsupportedOperationException("Unimplemented method 'getdetails'");
    }
}
