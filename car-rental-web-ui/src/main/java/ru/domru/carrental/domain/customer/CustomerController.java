package ru.domru.carrental.domain.customer;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;


	//RENTAL POINT
	@RequestMapping(value="/list")	
	public DataTablesOutput<Customer> getRentalPointList(@Valid DataTablesInput input) {
		return customerService.getCustomerList(input);
	}
	@RequestMapping(value="/save")
	public Customer rentalCustomer(@RequestBody @Valid Customer customer) {
		return customerService.saveCustomer(customer);
	}
	
	@RequestMapping(value="/{idCustomer}", method=RequestMethod.GET)
	public Customer getCustomer(@PathVariable int idCustomer) {
		Optional<Customer> customer = customerService.getCustomer(idCustomer);
		if(!customer.isPresent()) throw new EntityNotFoundException("Ivalid id");
		return customer.get();		
	}

}