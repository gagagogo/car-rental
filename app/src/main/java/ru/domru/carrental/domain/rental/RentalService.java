package ru.domru.carrental.domain.rental;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Service;

@Service
public class RentalService {
	
	@Autowired
	RentalPointRepository rentalPointRepository;

	
	public DataTablesOutput<RentalPoint> getRentalPointList(DataTablesInput input) {
		return rentalPointRepository.findAll(input);
	}

	public RentalPoint saveRentalPoint(@Valid RentalPoint rentalPoint) {
		return rentalPointRepository.save(rentalPoint);
	}

	public Optional<RentalPoint> getRentalPoint(int idRentalPoint) {
		return rentalPointRepository.findById(idRentalPoint);
	}
		
}
