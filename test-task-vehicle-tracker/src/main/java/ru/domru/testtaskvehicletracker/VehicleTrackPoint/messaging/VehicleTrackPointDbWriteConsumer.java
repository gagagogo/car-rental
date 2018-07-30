package ru.domru.testtaskvehicletracker.VehicleTrackPoint.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.SubscribableChannel;

import ru.domru.testtaskvehicletracker.VehicleTrackPoint.VehicleTrackPoint;
import ru.domru.testtaskvehicletracker.VehicleTrackPoint.VehicleTrackPointRepository;

@EnableBinding(VehicleTrackPointDbWriteConsumer.Sink.class)
public class VehicleTrackPointDbWriteConsumer {
	
	@Autowired
	VehicleTrackPointRepository pointRepository;
	
	@StreamListener(VehicleTrackPointDbWriteConsumer.Sink.INPUT)
	void writeToDb(VehicleTrackPoint point) {
		pointRepository.save(point);
	}

	
	public interface Sink{
		String INPUT = "vehicle-track-db-write";
		
		@Input(INPUT)
		SubscribableChannel input();
	}

}
