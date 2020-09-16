package dsb.web.service.validators;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FieldsValueMatchValidator implements ConstraintValidator<FieldsValueMatch, Object> {

    private String field;
    private String fieldMatch;

    public void initialize(FieldsValueMatch constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.fieldMatch = constraintAnnotation.fieldMatch();
    }

    public boolean isValid(Object value, ConstraintValidatorContext context) {

        //setup and already covered by @NotBlank
        Object fieldValue = new BeanWrapperImpl(value).getPropertyValue(field);
        if (fieldValue == null || fieldValue.equals("")) return true;

        Object fieldMatchValue = new BeanWrapperImpl(value).getPropertyValue(fieldMatch);
        if (fieldMatchValue == null || fieldMatchValue.equals("")) return true;

        //actual test
        return fieldValue.equals(fieldMatchValue);
    }
}