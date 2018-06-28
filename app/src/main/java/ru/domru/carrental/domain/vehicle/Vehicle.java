package ru.domru.carrental.domain.vehicle;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonView;

import ru.domru.carrental.domain.rental.Rental;
import ru.domru.carrental.domain.rental.RentalPoint;

@Entity
@NamedQueries({ @NamedQuery(name = "Vehicle.findAll", query = "select o from Vehicle o") })
@Table(name="`VEHICLE`")
public class Vehicle implements Serializable {

	@Id
    @Column(name = "ID_VEHICLE", nullable = false)
    private int idVehicle;
    

 	@Column(name = "REG_NUM", nullable = false)
    private String regNum;
    
    @OneToOne(optional=true)
    @JoinColumn(name = "LAST_RENTAL")
    private Rental lastRental;
    
    
    @ManyToOne
    @JoinColumn(name = "ID_VEHICLE_TYPE")
    private VehicleType vehicleType;
    

    @ManyToOne
    @JoinColumn(name = "ID_VEHICLE_MODEL")
    private VehicleModel vehicleModel;
    

    @ManyToOne
    @JoinColumn(name="RENTAL_POINT")
    private RentalPoint rentalPoint;

    public Vehicle() {
    }

    public Vehicle(int idVehicle, VehicleModel vehicleModel, VehicleType vehicleType, Rental rental, String regNum,
                   RentalPoint rentalPoint) {
        this.idVehicle = idVehicle;
        this.vehicleModel = vehicleModel;
        this.vehicleType = vehicleType;
        this.lastRental = rental;
        this.regNum = regNum;
        this.rentalPoint = rentalPoint;
    }

    public int getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(int idVehicle) {
        this.idVehicle = idVehicle;
    }


    public String getRegNum() {
        return regNum;
    }

    public void setRegNum(String regNum) {
        this.regNum = regNum;
    }


    public Rental getLastRental() {
        return lastRental;
    }

    public void setLastRental(Rental rental) {
        this.lastRental = rental;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setRentalPoint(RentalPoint rentalPoint) {
        this.rentalPoint = rentalPoint;
    }
    
    public RentalPoint getRentalPoint() {
		return rentalPoint;
	}

	public VehicleModel getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(VehicleModel vehicleModel) {
        this.vehicleModel = vehicleModel;
    }
}
