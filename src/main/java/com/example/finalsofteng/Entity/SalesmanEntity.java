package com.example.finalsofteng.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="salesman")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesmanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double amount;
    private Date dot;
    private String item;
    private String name;
}
