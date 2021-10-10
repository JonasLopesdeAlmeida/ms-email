package com.uk.jmmd.msemail.adapters.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class EmailDto {

	@NotBlank //this field must be filled
	private String ownerRef;
	
	@Email //verifies a valid email
	@NotBlank //this field must be filled
	private String emailFrom;
	
	@Email //verifies a valid email
	@NotBlank //this field must be filled
	private String emailTo;
	
	@NotBlank //this field must be filled
	private String subject;
	
	@NotBlank //this field must be filled
	private String text;

	
}
