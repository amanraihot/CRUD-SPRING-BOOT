package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    @Column(name = "userId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;

    @Column(name = "userName")
    @NotBlank(message = "Enter Username")
    private String userName;

    @NotBlank(message = "Without password we will not let you in")
    @Column(name = "password")
    private String password;

    @Email
    @NotBlank(message = "Email id is important")
    @Column(name = "emailId")
    private String email;



}
