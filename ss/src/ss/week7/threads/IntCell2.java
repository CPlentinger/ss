package ss.week7.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class IntCell2 {
	private int contents = 0;
	
	public void add(int amount) {
		contents = contents + amount;
	}
	public int get() {
		return contents;
	}
	
	public static void main(String[] args) {
		IntCell2 cell = new IntCell2();
		Adder a1 = new Adder(cell, 1);
		Adder a2 = new Adder(cell, 2);
		a1.start();
		a2.start();
		try {
			a1.join();
			a2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(cell.get());
	}

}

class Adder extends Thread {
	private IntCell2 cell;
	private int amount;
	
	public Adder(IntCell2 cellArg, int amountArg) {
		this.cell = cellArg;
		this.amount = amountArg;
	}
	
	public synchronized void run() {
		synchronized(cell) {
			cell.add(amount);
		}
	}
}
