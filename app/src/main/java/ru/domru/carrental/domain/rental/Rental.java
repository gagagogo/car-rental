package ru.domru.carrental.domain.rental;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import ru.domru.carrental.domain.customer.Customer;
import ru.domru.carrental.domain.vehicle.Vehicle;

@Entity
@NamedQueries({ @NamedQuery(name = "Rental.findAll", query = "select o from Rental o") })
@Table(name="`RENTAL`")
public class Rental implements Serializable {
    @Id
    @Column(name = "ID_RENTAL", nullable = false)
    private int idRental;
    
    private String notes;
    @Column(name = "RENTAL_END")
    
    private Timestamp rentalEnd;
    
    @Column(name = "RENTAL_START")
    private Timestamp rentalStart;
    
    @ManyToOne
    @JoinColumn(name="ID_VEHICLE")
    private Vehicle vehicle;
    @ManyToOne
    @JoinColumn(name = "ID_CUSTOMER")
    private Customer customer;

    public Rental() {
    }

    public Rental(Customer customer, int idRental, Vehicle vehicle, String notes, Timestamp rentalEnd,
                  Timestamp rentalStart) {
        this.customer = customer;
        this.idRental = idRental;
        this.vehicle = vehicle;
        this.notes = notes;
        this.rentalEnd = rentalEnd;
        this.rentalStart = rentalStart;
    }


    public int getIdRental() {
        return idRental;
    }

    public void setIdRental(int idRental) {
        this.idRental = idRental;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Timestamp getRentalEnd() {
        return rentalEnd;
    }

    public void setRentalEnd(Timestamp rentalEnd) {
        this.rentalEnd = rentalEnd;
    }

    public Timestamp getRentalStart() {
        return rentalStart;
    }

    public void setRentalStart(Timestamp rentalStart) {
        this.rentalStart = rentalStart;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
