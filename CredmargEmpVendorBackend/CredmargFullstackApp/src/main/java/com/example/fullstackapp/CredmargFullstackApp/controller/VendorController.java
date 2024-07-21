package com.example.fullstackapp.CredmargFullstackApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fullstackapp.CredmargFullstackApp.model.EmailLog;
import com.example.fullstackapp.CredmargFullstackApp.model.Vendor;
import com.example.fullstackapp.CredmargFullstackApp.service.VendorService;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {

	@Autowired
    private VendorService vendorService;

    @PostMapping
    public Vendor createVendor(@RequestBody Vendor vendor) {
        return vendorService.createVendor(vendor);
    }

    @GetMapping
    public List<Vendor> getAllVendors() {
        return vendorService.getAllVendors();
    }

    @PostMapping("/send-emails")
    public String sendEmails(@RequestBody List<String> vendorEmails) {
        return vendorService.sendEmailsToVendors(vendorEmails);
    }

    @GetMapping("/emails")
    public List<EmailLog> getAllEmails() {
        return vendorService.getAllEmails();
    }
}
