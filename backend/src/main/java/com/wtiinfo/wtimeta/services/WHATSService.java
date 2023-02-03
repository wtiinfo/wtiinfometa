package com.wtiinfo.wtimeta.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class WHATSService {

	@Value("${twilio.sid}")
	private String twilioSid;

	@Value("${twilio.key}")
	private String twilioKey;
	
	// detalhes em https://www.twilio.com/en-us/whatsapp/request-access

	private String twilioPhoneFromWhats = "whatsapp:+";

	private String twilioPhoneToWhats= "whatsapp:+";

	public void sendWhats() {

		Twilio.init(twilioSid, twilioKey);

		PhoneNumber to = new PhoneNumber(twilioPhoneToWhats);
		PhoneNumber from = new PhoneNumber(twilioPhoneFromWhats);

		Message message = Message.creator(to, from, "MSG").create();

		System.out.println(message.getSid());
	}
}