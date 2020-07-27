package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Submission {

    @EmbeddedId
    private SubmissionID submissionID;

    @NotNull(message = "*Shouldn't be empty!")
    @Column(name = "score")
    private float score;

    @CreatedDate
    @Column(name = "created_at")
    private Timestamp createdAt;
}
