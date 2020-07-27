package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "candidate")
public class Candidate {

    @EmbeddedId
    private CandidateID candidateID;

    @NotNull(message = "*Required!")
    @Column(name = "status")
    private int status;

    @CreatedDate
    @Column(name = "created_at")
    private Timestamp createdAt;
}
