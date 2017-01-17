package ss.week7.account;

import java.io.IOException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
	protected double balance = 0.0;
	public static ReentrantLock l1 = new ReentrantLock();
	public static Condition low = l1.newCondition();
	public void transaction(double amount) {
		l1.lock();
		try {
			while (balance+amount<-1000) {
				try {
					low.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			low.signalAll();
			balance = balance + amount;
		} finally {
			l1.unlock();
		}
	}
	
	public double getBalance() {
		return balance;

	}
}
