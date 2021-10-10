package com.uk.jmmd.msemail.adapters.configuration;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.uk.jmmd.msemail.MsEmailApplication;
import com.uk.jmmd.msemail.application.ports.EmailRepositoryPort;
import com.uk.jmmd.msemail.application.ports.SendEmailServicePort;
import com.uk.jmmd.msemail.application.services.EmailServiceImpl;

@Configuration
@ComponentScan(basePackageClasses = MsEmailApplication.class)
public class BeanConfiguration {

    @Bean
    EmailServiceImpl emailServiceImpl(EmailRepositoryPort repository, SendEmailServicePort sendEmailServicePort) {
        return new EmailServiceImpl(repository, sendEmailServicePort);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
