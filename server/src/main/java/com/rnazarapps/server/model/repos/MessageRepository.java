package com.rnazarapps.server.model.repos;

import com.rnazarapps.server.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}

