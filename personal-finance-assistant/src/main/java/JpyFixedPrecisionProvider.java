
public class JpyFixedPrecisionProvider implements RoundPrecisionProvider {

	public int getRoundPrecision(String currency) {
		
		return 0;
	}

	public boolean isSupported(String currency) {
		
		return "JPY".equals(currency);
	}

}
