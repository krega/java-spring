import java.math.BigDecimal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConsoleApplication {

	public static void main(String[] args) {
		ApplicationContext contex = new AnnotationConfigApplicationContext(AppConfig.class);
		RateConversionService service = contex.getBean(RateConversionService.class);
		service.convertAmount(BigDecimal.valueOf(123.00), "EUR");
		
		
		SecondRateConversionService service2 = contex.getBean(SecondRateConversionService.class);
		service2.convertAmount(BigDecimal.valueOf(1244.00), "EUR");
	}
	

}
