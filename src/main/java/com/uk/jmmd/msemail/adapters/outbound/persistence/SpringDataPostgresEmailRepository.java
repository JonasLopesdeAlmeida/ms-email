package com.uk.jmmd.msemail.adapters.outbound.persistence;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uk.jmmd.msemail.adapters.outbound.persistence.entities.EmailEntity;

@Repository
public interface SpringDataPostgresEmailRepository extends JpaRepository<EmailEntity, UUID> {
}
