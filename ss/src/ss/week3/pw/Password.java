package ss.week3.pw;

public class Password {
	public static final String INITIAL = "";
	private String password;
	public Checker checker;
	public String factoryPassword;
	Password factorypw;

	public Password(Checker check) {
		checker = check;
		factoryPassword = checker.generatePassword();
	}

	public Password() {
		this.checker = new Password(new BasicChecker()).checker;
	}

	public boolean acceptable(String suggestion) {
		if (suggestion.length() >= 6 && !suggestion.contains(" ")) {
			return true;
		} else {
			return false;
		}
	}

	// @pure;
	public boolean testWord(String test) {
		if (test.equals(password)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean setWord(String oldpass, String newpass) {
		if (oldpass == password && acceptable(newpass) == true) {
			password = newpass;
			return true;
		} else {
			return false;
		}
	}
	public Checker checker() {
		return checker;
	}
	
	public String getFactoryPassword() {
		return factoryPassword;
	}
}
