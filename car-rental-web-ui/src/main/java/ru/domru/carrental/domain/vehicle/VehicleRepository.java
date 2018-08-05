package ru.domru.carrental.domain.vehicle;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

public interface VehicleRepository extends DataTablesRepository<Vehicle, Integer> {

}
