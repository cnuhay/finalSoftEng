package com.example.finalsofteng.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

// https://github.com/cnuhay/finalSoftEng
@Entity
@Table(name="salesman")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesmanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
    private String salesmanName;
    private String itemType;
    private int salesAmount;
    private LocalDate transactionDate;
}
