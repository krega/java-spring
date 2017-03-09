import java.math.BigDecimal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsoleApplication {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/appconfig.xml");
		RateConversionService service = context.getBean(RateConversionService.class);
		service.convertAmount(BigDecimal.valueOf(123.00), "EUR");
		
		
		
	}
	

}
