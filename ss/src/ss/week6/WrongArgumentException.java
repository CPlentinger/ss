package ss.week6;

public class WrongArgumentException extends Exception {
	public WrongArgumentException(){
		super();
	}
	
	public String getMessage() {
		return "Wrong arguments, please use two strings of equal length.";
	}
}
