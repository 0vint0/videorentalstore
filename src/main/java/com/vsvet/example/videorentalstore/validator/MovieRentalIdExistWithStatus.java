package com.vsvet.example.videorentalstore.validator;

import com.vsvet.example.videorentalstore.domain.MovieRentalStatus;
import com.vsvet.example.videorentalstore.validator.impl.MovieRentalIdExistWithStatusValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MovieRentalIdExistWithStatusValidator.class)
@Documented
public @interface MovieRentalIdExistWithStatus {

    String message() default "Movie rental with ''{0}'' id does not exist, or has not expected status ''{1}'' !";

    MovieRentalStatus status() default MovieRentalStatus.RENTED;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
