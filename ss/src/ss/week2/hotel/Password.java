package ss.week2.hotel;

public class Password {
	public static final java.lang.String INITIAL = "";
	private java.lang.String password;
	
	public Password () {
		password = INITIAL;
	}
	
	public boolean acceptable(String suggestion) {
		if (suggestion.length() >= 6 && !suggestion.contains(" ")) {
			return true;
		} else {
			return false;
		}
	}
	
	//@pure;
	public boolean testWord(String test) {
		if (test.equals(password)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean setWord(String oldpass,String newpass) {
		if (oldpass == password && acceptable(newpass) == true) {
			password = newpass;
			return true;
		} else {
			return false;
		}
	}
}
