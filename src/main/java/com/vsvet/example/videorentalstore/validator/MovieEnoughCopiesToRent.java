package com.vsvet.example.videorentalstore.validator;

import com.vsvet.example.videorentalstore.validator.impl.MovieEnoughCopiesToRentValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MovieEnoughCopiesToRentValidator.class)
@Documented
public @interface MovieEnoughCopiesToRent {

    String message() default "Not enough copies, please come back another day";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
