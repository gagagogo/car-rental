package ru.domru.carrental.domain.rental;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

public interface RentalRepository extends DataTablesRepository<Rental, Integer> {

}
