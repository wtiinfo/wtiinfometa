package com.wtiinfo.wtimeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wtiinfo.wtimeta.entities.Sale;
import com.wtiinfo.wtimeta.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	//Data atual do sistema
	private LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
	
	public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable) {
		LocalDate min = minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);//verificando data não foi informada
		LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);//verificando data não foi informada
		return repository.findSales(min, max, pageable);
	}
}
