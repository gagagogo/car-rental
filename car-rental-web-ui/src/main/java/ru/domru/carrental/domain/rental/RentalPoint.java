package ru.domru.carrental.domain.rental;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ru.domru.carrental.domain.vehicle.Vehicle;

@Entity
@NamedQueries({ @NamedQuery(name = "RentalPoint.findAll", query = "select o from RentalPoint o") })
@Table(name = "`RENTAL_POINT`")
public class RentalPoint implements Serializable {
    
    @Id
    @Column(name = "ID_RENTAL_POINT", nullable = false)
    private int idRentalPoint;
    
    @Column(name = "ADDRESS", nullable = false)
    private String address;
    
    @JsonIgnore
    @OneToMany(mappedBy = "rentalPoint", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Vehicle> vehicleList;

    public RentalPoint() {
    }

    public RentalPoint(String address, int idRentalPoint) {
        this.address = address;
        this.idRentalPoint = idRentalPoint;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIdRentalPoint() {
        return idRentalPoint;
    }

    public void setIdRentalPoint(int idRentalPoint) {
        this.idRentalPoint = idRentalPoint;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public Vehicle addVehicle(Vehicle vehicle) {
        getVehicleList().add(vehicle);
        vehicle.setRentalPoint(this);
        return vehicle;
    }

    public Vehicle removeVehicle(Vehicle vehicle) {
        getVehicleList().remove(vehicle);
        vehicle.setRentalPoint(null);
        return vehicle;
    }
}
