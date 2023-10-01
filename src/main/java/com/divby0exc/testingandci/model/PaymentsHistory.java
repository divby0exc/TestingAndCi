package com.divby0exc.testingandci.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Data
public class PaymentsHistory {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long paymentId;
    private Long accountId;
    private Long routeId;
}
