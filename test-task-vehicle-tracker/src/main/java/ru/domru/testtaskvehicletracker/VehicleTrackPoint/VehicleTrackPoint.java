package ru.domru.testtaskvehicletracker.VehicleTrackPoint;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * JPA Entity for storing GPS points of vehicle track
 * 
 * @soundtrack Basil O'Glue & Gordey Tsukanov - The Day Before (Original Mix) 
 * */
@Entity
@Table(name="VEHICLE_TRACK_POINT")
public class VehicleTrackPoint {
	
	@Id
	@Column(name="ID_VEHICLE_TRACK_POINT")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idVehicleTrackPoint;
	
	@Column(name="CREATION_TIME")
	private Timestamp creationTime;
	
	@Column(name="CREATION_DATE")
	private Date creationDate;
	
	@Column(name="ID_VEHICLE")
	private int idVehicle;
	
	@Column(name="LATITUDES",precision=10,scale=8)
	private BigDecimal latitudes;
	
	@Column(name="LONGITUDES",precision=11,scale=8)
	private BigDecimal longitudes;
	
	

	public VehicleTrackPoint(Long idVehicleTrackPoint, Timestamp creationTime, Date creationDate, int idVehicle,
			BigDecimal latitudes, BigDecimal longitudes) {
		this.idVehicleTrackPoint = idVehicleTrackPoint;
		this.creationTime = creationTime;
		this.creationDate = creationDate;
		this.idVehicle = idVehicle;
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

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public int getIdVehicle() {
		return idVehicle;
	}

	public void setIdVehicle(int idVehicle) {
		this.idVehicle = idVehicle;
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
