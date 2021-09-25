package com.uk.jmmd.msemail.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.uk.jmmd.msemail.enums.StatusEmail;
import com.uk.jmmd.msemail.model.EmailModel;
import com.uk.jmmd.msemail.repositories.EmailRepository;

@Service
public class EmailService {
	
	@Autowired
	private EmailRepository emailrepository;
	@Autowired
	private JavaMailSender emailSender; //refers to java starter-mail dependency
	
	
	@SuppressWarnings("finally")
	public EmailModel sendEmail(EmailModel emailModel) {
		emailModel.setSendDateEmail(LocalDateTime.now());
		
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(emailModel.getEmailFrom());
			message.setTo(emailModel.getEmailTo());
			message.setSubject(emailModel.getSubject());
			message.setText(emailModel.getText());
			emailSender.send(message);
			
			//if ok, will be saved the email with SENT status
			emailModel.setStatusEmail(StatusEmail.SENT);
			
		} catch (MailException e) {
			//if not ok, will be set ERROR as a status
			emailModel.setStatusEmail(StatusEmail.ERROR);
		} finally {
			//will be saved the status if ok or not ok. For a future resender treatment. 
			return emailrepository.save(emailModel);
		}
	}
	

}
