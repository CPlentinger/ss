package ss.week6;

public class ArgumentLengthsDifferException extends WrongArgumentException {
	public ArgumentLengthsDifferException(int l1, int l2, Throwable cause){
		super("error: length of command line arguments " + "differs (" + l1 + ", " + l2 + ")", cause);
	}
}
