import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableAsync;


@Configuration
@Profile("prod")


public class AppConfigProd {
	
	
	@Bean
	
	public CurrencyRateProvider databaseCurrencyRateProvider ()
	{
		 return new DatabaseCurrencyRateProvider();
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
	@Bean(name = {"anotherPrecisionProvider", "seconfPrecisionProvider"})
	public RoundPrecisionProvider roundJpyPrecisionProvider()
	{
		return new JpyFixedPrecisionProvider();
	}
	
	
}
