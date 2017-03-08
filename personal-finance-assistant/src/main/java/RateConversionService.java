import java.math.*;
import java.math.RoundingMode;
import java.util.Date;


public class RateConversionService {
	 
	private CurrencyRateProvider rateProvider;
	
	public void setRateProvider(CurrencyRateProvider rateProvider)
	{
		this.rateProvider = rateProvider;
	}

	public BigDecimal convertAmount(BigDecimal amount, String currency)
	{	
		
		BigDecimal rate = rateProvider.getRate(currency, new Date());
		System.out.println("RateConversationService: Obliczam kwote");
		BigDecimal result =amount.multiply(rate).setScale(2, RoundingMode.HALF_UP);
		return result;
	}
}
