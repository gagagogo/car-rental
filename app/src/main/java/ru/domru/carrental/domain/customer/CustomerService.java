package ru.domru.carrental.domain.customer;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;

	
	public DataTablesOutput<Customer> getCustomerList(DataTablesInput input) {
		return customerRepository.findAll(input);
	}

	public Customer saveCustomer(@Valid Customer customer) {
		return customerRepository.save(customer);
	}

	public Optional<Customer> getCustomer(int idCustomer) {
		return customerRepository.findById(idCustomer);
	}
		
}
