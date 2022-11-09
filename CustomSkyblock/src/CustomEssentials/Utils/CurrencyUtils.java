package CustomEssentials.Utils;

public class CurrencyUtils {
	
	public static String setString(double value, char c, int divide) {
		if (value > 999999999) {
			String prefix = "" +  Math.floor(Math.floor(value)/(divide)*100)/100;
			return prefix+c;
		}
		else {
			String prefix = "" + Math.floor(Math.floor(value*100)/(100*divide)*100)/100;
			return prefix+c;
		}						
	}
	public static String currencyFormat(double value) {
		if (value > 999 && value < 1000000) {
			return setString(value,'k',1000);
		}
		else if (value > 999999 && value < 1000000000) {
			return setString(value,'m',1000000);
		}
		else if (value > 999999999) {
			return setString(value,'b',1000000000);
		}
		
		return ""+Math.floor(value*100)/100;
	}
				
}
