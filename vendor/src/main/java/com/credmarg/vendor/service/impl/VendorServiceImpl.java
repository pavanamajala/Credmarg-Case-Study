package com.credmarg.vendor.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
		vendorList.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));
        return vendorList;
    }

	@Override
	public  List<Vendor> getByNames(String id) {
		vendorList.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));
		return vendorList.stream().filter(e -> e.getName().contains(id)).collect(Collectors.toList());
	}
    

}
