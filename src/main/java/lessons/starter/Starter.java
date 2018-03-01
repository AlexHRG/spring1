package lessons.starter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import lessons.LessonsConfiguration;
import lessons.services.GreetingService;

public class Starter {
	
	private static final Logger LOGGER = LogManager.getLogger(Starter.class);

	public static void main(String[] args) {
		LOGGER.info("Starting configuration...");

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(LessonsConfiguration.class);
        GreetingService greetingService = context.getBean(GreetingService.class);
        LOGGER.info(greetingService.sayGreeting());
        context.registerShutdownHook();
        
        
//        ResourceStarter starter = new ResourceStarter();
//		starter.printClassResourcesByContextWithPrefix();
//		starter.printClassResourcesByContextNoPrefix();
	}

}
