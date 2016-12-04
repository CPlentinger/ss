package ss.week3.hotel;

import java.util.Locale;

public class Format {
	
	public static void main(String[] args) {
		printLine("text1", 1.0);
		printLine("other text", -12.12);
		printLine("something", 0.20);
	}
	
	public static String printLine(String text, double amount) {
		System.out.println(String.format(Locale.US, "%-15s% 6.2f", text, amount));
		return String.format(Locale.US, "%-15s% 6.2f", text, amount);
	}
}
