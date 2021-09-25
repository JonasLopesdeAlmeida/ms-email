package com.uk.jmmd.msemail.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.uk.jmmd.msemail.model.EmailModel;

public interface EmailRepository extends JpaRepository<EmailModel, Long>  {

}
