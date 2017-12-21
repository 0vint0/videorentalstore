package com.vsvet.example.videorentalstore.validator;

import com.vsvet.example.videorentalstore.validator.impl.ClientIdExistValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ClientIdExistValidator.class)
@Documented
public @interface ClientIdExist {

    String message() default "Client with ''{0}'' id does not exist!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
