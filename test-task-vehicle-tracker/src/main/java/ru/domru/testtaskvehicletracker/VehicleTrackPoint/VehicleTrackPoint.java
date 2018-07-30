package ru.domru.testtaskvehicletracker.VehicleTrackPoint;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * JPA Entity for storing GPS points of vehicle track
 * 
 * @soundtrack Basil O'Glue & Gordey Tsukanov - The Day Before (Original Mix) 
 * */
@Entity
public class VehicleTrackPoint {
	
	@Id
	@Column
	private Long idVehicleTrackPoint;
	
	@Column
	private Timestamp creationTime;
	
	@Column	
	private Timestamp creationDate;
	
	@Column
	private BigDecimal latitudes;
	
	@Column
	private BigDecimal longitudes;

	public VehicleTrackPoint(Long idVehicleTrackPoint, Timestamp creationTime, Timestamp creationDate,
			BigDecimal latitudes, BigDecimal longitudes) {
		this.idVehicleTrackPoint = idVehicleTrackPoint;
		this.creationTime = creationTime;
		this.creationDate = creationDate;
		this.latitudes = latitudes;
		this.longitudes = longitudes;
	}

	public VehicleTrackPoint() {
	}

	public Long getIdVehicleTrackPoint() {
		return idVehicleTrackPoint;
	}

	public void setIdVehicleTrackPoint(Long idVehicleTrackPoint) {
		this.idVehicleTrackPoint = idVehicleTrackPoint;
	}

	public Timestamp getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public BigDecimal getLatitudes() {
		return latitudes;
	}

	public void setLatitudes(BigDecimal latitudes) {
		this.latitudes = latitudes;
	}

	public BigDecimal getLongitudes() {
		return longitudes;
	}

	public void setLongitudes(BigDecimal longitudes) {
		this.longitudes = longitudes;
	}
	
	

	
	
	
}
