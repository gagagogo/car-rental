package ru.domru.carrental.domain.rental;

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

import com.fasterxml.jackson.annotation.JsonView;


@RestController
@RequestMapping("/rental")
public class RentalController {
	
	@Autowired
	RentalService rentalService;


	//RENTAL POINT
	@RequestMapping(value="/point/list")	
	public DataTablesOutput<RentalPoint> getRentalPointList(@Valid DataTablesInput input) {
		return rentalService.getRentalPointList(input);
	}
	@RequestMapping(value="/point/save")
	public RentalPoint rentalPointSave(@RequestBody @Valid RentalPoint rentalPoint) {
		return rentalService.saveRentalPoint(rentalPoint);
	}
	
	@RequestMapping(value="/point/{idRentalPoint}", method=RequestMethod.GET)
	public RentalPoint getRentalPoint(@PathVariable int idRentalPoint) {
		Optional<RentalPoint> point = rentalService.getRentalPoint(idRentalPoint);
		if(!point.isPresent()) throw new EntityNotFoundException("Ivalid id");
		return point.get();		
	}

	//RENTAL
	@RequestMapping(value="/list")	
	public DataTablesOutput<Rental> getRentalList(@Valid DataTablesInput input) {
		return rentalService.getRentalList(input);
	}
	@RequestMapping(value="/save")
	public Rental rentalSave(@RequestBody @Valid Rental rental) {
		return rentalService.saveRental(rental);
	}
	
	@RequestMapping(value="/{idRental}", method=RequestMethod.GET)
	public Rental getRental(@PathVariable int idRental) {
		Optional<Rental> rental = rentalService.getRental(idRental);
		if(!rental.isPresent()) throw new EntityNotFoundException("Ivalid id");
		return rental.get();		
	}	
	
}