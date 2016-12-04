package ss.week3.hotel;

public class Item implements Bill.Item {
	public static String description;
	public static double amount;
	
	
	public Item(String thedescription, double theamount) {
		description = thedescription;
		amount = theamount;
	}
	public double getAmount() {
		return amount;
	}
	
	public String toString() {
		return description;
	}
}
