package lessons.starter;

import java.util.Locale;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.DataBinder;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.ObjectError;

import lessons.Person;
import lessons.PersonValidator;

public class ValidationBindingConversionStarter {
	
	private static final Logger LOGGER = LogManager.getLogger(Starter.class);
	
	public void personValidate() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("ValidationMessages");
		
		Person person = new Person();
		
		person.setAge(150);
		
		PersonValidator validator = new PersonValidator();
		DataBinder binder = new DataBinder(person);
		binder.setValidator(validator);
		binder.validate();
		
		LOGGER.info("Count errors: " + binder.getBindingResult().getErrorCount());
		
		ObjectError error = binder.getBindingResult().getAllErrors().get(0);
		
		LOGGER.info("Error \"" + error.getCode());// + "\": " + messageSource.getMessage(error.getCode(), null, Locale.ROOT));
		
		error = binder.getBindingResult().getAllErrors().get(1);
		
		MessageCodesResolver resolver = new DefaultMessageCodesResolver();
		
		String[] codes = resolver.resolveMessageCodes(error.getCode(), "age"); //указываем, по какому полю объекта мы хотим получить коды ошибок
        LOGGER.info("Error \"" +codes[0]);// + "\": " + messageSource.getMessage(codes[0], null, Locale.ROOT));
	} 
}
