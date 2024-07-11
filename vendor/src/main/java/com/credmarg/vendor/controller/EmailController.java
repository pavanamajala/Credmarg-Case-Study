package com.credmarg.vendor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credmarg.vendor.service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/send")
    public ResponseEntity<List<String>> sendEmails(@RequestBody List<String> emailIds) {
		List<String> messages = emailService.sendEmailToVendor(emailIds);
		return ResponseEntity.ok(messages);
    }

}
