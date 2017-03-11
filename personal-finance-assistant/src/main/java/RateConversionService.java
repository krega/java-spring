import java.math.*;
import java.math.RoundingMode;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;


public class RateConversionService {
	 
	private CurrencyRateProvider rateProvider;
	
	@Autowired
	public void setRateProvider(CurrencyRateProvider rateProvider)
	{
		this.rateProvider = rateProvider;
	}
	
	@Autowired(required = false)
	private RoundPrecisionProvider precisionProvider;
	
	public BigDecimal convertAmount(BigDecimal amount, String currency)
	{	
		BigDecimal rate = rateProvider.getRate(currency, new Date());
		System.out.println("RateConversationService: Obliczam kwote");
		int precision =2;
		if(precisionProvider !=null)
		{
	//		precision = precisionProvider.get
		}
		BigDecimal result =amount.multiply(rate).setScale(2, RoundingMode.HALF_UP);
		return result;
	}
}
