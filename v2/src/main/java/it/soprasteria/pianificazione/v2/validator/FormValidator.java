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
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "badgeNumber", "NotEmpty.matricola");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "idProject", "NotEmpty.idProgetto");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customer", "cliente");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "activityType", "NotEmpty.attivita");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "currency", "NotEmpty.valuta");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "NotEmpty.tariffa");

	}

}
