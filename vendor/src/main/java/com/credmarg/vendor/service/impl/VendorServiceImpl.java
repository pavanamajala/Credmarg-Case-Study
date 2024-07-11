package com.credmarg.vendor.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.credmarg.vendor.entity.Vendor;
import com.credmarg.vendor.service.VendorService;

@Service
public class VendorServiceImpl implements VendorService {

	private List<Vendor> vendorList = new ArrayList<>();
    
    public void saveVendor(Vendor vendor) {
        vendorList.add(vendor);
    }
    
    public List<Vendor> getAllVendors() {
        return vendorList;
    }
    

}
