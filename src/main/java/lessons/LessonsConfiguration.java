package lessons;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import lessons.services.GreetingService;
import lessons.services.GreetingServiceImpl;

@Configuration
@ComponentScan(basePackages = "lessons.services")
public class LessonsConfiguration {
	
	@Bean(name = "greetingService")
	GreetingService greetingService() {
		return new GreetingServiceImpl();
	}
	
	@Bean
	Person person() {
		return new Person();
	}
}
