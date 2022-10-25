package minhhuy.thuchanh2.model;

import minhhuy.thuchanh2.controller.PhoneController;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;
import java.lang.annotation.Annotation;

@Component
public class PhoneNumber implements Validator {

    @NotEmpty(message = "no.huy")
    private String number;

    public PhoneNumber() {
    }

    public PhoneNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setName(String number) {
        this.number = number;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return PhoneNumber.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PhoneNumber phoneNumber=(PhoneNumber) target;
        String number=phoneNumber.getNumber();
        ValidationUtils.rejectIfEmpty(errors,"number","number.no");
        if(number.length()>11|| number.length()<10){
            errors.rejectValue("number","number.length");
        }
        if(number.startsWith("0")){
            errors.rejectValue("number","number.error");
        }
        if(!number.matches("(^$|[0-9]*$)")){
            errors.rejectValue("number","number.matches");
        }
    }
}
