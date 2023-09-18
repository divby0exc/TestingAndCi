package com.divby0exc.testingandci.repository;

import com.divby0exc.testingandci.model.TransportationRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransportationRouteRepository extends JpaRepository<TransportationRoute, Long> {
}
