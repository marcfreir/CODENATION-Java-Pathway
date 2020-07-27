package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "*Shouldn't be empty!")
    @NotBlank
    @Size(max = 100, message = "*Must be up to 100 characters!")
    @Column(name = "full_name")
    private String fullName;

    @NotNull(message = "*Shouldn't be empty!")
    @NotBlank
    @Email
    @Size(max = 100, message = "*Must be up to 100 characters!")
    @Column(name = "email")
    private String email;

    @NotNull(message = "*Shouldn't be empty!")
    @NotBlank
    @Size(max = 50, message = "*Must be up to 50 characters!")
    @Column(name = "nickname")
    private String nickname;

    @NotNull(message = "*Shouldn't be empty!")
    @NotBlank
    @Size(max = 255)
    @Column(name = "password")
    private String password;

    @CreatedDate
    @Column(name = "created_at")
    private Timestamp createdAt;

    @OneToMany
    private List<Candidate> candidateList;

    @OneToMany
    private List<Submission> submissionList;
}
