package com.divby0exc.testingandci.model;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ActiveBookings {
    private String username;
    @Id
    private long routeId;

}
