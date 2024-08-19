package com.mdt.transaction_service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name="transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transactionId")
    private Integer transactionId;
    @Column(name = "accountId")
    private Integer accountId;
    @Column(name = "totalAmount")
    private Integer totalAmount;
    @Column(name = "amount")
    private Integer amount;
    @Column(name = "description")
    private String description;
    @Column(name = "timestamp")
    @CreationTimestamp
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="YYYY-MM-DD")
    private LocalDateTime timestamp;
}
