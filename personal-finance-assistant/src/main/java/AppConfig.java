import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
	@Bean
	@Scope("prototype")
	public CurrencyRateProvider fileCurrencyRateProvider ()
	{
		 return new FileCurrencyRateProvider();
	}
	
	@Bean
	public RateConversionService rateConversionService()
	{
		RateConversionService rateConversionService = new RateConversionService();
		rateConversionService.setRateProvider(fileCurrencyRateProvider());
		return rateConversionService; 
	}
	
	@Bean
	public SecondRateConversionService secondRateConversionService()
	{
		SecondRateConversionService rateConversionService = new SecondRateConversionService();
		rateConversionService.setRateProvider(fileCurrencyRateProvider());
		return rateConversionService; 
	}
}
