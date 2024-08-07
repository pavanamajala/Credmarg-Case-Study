package com.credmarg.vendor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credmarg.vendor.entity.Vendor;
import com.credmarg.vendor.service.VendorService;

@RestController
@RequestMapping("/vendor")
public class VendorController {

	@Autowired
    private VendorService vendorService;
    
    @PostMapping("/create")
    public ResponseEntity<String> createVendor(@RequestBody Vendor vendor) {
        vendorService.saveVendor(vendor);
        return ResponseEntity.ok("Vendor created successfully");
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<Vendor>> getAllVendors() {
        List<Vendor> vendors = vendorService.getAllVendors();
        return ResponseEntity.ok(vendors);
    }
    
    @GetMapping("/getByname/{id}")
    public ResponseEntity<List<Vendor>> getByNames(@PathVariable String id) {
		return ResponseEntity.ok(vendorService.getByNames(id)); 
    }
    
}
