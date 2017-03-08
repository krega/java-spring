import java.math.*;
import java.util.Date;


public interface CurrencyRateProvider {
	BigDecimal getRate(String currency, Date rateDate);
}
