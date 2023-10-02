package com.divby0exc.testingandci.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class AuthDetails {
    private String username;
    @Id
    private String id;
}
