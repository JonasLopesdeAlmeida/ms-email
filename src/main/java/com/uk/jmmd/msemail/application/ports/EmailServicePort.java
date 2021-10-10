package com.uk.jmmd.msemail.application.ports;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.uk.jmmd.msemail.application.domain.Email;
import com.uk.jmmd.msemail.application.domain.PageInfo;

public interface EmailServicePort {

    Email sendEmail(Email email);
    List<Email> findAll(PageInfo pageInfo);
    Optional<Email> findById(UUID emailId);
    Email save(Email email);
}
