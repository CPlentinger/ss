package ss.week6;

public class ArgumentLengthsDifferException extends WrongArgumentException {
	public int length1;
	public int length2;

	public ArgumentLengthsDifferException(int l1, int l2){
		super();
		length1 = l1;
		length2 = l2;
	}
	
	public String getMessage() {
		return "error: length of command line arguments " + "differs (" + length1 + ", " + length2 + ")";
	}
}
