package com.vsvet.example.videorentalstore.validator;

import com.vsvet.example.videorentalstore.validator.impl.PositiveValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PositiveValidator.class)
@Documented
public @interface Positive {

    String message() default "Field ''{0}'' must be greater than 0";

    String fieldName() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
