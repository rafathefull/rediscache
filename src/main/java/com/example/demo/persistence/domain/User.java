package com.example.demo.persistence.domain;

import com.example.demo.config.DateFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "User")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    private String name;

    private String username;

    private String email;

    @JsonIgnore
    private String password;

    private Integer errorLoginAttempts;

    private Boolean blocked;

    private Boolean active;

    @Column(name = "CreatedDate", updatable = false)
    @JsonFormat(pattern = DateFormat.dateTimePattern, timezone = DateFormat.dateTimezone)
    @CreatedDate
    protected LocalDateTime createdDate;

    @Column(updatable = false, name = "createdUserId")
    protected Integer createdUser;


    public User() {
    }

}