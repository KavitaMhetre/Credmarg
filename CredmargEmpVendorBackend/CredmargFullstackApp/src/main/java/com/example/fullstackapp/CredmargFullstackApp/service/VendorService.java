package com.example.fullstackapp.CredmargFullstackApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fullstackapp.CredmargFullstackApp.model.EmailLog;
import com.example.fullstackapp.CredmargFullstackApp.model.Vendor;
import com.example.fullstackapp.CredmargFullstackApp.repo.EmailLogRepository;
import com.example.fullstackapp.CredmargFullstackApp.repo.VendorRepository;

@Service
public class VendorService {

	 	@Autowired
	    private VendorRepository vendorRepository;
	 	
	    @Autowired
	    private EmailLogRepository emailLogRepository;

	    public Vendor createVendor(Vendor vendor) {
	        return vendorRepository.save(vendor);
	    }

	    public List<Vendor> getAllVendors() {
	        return vendorRepository.findAll();
	    }
	    
	    public String sendEmailsToVendors(List<String> vendorEmails) {
	        List<Vendor> vendors = vendorRepository.findAllById(vendorEmails);
	        vendors.forEach(vendor -> {
	            String message = String.format("Sending payments to vendor %s at upi %s", vendor.getName(), vendor.getUpi());
	            System.out.println("Sending email to " + vendor.getEmail() + ": " + message);

	            EmailLog emailLog = new EmailLog();
	            emailLog.setRecipientEmail(vendor.getEmail());
	            emailLog.setMessage(message);
	            emailLogRepository.save(emailLog);
	        });
	        return "Emails sent!";
	    }

	    public List<EmailLog> getAllEmails() {
	        return emailLogRepository.findAll();
	    }
}
