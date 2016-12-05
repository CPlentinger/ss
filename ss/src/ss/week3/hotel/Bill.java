package ss.week3.hotel;

import java.io.*;
public class Bill {
	
	public PrintStream stream;
	public double sum;
	
	public interface Item {
		public double getAmount();
		public String toString();
	}
	
	public Bill(java.io.PrintStream theOutStream) {
		stream = theOutStream;
	}
	
	public void close() {
		stream.println(getSum());
	}
	
	public double getSum() {
		return sum;
	}
	
	public void newItem(Bill.Item item) {
		stream.println(Format.printLine(item.toString(), item.getAmount()));
		sum += item.getAmount();
	}
}