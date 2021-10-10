package com.uk.jmmd.msemail.application.ports;

import com.uk.jmmd.msemail.application.domain.Email;

public interface SendEmailServicePort {

    void sendEmailSmtp(Email email);
}
