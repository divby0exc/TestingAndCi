package com.divby0exc.testingandci.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static jakarta.persistence.GenerationType.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActiveBookings {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long bookingId;
    private Long accountId;
    private Long routeId;

}