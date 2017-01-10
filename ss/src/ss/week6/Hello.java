package ss.week6;
import java.util.Scanner;
public class Hello {
	public static void main(String[] args) {
		System.out.println("Enter your name: ");
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {
			String nextl = in.nextLine();
			if (!nextl.isEmpty()) {
				System.out.println(nextl);
				System.out.println("Enter your name: ");
			} else {
				in.close();
				break;
			}
		}
	}
	
}
