package com.petcare.server.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.util.Set;

public class ValidationWrapper {

    private Validator validator;
    private final static Logger LOGGER = LoggerFactory.getLogger(ValidationWrapper.class);

    @Inject
    public ValidationWrapper(Validator validator) {
        this.validator = validator;
    }

    public boolean validate(Object input) {
        return validate(input, Default.class);
    }

    public boolean validate(Object input, Class<?> ... groups) {
        Set<ConstraintViolation<Object>> violations = validator.validate(input, groups);
        return violations == null || violations.isEmpty();
    }

    public boolean validateString(String string) {
        return !(string == null || string.isEmpty());
    }

    public boolean validateNumber(String number) {
        return validateString(number) ? number.matches("[0-9]+") : false;
    }
}
