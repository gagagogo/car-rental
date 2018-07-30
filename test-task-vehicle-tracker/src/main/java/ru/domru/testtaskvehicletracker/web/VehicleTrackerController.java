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

import reactor.core.publisher.Mono;
import ru.domru.testtaskvehicletracker.VehicleTrackPoint.VehicleTrackPoint;
import ru.domru.testtaskvehicletracker.VehicleTrackPoint.messaging.VehicleTrackPointProducer;

/**
 * This controller send tracking point from GPS devices inside car
 * to message broker. At now there is only one consumer which write points
 * to DB.
 * */
@RestController
@RequestMapping("/api")
@EnableBinding(VehicleTrackPointProducer.Source.class)
public class VehicleTrackerController {
	
	@Autowired
	VehicleTrackPointProducer.Source vehicleTrackPointProducer;
	
	@RequestMapping("/point/write")
	Mono<ResponseEntity<Boolean>> writePoint(@RequestBody VehicleTrackPoint vehicleTrackPoint){
		boolean res = vehicleTrackPointProducer.output().send(MessageBuilder.withPayload(vehicleTrackPoint).build());
		if(res) return Mono.just(ResponseEntity.ok(true));
		return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}
}
