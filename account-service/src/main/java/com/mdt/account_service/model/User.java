package com.mdt.account_service.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")

    private Integer id;
    @Column(name = "userName")

    private String userName;
    @Column(name = "password")

    private String password;
    @Column(name = "email")

    private String email;
    @Column(name = "role")

    private String role;
}
