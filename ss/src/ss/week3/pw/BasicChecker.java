package ss.week3.pw;

public class BasicChecker implements Checker {
	public static String INITPASS;
	
	public boolean acceptable(String suggestion) {
		if (suggestion.length() >= 6 && !suggestion.contains(" ")) {
			return true;
		} else {
			return false;
		}
	}
	
	public String generatePassword() {
		INITPASS = "PASSWORD" ;
		return INITPASS;
	}
	
}