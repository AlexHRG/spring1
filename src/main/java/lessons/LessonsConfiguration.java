package lessons;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lessons.services.GreetingService;
import lessons.services.GreetingServiceImpl;

@Configuration
public class LessonsConfiguration {
	@Bean
	GreetingService greetingService() {
		return new GreetingServiceImpl();
	}
}
