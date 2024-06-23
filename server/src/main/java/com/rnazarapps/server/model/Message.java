package com.rnazarapps.server.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private Long authorId;
    private LocalDateTime timestamp;

    // Getters and setters
}

