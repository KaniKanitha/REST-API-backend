package com.example.springboot.controller;

import com.example.springboot.model.Invoice;
import com.example.springboot.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// @RequestMapping("/api/passengers")
public class InvoiceController {

    @Autowired
    private InvoiceService passengerService;

    @PostMapping("/postp")
    public ResponseEntity<Invoice> addPassenger(@RequestBody Invoice passenger) {
        Invoice createdPassenger = passengerService.create(passenger);
        return new ResponseEntity<>(createdPassenger, HttpStatus.CREATED);
    }
    
    @GetMapping("/getp")
    public ResponseEntity<List<Invoice>> getUserData() {
        return new ResponseEntity<>(passengerService.getAllDetails(), HttpStatus.OK);
    }
    
    @GetMapping("/api/invoice/sortBy/{productName}")
    public List<Invoice> g(@PathVariable String productName)
    {
        return passengerService.sort(productName);
    }

    @GetMapping("/api/invoice/{offset}/{pagesize}")
    public List<Invoice> get(@PathVariable int offset,@PathVariable int pagesize)
    {
        return passengerService.page(pagesize, offset);
    }


    @GetMapping("/api/invoice/{offset}/{pagesize}/{productName}")
    public List<Invoice> getsorting(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String productName)
    {
        return passengerService.getsort(offset,pagesize,productName);
    }
    
    @GetMapping("select/query/{address}/{accountNumber}")
	public List <Invoice> displayAll(@PathVariable String address, @PathVariable String accountNumber){
		return passengerService.getDetails(address,accountNumber);
	}



    @PutMapping("/putp/{passengerId}")
    public ResponseEntity<Invoice> updatePassenger(
            @PathVariable int passengerId,
            @RequestBody Invoice passenger
    ) {
        boolean updated = passengerService.updateDetails(passengerId, passenger);
        if (updated) {
            return new ResponseEntity<>(passenger, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delp/{passengerId}")
    public ResponseEntity<Boolean> deletePassenger(@PathVariable int productId) {
        boolean deleted = passengerService.deletePassenger(productId);
        if (deleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}

