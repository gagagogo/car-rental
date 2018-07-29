package ru.domru.testtaskvehicletracker.VehicleTrackPoint;

import java.math.BigDecimal;
import java.security.Timestamp;

import javax.persistence.Entity;

/**
 * JPA Entity for storing GPS points of vehicle track
 * 
 * @soundtrack Basil O'Glue & Gordey Tsukanov - The Day Before (Original Mix) 
 * */
@Entity
public class VehicleTrackPoint {
	
	private Long idVehicleTrackPoint;
	
	private Timestamp creationTime;
	
	private Timestamp creationDate;
	
	private BigDecimal latitudes;
	
	private BigDecimal longitudes;
	
}
