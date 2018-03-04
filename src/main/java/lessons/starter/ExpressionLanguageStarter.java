package lessons.starter;

import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import lessons.spel.Inventor;

public class ExpressionLanguageStarter {

	private static ExpressionLanguageStarter starter;
	private static final Logger LOGGER = LogManager.getLogger(ExpressionLanguageStarter.class);
	
	public static void main(String[] args) {
		LOGGER.info("Starting configuration...");
		
		starter = new ExpressionLanguageStarter();
		
		
		Inventor tesla = new Inventor("Nikola Tesla", new Date(), "Serbian");

		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression("name");
		Expression exp2 = parser.parseExpression("nationality");

		EvaluationContext context = new StandardEvaluationContext(tesla);
		String name = (String) exp.getValue(context);
		
		LOGGER.info("name: " + name);
		
		name = (String) exp.getValue(tesla);
		String nationality = (String) exp2.getValue(tesla);
		
		LOGGER.info("name: " + name + "; nationality: " + nationality);
	}

}
