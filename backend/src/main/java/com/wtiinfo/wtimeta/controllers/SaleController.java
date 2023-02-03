package com.wtiinfo.wtimeta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wtiinfo.wtimeta.entities.Sale;
import com.wtiinfo.wtimeta.services.SMSService;
import com.wtiinfo.wtimeta.services.SaleService;
import com.wtiinfo.wtimeta.services.WHATSService;

@RestController
@RequestMapping("/sales")
public class SaleController {

	@Autowired
	private SaleService service;
	
	@Autowired
	private SMSService sms;
	
	@Autowired
	private WHATSService whats;

	@GetMapping
	public Page<Sale> findSales(
			@RequestParam(value = "minDate", defaultValue = "") String minDate, 
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate,
			Pageable pageable) 
	{
		return service.findSales(minDate, maxDate, pageable);
	}
	
	@GetMapping("/{id}/notification-sms")
	public void notifySMS(@PathVariable Long id) {
		sms.sendSms(id);
	}
	
	@GetMapping("/notification-whats")
	public void notifyWHATS() {
		whats.sendWhats();
	}
}
