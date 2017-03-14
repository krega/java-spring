import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
	@Bean
	
	public CurrencyRateProvider fileCurrencyRateProvider ()
	{
		 return new FileCurrencyRateProvider();
	}
	
	@Bean
	public RateConversionService rateConversionService()
	{
		RateConversionService rateConversionService = new RateConversionService();
		
		return rateConversionService; 
	}
	@Bean
	public RoundPrecisionProvider roundPrecisionProvider()
	{
		return new FixedPrecisionProvider();
	}
	@Bean
	public RoundPrecisionProvider roundJpyPrecisionProvider()
	{
		return new JpyFixedPrecisionProvider();
	}
	
	
}
