package com.wtiinfo.wtimeta.services;

import java.text.NumberFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.wtiinfo.wtimeta.entities.Sale;
import com.wtiinfo.wtimeta.repositories.SaleRepository;

@Service
public class SMSService {

	@Value("${twilio.sid}")
	private String twilioSid;

	@Value("${twilio.key}")
	private String twilioKey;

	@Value("${twilio.phone.from}")
	private String twilioPhoneFrom;

	@Value("${twilio.phone.to}")
	private String twilioPhoneTo;
	
	@Autowired
	private SaleRepository repository;
	
	private static final NumberFormat nf = NumberFormat.getCurrencyInstance();

	public void sendSms(Long saleId) {

		Sale sale = repository.findById(saleId).orElseThrow();
		String dataSale = sale.getDate().getMonthValue() + "/" + sale.getDate().getYear();
		
		StringBuilder msg = new StringBuilder();
		msg.append("Vendedor " + sale.getSellerName())
			.append(" fez " + sale.getDeals())
			.append(" vendas. Em " + dataSale)
			.append(" Total: " + nf.format(sale.getAmount()))
	;
		Twilio.init(twilioSid, twilioKey);

		PhoneNumber to = new PhoneNumber(twilioPhoneTo);
		PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

		Message message = Message.creator(to, from, msg.toString()).create();

		System.out.println(message.getSid());
	}
}