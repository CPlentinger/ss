package ss.week6;

public class TooFewArgumentsException extends WrongArgumentException {
	public TooFewArgumentsException(){
		super();
	}
	
	public String getMessage(){
		return "Please use to strings of equal length.";
	}
}
