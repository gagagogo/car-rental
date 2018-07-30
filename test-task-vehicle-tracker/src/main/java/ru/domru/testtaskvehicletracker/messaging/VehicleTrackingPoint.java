package ru.domru.testtaskvehicletracker.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

public class VehicleTrackingPoint {
	
	public interface Sink{
		String OUTPUT = "vehicle-tracking-output"; 
		
		@Output(VehicleTrackingPoint.Sink.OUTPUT)
		SubscribableChannel output();
	}
}
