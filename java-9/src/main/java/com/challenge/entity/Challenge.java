package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Challenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "*Shouldn't be empty!")
    @NotBlank
    @Size(max = 100, message = "*Must be up to 100 characters!")
    @Column(name = "name")
    private String name;

    @NotNull(message = "*Required!")
    @NotBlank
    @Size(max = 50, message = "*Must be up to 50 characters!")
    @Column(name = "slug")
    private String slug;

    @CreatedDate
    @Column(name = "created_at")
    private Timestamp createdAt;

    @OneToMany
    private List<Acceleration> accelerationList;

    @OneToMany
    private List<Submission> submissionList;
}
