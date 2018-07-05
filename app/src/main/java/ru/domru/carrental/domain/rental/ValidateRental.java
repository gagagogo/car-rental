package ru.domru.carrental.domain.rental;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Validation annotation for {@code Rental}
 * */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=ValidateRentalImpl.class)
public @interface ValidateRental {
	String message() default "Invalid end datetime or rental point is not set";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
