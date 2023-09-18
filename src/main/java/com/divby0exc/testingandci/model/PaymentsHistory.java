package com.divby0exc.testingandci.model;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentsHistory {
    private String username;
    @Id
    private long routeId;
}
