package lessons;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PersonValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Person.class.equals(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
		
		Person person = (Person) target;
		if (person.getAge() < 0) {
			errors.rejectValue("age", "negative value");
		} else if (person.getAge() > 120) {
			errors.rejectValue("age", "too.darn.old");
		}
		
	}

}
