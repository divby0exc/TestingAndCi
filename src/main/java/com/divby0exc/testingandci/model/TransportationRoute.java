package com.divby0exc.testingandci.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransportationRoute {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long routeId;
    private String departurePoint;
    private String arrivalPoint;
    private String typeOfTransport;
    private String estimatedDeparture;
    private String estimatedArrival;
    private int ticketPrice;
    private String transportationCompany;
    private double discountPrice;
}