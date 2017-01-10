package ss.week6;
import java.util.Scanner;
public class Hello {
	public static void main(String[] args) {
		System.out.println("Enter your name: ");
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String next = in.next();
			System.out.println(next);
			if (next.length() < 1) {
				System.out.println("break");
				break;
			}
			
		}
		
		}
	
}
