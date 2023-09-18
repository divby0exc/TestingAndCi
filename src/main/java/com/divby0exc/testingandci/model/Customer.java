package com.divby0exc.testingandci.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Customer {
    private String username;
    private String[] contactInfo;
    private Integer[] paymentInfo;
    private List<Payments> paymentHistory;
//    Tickets you bought but haven't used yet
    private List<ActiveBookings> activeBookings;
    private String accountType;

}