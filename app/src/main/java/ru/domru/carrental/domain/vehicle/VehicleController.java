package ru.domru.carrental.domain.vehicle;

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
@RequestMapping("/vehicle")
public class VehicleController {
	
	@Autowired
	VehicleService vehicleService;


	// MODELS
	@RequestMapping(value="/model/list")	
	public DataTablesOutput<VehicleModel> getVehicleModelList(@Valid DataTablesInput input) {
		return vehicleService.getVehicleModelList(input);
	}
	@RequestMapping(value="/model/save")
	public VehicleModel vehicleModelSave(@RequestBody @Valid VehicleModel vehicleModel) {
		return vehicleService.saveVehicleModel(vehicleModel);
	}
	
	@RequestMapping(value="/model/{idVehicleModel}", method=RequestMethod.GET)
	public VehicleModel getVehicleModel(@PathVariable int idVehicleModel) {
		Optional<VehicleModel> model = vehicleService.getVehicleModel(idVehicleModel);
		if(!model.isPresent()) throw new EntityNotFoundException("Ivalid id");
		return model.get();		
	}


	
	//TYPES

	@RequestMapping(value="/type/list")	
	public DataTablesOutput<VehicleType> getVehicleTypeList(@Valid DataTablesInput input) {
		return vehicleService.getVehicleTypeList(input);
	}
	

	@RequestMapping(value="/type/save")
	public VehicleType vehicleTypeSave(@RequestBody @Valid VehicleType vehicleType) {
		return vehicleService.saveVehicleType(vehicleType);
	}
	

	@RequestMapping(value="/type/{idVehicleType}", method=RequestMethod.GET)
	public VehicleType getVehicleType(@PathVariable int idVehicleType) {
		Optional<VehicleType> type = vehicleService.getVehicleType(idVehicleType);
		if(!type.isPresent()) throw new EntityNotFoundException("Ivalid id");
		return type.get();		
	}
	
	
	//VEHICLE
	@RequestMapping(value="/list")	
	public DataTablesOutput<Vehicle> getVehicleList(@Valid DataTablesInput input) {
		return vehicleService.getVehicleList(input);
	}
	
	@RequestMapping(value="/save")
	public Vehicle vehicleSave(@RequestBody @Valid Vehicle vehicle) {
		return vehicleService.saveVehicle(vehicle);
	}
	
	@RequestMapping(value="/{idVehicle}", method=RequestMethod.GET)
	public Vehicle getVehicle(@PathVariable int idVehicle) {
		Optional<Vehicle> vehicle = vehicleService.getVehicle(idVehicle);
		if(!vehicle.isPresent()) throw new EntityNotFoundException("Ivalid id");
		return vehicle.get();		
	}

}