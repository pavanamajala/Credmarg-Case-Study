package com.credmarg.vendor.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credmarg.vendor.service.EmailService;
import com.credmarg.vendor.service.VendorService;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private VendorService vendorService;

	private static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

	public List<String> sendEmailToVendor(List<String> emailIds) {

		List<String> messages = vendorService.getAllVendors().stream()
				.filter(e -> emailIds.contains(e.getEmail()))
				.map(e -> "Sending payments to vendor " + e.getName() + " at " + e.getUPI())
				.collect(Collectors.toList());

		messages.forEach(e -> logger.info(e));

		return messages;
	}
}
