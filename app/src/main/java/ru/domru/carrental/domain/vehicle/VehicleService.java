package ru.domru.carrental.domain.vehicle;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {
	
	@Autowired
	VehicleModelRepository vehicleModelRepository;

	@Autowired
	VehicleTypeRepository vehicleTypeRepository;

	public DataTablesOutput<VehicleModel> getVehicleModelList(DataTablesInput input) {
		return vehicleModelRepository.findAll(input);
	}

	public VehicleModel saveVehicleModel(@Valid VehicleModel vehicleModel) {
		return vehicleModelRepository.save(vehicleModel);
	}

	public Optional<VehicleModel> getVehicleModel(int idVehicleModel) {
		return vehicleModelRepository.findById(idVehicleModel);
	}

	public DataTablesOutput<VehicleType> getVehicleTypeList(DataTablesInput input) {
		return vehicleTypeRepository.findAll(input);
	}

	public VehicleType saveVehicleModel(@Valid VehicleType vehicleType) {
		return vehicleTypeRepository.save(vehicleType);
	}

	public Optional<VehicleType> getVehicleType(int idVehicleType) {
		return vehicleTypeRepository.findById(idVehicleType);
	}
	
}
