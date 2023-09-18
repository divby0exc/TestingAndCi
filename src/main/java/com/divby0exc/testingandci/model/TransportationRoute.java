package com.divby0exc.testingandci.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Data
@Builder
public class TransportationRoute {
    private String departurePoint;
    private String arrivalPoint;
    private String typeOfTransport;
    private String estimatedDeparture;
    private String estimatedArrival;
    private int ticketPrice;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String transportationCompany;
    private double discountPrice;
}