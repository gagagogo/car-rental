package ru.domru.carrental.domain.customer;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

public interface CustomerRepository extends DataTablesRepository<Customer, Integer> {

}
