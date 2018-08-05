package ru.domru.carrental.domain.vehicle;

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

import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@NamedQueries({ @NamedQuery(name = "VehicleType.findAll", query = "select o from VehicleType o") })
@Table(name = "`VEHICLE_TYPE`")
public class VehicleType implements Serializable {
	@Id
    @Column(name = "ID_VEHICLE_TYPE", nullable = false)
    private int idVehicleType;
    
	@Column(nullable = false)
    private String descr;

	@JsonIgnore
    @OneToMany(mappedBy = "vehicleType", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Vehicle> vehicleList;

    public VehicleType() {
    }

    public VehicleType(String descr, int idVehicleType) {
        this.descr = descr;
        this.idVehicleType = idVehicleType;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public int getIdVehicleType() {
        return idVehicleType;
    }

    public void setIdVehicleType(int idVehicleType) {
        this.idVehicleType = idVehicleType;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList1(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public Vehicle addVehicle(Vehicle vehicle) {
        getVehicleList().add(vehicle);
        vehicle.setVehicleType(this);
        return vehicle;
    }

    public Vehicle removeVehicle(Vehicle vehicle) {
        getVehicleList().remove(vehicle);
        vehicle.setVehicleType(null);
        return vehicle;
    }
}
