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
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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

    @Column(name = "RENTAL_START")
    @NotNull
    private Timestamp rentalStart;

    @ManyToOne
    @JoinColumn(name="POINT_FROM")
    @NotNull
    private RentalPoint pointFrom;

    
    @Column(name = "RENTAL_END")
    private Timestamp rentalEnd;
    
    @ManyToOne
    @JoinColumn(name="POINT_TO")
    private RentalPoint pointTo;

    @ManyToOne
    @JoinColumn(name="ID_VEHICLE")
    @NotNull
    private Vehicle vehicle;
    
    @ManyToOne
    @JoinColumn(name = "ID_CUSTOMER")
    @NotNull
    private Customer customer;

    public Rental() {
    }


    /**
     * Insted of writing true bean validation
     * 
     * @return boolean Result of reception vehicle validation
     * */
    @AssertTrue(message="invalid rental end date or reception point")
    private boolean isReceptionVehicleValid() {
    	if(this.getRentalEnd()==null && this.getPointTo()==null) return true;
    	
    	if(this.getRentalEnd()!=null && this.getPointTo()!=null) {
    		return this.getRentalEnd().getTime()> this.getRentalStart().getTime();
    	}	
    	
    	return false;	
    }


    public Rental(int idRental, String notes, Timestamp rentalStart, RentalPoint pointFrom, Timestamp rentalEnd,
			RentalPoint pointTo, Vehicle vehicle, Customer customer) {
		
    	this.idRental = idRental;
		this.notes = notes;
		this.rentalStart = rentalStart;
		this.pointFrom = pointFrom;
		this.rentalEnd = rentalEnd;
		this.pointTo = pointTo;
		this.vehicle = vehicle;
		this.customer = customer;
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

	public RentalPoint getPointFrom() {
		return pointFrom;
	}

	public void setPointFrom(RentalPoint pointFrom) {
		this.pointFrom = pointFrom;
	}

	public RentalPoint getPointTo() {
		return pointTo;
	}

	public void setPointTo(RentalPoint pointTo) {
		this.pointTo = pointTo;
	}
    
    
}
