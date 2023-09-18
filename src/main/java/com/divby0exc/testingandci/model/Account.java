package com.divby0exc.testingandci.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Account {
    private String username;
    private String[] contactInfo;
    private Integer[] paymentInfo;
    private List<PaymentsHistory> paymentHistory;
//    Tickets you bought but haven't used yet
    private String accountType;
    private List<ActiveBookings> activeBookings;

}