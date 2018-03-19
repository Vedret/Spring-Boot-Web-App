package licence.spin.ba.Licence.Validator;

import org.springframework.validation.Errors;

public interface Validator {

	boolean supports(Class<?> aClass);

	void validate(Object o, Errors errors);

}
