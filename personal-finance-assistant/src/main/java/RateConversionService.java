import java.math.*;
import java.math.RoundingMode;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service
public class RateConversionService {
	 
	private CurrencyRateProvider rateProvider;
	
	@Autowired
	public void setRateProvider(CurrencyRateProvider rateProvider)
	{
		this.rateProvider = rateProvider;
	}
	
	@Autowired(required = false)
	@Qualifier("seconfPrecisionProvider")
	private Map<String, RoundPrecisionProvider> precisionProviders;
	
	public BigDecimal convertAmount(BigDecimal amount, String currency)
	{	
		BigDecimal rate = rateProvider.getRate(currency, new Date());
		System.out.println("RateConversationService: Obliczam kwote");
		int precision =2;
		System.out.println("Ilosc dostawcow: " + precisionProviders.size());
		for(String providerName : precisionProviders.keySet()) 
		{
			RoundPrecisionProvider provider = precisionProviders.get(providerName);
      		System.out.println("Bean "+ providerName);
			if(provider.isSupported("PLN"));
			{
				precision = provider.getRoundPrecision("PLN");
			}
			
		}
		
		BigDecimal result =amount.multiply(rate).setScale(2, RoundingMode.HALF_UP);
		return result;
	}
}
