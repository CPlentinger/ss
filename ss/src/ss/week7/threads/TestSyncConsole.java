package ss.week7.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestSyncConsole extends Thread {
	public static Lock ReL = new ReentrantLock();
	public static void main(String[] args) {
		TestSyncConsole one = new TestSyncConsole();
		TestSyncConsole two = new TestSyncConsole();
		one.start();
		two.start();
	}
	
	public void run() {
			try {
				sum();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	
	private void sum() throws InterruptedException {
		ReL.lock();
		int first = SyncConsole.readInt("Input first number:");
		int second = SyncConsole.readInt("Input second number:");
		SyncConsole.println(Integer.toString(first + second));
		ReL.unlock();
	}
}