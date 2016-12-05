package ss.week3.hotel;

public class PricedRoom extends Room implements Bill.Item {
	
	public double price;
	
	public PricedRoom(int no, double RPrice, double SPrice) {
		super(no, new PricedSafe(SPrice));
		price = RPrice;
	}

	public double getAmount() {
		return price;
	}
	
	public String toString() {
		return String.format("the price per night is %f", this.price);
	}
}
