package com.vsvet.example.videorentalstore.validator;

import com.vsvet.example.videorentalstore.validator.impl.MovieIdsExistOnEntityValidator;
import com.vsvet.example.videorentalstore.validator.impl.MovieIdsExistValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {MovieIdsExistValidator.class,MovieIdsExistOnEntityValidator.class})
@Documented
public @interface MovieIdsExist {

    String message() default "Movie with ''{0}'' ids do not exist!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
