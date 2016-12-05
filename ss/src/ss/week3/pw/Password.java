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
		password = BasicChecker.INITPASS;
	}

	public Password() {
		this(new BasicChecker());
	}

	public boolean acceptable(String suggestion) {
		return checker.acceptable(suggestion);
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
		if (testWord(oldpass) && acceptable(newpass)) {
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
