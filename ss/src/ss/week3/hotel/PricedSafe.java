package ss.week3.hotel;

public class PricedSafe extends Safe implements Bill.Item{
	
	public double price;
	public PricedSafe(double theprice){
		price = theprice;
	}

	public double getAmount() {
		return price;
	}

	public String toString() {
		return String.format("the price of the safe is %f", this.price);
	}
	
}
