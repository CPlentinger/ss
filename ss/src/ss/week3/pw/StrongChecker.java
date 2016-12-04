package ss.week3.pw;

public class StrongChecker extends BasicChecker{
	
	public boolean acceptable(String suggestion) {
		if (super.acceptable(suggestion) && Character.isLetter(suggestion.charAt(0)) && Character.isDigit(suggestion.charAt((suggestion.length()-1)))) {
			return true;
		} else {
			return false;
		}
	}
	public String generatePassword() {
		String c = "PASSWORD1";
		return c;
	}
}
