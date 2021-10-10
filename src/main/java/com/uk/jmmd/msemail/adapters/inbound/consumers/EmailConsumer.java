package com.uk.jmmd.msemail.adapters.inbound.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.uk.jmmd.msemail.adapters.dtos.EmailDto;
import com.uk.jmmd.msemail.application.domain.Email;
import com.uk.jmmd.msemail.application.ports.EmailServicePort;

@Component
public class EmailConsumer {

	@Autowired
    EmailServicePort emailServicePort;
   
   //this method will be used to listen the defined queue such as in the application-properties as config class: ${spring.rabbitmq.queue}
   //this annotation @RabbitListener defines this method as a listener.
   @RabbitListener(queues = "${spring.rabbitmq.queue}")
   public void listen(@Payload EmailDto emailDto) {
	   Email email = new Email();
	   BeanUtils.copyProperties(emailDto, email);
	   emailServicePort.sendEmail(email);
	   System.out.println("Email Status: " + email.getStatusEmail().toString());
   }

}
