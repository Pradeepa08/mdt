package com.mdt.account_service.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accountId")
    private Integer accountId;
    @Column(name = "userId")
    private Integer userId;
    @Column(name = "userName")
    private String userName;
    @Column(name = "email")
    private String email;
    @Column(name = "accountType")
    private String accountType;
    @Column(name = "balance")
    private Integer balance;
    @Column(name = "aadhaar")
    private String aadhaar;

    @Column(name = "createdAt")
    @CreationTimestamp
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="YYYY-MM-DD")
    private LocalDateTime createdAt;

    @Column(name = "updatedAt")
    @UpdateTimestamp
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="YYYY-MM-DD")
    private LocalDateTime updatedAt;
}
