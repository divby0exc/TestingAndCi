package com.divby0exc.testingandci.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String username;
    private String contactInfo;
    private String paymentInfo;
    //    Tickets you bought but haven't used yet
    private String accountType;
}