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

	@JsonView(DataTablesOutput.View.class)
	@RequestMapping(value="/model/list")	
	public DataTablesOutput<VehicleModel> getVehicleModelList(@Valid DataTablesInput input) {
		return vehicleService.getVehicleModelList(input);
	}
	
	@JsonView(DataTablesOutput.View.class)
	@RequestMapping(value="/model/save")
	public VehicleModel vehicleModelSave(@RequestBody @Valid VehicleModel vehicleModel) {
		return vehicleService.saveVehicleModel(vehicleModel);
	}
	
	@JsonView(DataTablesOutput.View.class)
	@RequestMapping(value="/model/{idVehicleModel}", method=RequestMethod.GET)
	public VehicleModel getVehicleModel(@PathVariable int idVehicleModel) {
		Optional<VehicleModel> model = vehicleService.getVehicleModel(idVehicleModel);
		if(!model.isPresent()) throw new EntityNotFoundException("Ivalid user id");
		return model.get();		
	}


	
	
	@JsonView(DataTablesOutput.View.class)
	@RequestMapping(value="/type/list")	
	public DataTablesOutput<VehicleType> getVehicleTypeList(@Valid DataTablesInput input) {
		return vehicleService.getVehicleTypeList(input);
	}
	
	@JsonView(DataTablesOutput.View.class)
	@RequestMapping(value="/type/save")
	public VehicleType vehicleTypeSave(@RequestBody @Valid VehicleType vehicleType) {
		return vehicleService.saveVehicleModel(vehicleType);
	}
	
	@JsonView(DataTablesOutput.View.class)
	@RequestMapping(value="/type/{idVehicleType}", method=RequestMethod.GET)
	public VehicleType getVehicleType(@PathVariable int idVehicleType) {
		Optional<VehicleType> type = vehicleService.getVehicleType(idVehicleType);
		if(!type.isPresent()) throw new EntityNotFoundException("Ivalid user id");
		return type.get();		
	}

}