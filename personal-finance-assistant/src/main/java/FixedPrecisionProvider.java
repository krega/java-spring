import org.springframework.stereotype.Service;

@Service
public class FixedPrecisionProvider implements RoundPrecisionProvider {

	public int getRoundPrecision(String currency) {
		
		return 2;
	}

	public boolean isSupported(String currency) {
		// TODO Auto-generated method stub
		return "PLN".equals(currency);
	}

}
