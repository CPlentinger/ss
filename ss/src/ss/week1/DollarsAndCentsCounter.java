package ss.week1;

public class DollarsAndCentsCounter {

	private int numberCents;
	
	public DollarsAndCentsCounter(){
		numberCents = 0;
	}
	
	public void reset(){
		numberCents = 0;
	}
	
	public void add(int dollars,int cents){
		numberCents += 100*dollars + cents;
	}
	public void substract(int dollars,int cents){
		numberCents -= cents;
		numberCents -= dollars;
	}
	public int dollars(){
		return numberCents / 100;
	}
	public int cents(){
		return numberCents %100;
	}
}
