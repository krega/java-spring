import java.math.*;
import java.math.RoundingMode;
import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;


public class RateConversionService {
	 
	private CurrencyRateProvider rateProvider;
	private Set<String> supportedCurr;
	public void setSupportedCurr(Set<String> supportedCurr) {
		this.supportedCurr = supportedCurr;
	}
	
	@Autowired
	public void setRateProvider(CurrencyRateProvider rateProvider)
	{
		this.rateProvider = rateProvider;
	}

	public BigDecimal convertAmount(BigDecimal amount, String currency)
	{	
		BigDecimal rate = rateProvider.getRate(currency, new Date());
		if(supportedCurr.contains(currency))
		{
			System.out.println("Waluta z zbiorze walut"+currency);
		}
		System.out.println("RateConversationService: Obliczam kwote");
		BigDecimal result =amount.multiply(rate).setScale(2, RoundingMode.HALF_UP);
		return result;
	}
}
