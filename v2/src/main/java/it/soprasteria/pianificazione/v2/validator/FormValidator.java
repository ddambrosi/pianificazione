package it.soprasteria.pianificazione.v2.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.soprasteria.pianificazione.v2.bean.RecordV2Bean;

@Component
public class FormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return RecordV2Bean.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeDesc", "NotEmpty.risorsa");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "projectDesc", "NotEmpty.progetto");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "NotEmpty.tariffa");
		
		RecordV2Bean recordV2Bean = (RecordV2Bean)target;
		
		if(recordV2Bean.getCons0() != null){
			if (recordV2Bean.getCons0() < 0) {
				errors.rejectValue("cons0", "Zero.cons0");
			}
		}
		
		if(recordV2Bean.getCons1() != null){
			if (recordV2Bean.getCons1() < 0) {
				errors.rejectValue("cons0", "Zero.cons0");
			}
		}
		
		if(recordV2Bean.getCons2() != null){
			if (recordV2Bean.getCons2() < 0) {
				errors.rejectValue("cons0", "Zero.cons0");
			}
		}
	}
}
