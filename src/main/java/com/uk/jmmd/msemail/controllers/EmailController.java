package com.uk.jmmd.msemail.controllers;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uk.jmmd.msemail.dtos.EmailDto;
import com.uk.jmmd.msemail.model.EmailModel;
import com.uk.jmmd.msemail.services.EmailService;

@RestController
@RequestMapping(value ="v1/emails")
public class EmailController {
	
	@Autowired
    EmailService emailservice;
	
	@PostMapping("/sending-email")
	public ResponseEntity<EmailModel> sendingEmail(@RequestBody @Valid EmailDto emaildto){
		EmailModel emailmodel = new EmailModel();
		BeanUtils.copyProperties(emaildto, emailmodel);
		emailservice.sendEmail(emailmodel);
		return new ResponseEntity<>(emailmodel, HttpStatus.CREATED);
	}

}
