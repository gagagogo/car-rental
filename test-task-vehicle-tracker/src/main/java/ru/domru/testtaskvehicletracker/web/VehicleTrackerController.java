package ru.domru.testtaskvehicletracker.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import ru.domru.testtaskvehicletracker.VehicleTrackPoint.VehicleTrackPoint;
import ru.domru.testtaskvehicletracker.messaging.VehicleTrackingPoint;

@RestController
@RequestMapping("api/vehicle-tracker")
@EnableBinding(VehicleTrackingPoint.Sink.class)
public class VehicleTrackerController {
	
	@Autowired
	VehicleTrackingPoint.Sink vehicleTrackingMessageInput;
	
	@RequestMapping("point/write")
	Mono<ResponseEntity<String>> writePoint(@RequestBody VehicleTrackPoint vehicleTrackPoint){
		//boolean res = vehicleTrackingMessageInput.output().send(MessageBuilder.withPayload(vehicleTrackPoint).build());
		//if(res) 
			return Mono.just(ResponseEntity.ok("Successfuly saved"));
		//return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}

}
