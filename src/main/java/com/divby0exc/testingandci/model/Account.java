package com.divby0exc.testingandci.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.EOFException;

import static jakarta.persistence.GenerationType.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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