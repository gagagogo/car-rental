package ru.domru.carrental.domain.rental;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Implementation {@code Rental} validation annotation
 * */
public class ValidateRentalImpl implements ConstraintValidator<ValidateRental, Rental>{

	@Override
	public boolean isValid(Rental value, ConstraintValidatorContext context) {
    	if(value.getRentalEnd()==null && value.getPointTo()==null) return true;
    	
    	if(value.getRentalEnd()!=null && value.getPointTo()!=null) {
    		return value.getRentalEnd().getTime()> value.getRentalStart().getTime();
    	}
    	    	
    	return false;	
	}

}