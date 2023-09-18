package com.divby0exc.testingandci.repository;

import com.divby0exc.testingandci.model.TransportationRoute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITransportationRouteRepository extends JpaRepository<TransportationRoute, Long> {
}
