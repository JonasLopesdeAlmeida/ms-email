package com.uk.jmmd.msemail.application.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.uk.jmmd.msemail.application.domain.Email;
import com.uk.jmmd.msemail.application.domain.PageInfo;
import com.uk.jmmd.msemail.application.domain.enums.StatusEmail;
import com.uk.jmmd.msemail.application.ports.EmailRepositoryPort;
import com.uk.jmmd.msemail.application.ports.EmailServicePort;
import com.uk.jmmd.msemail.application.ports.SendEmailServicePort;


public class EmailServiceImpl implements EmailServicePort  {

	private final EmailRepositoryPort emailRepositoryPort;
	private final SendEmailServicePort sendEmailServicePort;

	public EmailServiceImpl(final EmailRepositoryPort emailRepositoryPort, final SendEmailServicePort sendEmailServicePort) {
	        this.emailRepositoryPort = emailRepositoryPort;
	        this.sendEmailServicePort = sendEmailServicePort;
	    }

	@SuppressWarnings("finally")
	@Override
	    public Email sendEmail(Email email) {
	        email.setSendDateEmail(LocalDateTime.now());
	        try{
	            sendEmailServicePort.sendEmailSmtp(email);
	            email.setStatusEmail(StatusEmail.SENT);
	        } catch (Exception e){
	            email.setStatusEmail(StatusEmail.ERROR);
	        } finally {
	            return save(email);
	        }
	    }

	    @Override
	    public List<Email> findAll(PageInfo pageInfo) {
	       
	        return  emailRepositoryPort.findAll(pageInfo);
	    }

	    @Override
	    public Optional<Email> findById(UUID emailId) {
	      
	        return emailRepositoryPort.findById(emailId);
	    }

	    @Override
	    public Email save(Email email) {
	        return emailRepositoryPort.save(email);
	    }
	}
