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

@Entity
@NamedQueries({ @NamedQuery(name = "VehicleModel.findAll", query = "select o from VehicleModel o") })
@Table(name = "VEHICLE_MODEL")
public class VehicleModel implements Serializable {
    private String descr;
    @Id
    @Column(name = "ID_VEHICLE_MODEL", nullable = false)
    private int idVehicleModel;
    
    @OneToMany(mappedBy = "vehicleModel", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Vehicle> vehicleList;

    public VehicleModel() {
    }

    public VehicleModel(String descr, int idVehicleModel) {
        this.descr = descr;
        this.idVehicleModel = idVehicleModel;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public int getIdVehicleModel() {
        return idVehicleModel;
    }

    public void setIdVehicleModel(int idVehicleModel) {
        this.idVehicleModel = idVehicleModel;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public Vehicle addVehicle(Vehicle vehicle) {
        getVehicleList().add(vehicle);
        vehicle.setVehicleModel(this);
        return vehicle;
    }

    public Vehicle removeVehicle(Vehicle vehicle) {
        getVehicleList().remove(vehicle);
        vehicle.setVehicleModel(null);
        return vehicle;
    }
}
