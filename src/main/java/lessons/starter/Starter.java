package lessons.starter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import lessons.LessonsConfiguration;
import lessons.Person;
import lessons.services.GreetingService;

public class Starter {
	
	private static final Logger LOGGER = LogManager.getLogger(Starter.class);

	public static void main(String[] args) {
		LOGGER.info("Starting configuration...");

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(LessonsConfiguration.class);
        GreetingService greetingService = context.getBean(GreetingService.class);
        LOGGER.info(greetingService.sayGreeting());
//        context.registerShutdownHook();
        Person person = context.getBean(Person.class);
        
        BeanWrapper beanWrapper = new BeanWrapperImpl(person);
        PropertyValue property = new PropertyValue("age", 25);
        
        beanWrapper.setPropertyValue("name", "Jora");
        beanWrapper.setPropertyValue(property);
        
        LOGGER.info("Person from Person - name: " + beanWrapper.getPropertyValue("name") + ", age: " + beanWrapper.getPropertyValue("age"));
        LOGGER.info("Person from Person - name: " + person.getName() + ", age: " + person.getAge());
        
        ValidationBindingConversionStarter validator = new ValidationBindingConversionStarter();
        validator.personValidate();
	}

}
