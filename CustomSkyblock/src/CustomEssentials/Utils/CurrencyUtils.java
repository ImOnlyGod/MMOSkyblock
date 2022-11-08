package CustomEssentials.Utils;

public class CurrencyUtils {
	
	public static String setString(double value, char c) {
		String prefix = "" + Math.floor(value*100)/100000;
		return prefix+c;		
	}
	public static String currencyFormat(double value) {
		if (value > 999 && value < 1000000) {
			return setString(value,'k');
		}
		else if (value > 999999 && value < 1000000000) {
			return setString(value,'m');
		}
		else if (value > 999999999) {
			return setString(value,'b');
		}
		
		return ""+value;
	}
				
}
