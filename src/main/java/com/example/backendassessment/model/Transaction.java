package com.example.backendassessment.model;

import com.example.backendassessment.constant.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    private TransactionType type;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
