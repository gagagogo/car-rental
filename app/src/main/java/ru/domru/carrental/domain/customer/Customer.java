package ru.domru.carrental.domain.customer;

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
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ru.domru.carrental.domain.rental.Rental;

@Entity
@NamedQueries({ @NamedQuery(name = "Customer.findAll", query = "select o from Customer o") })
@Table(name="`CUSTOMER`")
public class Customer implements Serializable {
    
    @Id
    @Column(name = "ID_CUSTOMER", nullable = false)
    private int idCustomer;
    
    @Column(name="DESCR",nullable=false)
    @NotEmpty
    private String descr;
    
    @JsonIgnore
    @OneToMany(mappedBy = "customer", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Rental> rentalList;

    public Customer() {
    }

    public Customer(String descr, int idCustomer) {
        this.descr = descr;
        this.idCustomer = idCustomer;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public List<Rental> getRentalList() {
        return rentalList;
    }

    public void setRentalList(List<Rental> rentalList) {
        this.rentalList = rentalList;
    }

    public Rental addRental(Rental rental) {
        getRentalList().add(rental);
        rental.setCustomer(this);
        return rental;
    }

    public Rental removeRental(Rental rental) {
        getRentalList().remove(rental);
        rental.setCustomer(null);
        return rental;
    }
}
