package ru.domru.testtaskvehicletracker.VehicleTrackPoint.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public class VehicleTrackPointProducer{
	
	public interface Source{
		String OUTPUT = "vehicle-track-point-output";
		
		@Output(OUTPUT)
		MessageChannel output();  
	}
}
