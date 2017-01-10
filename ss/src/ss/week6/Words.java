package ss.week6;
import java.util.Scanner;
public class Words {
	public static void main(String[] args) {
		System.out.print("Line: ");
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String next = in.next();
			if (!next.equals("end")) {
				System.out.println(next);
			} else {
				in.close();
				break;
			}
		}
	}
}
