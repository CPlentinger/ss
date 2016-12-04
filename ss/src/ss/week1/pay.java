package ss.week1;

public class pay {

	public static void main(String[] args) {
		Employee.pay();
		
	}
public static class Employee {
	private static int hours;
	private static double rate;
	private static double result;
	public static double pay(){
		hours = 30;
		rate = 1.2;
		if (hours <= 40) {
			result = hours * rate;
		} else {
			result = (40 * rate) + ((hours - 40)*(rate * 1.5));
		}
		
		System.out.println(result);
		return result;
	}
	
}
}
