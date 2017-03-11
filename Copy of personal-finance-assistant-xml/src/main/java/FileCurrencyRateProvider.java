import java.math.*;
import java.util.Date;

public class FileCurrencyRateProvider implements CurrencyRateProvider{
	
	
	private String fileName;

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public BigDecimal getRate(String currency, Date rateDate) {
		System.out.println("Bean: " + hashCode());
		System.out.println("FileCurrencyRateProvider: Wczytano kursy z pliku lokalnego" +fileName);
		return BigDecimal.valueOf(4.25);
	}

	
	
  	
}
 