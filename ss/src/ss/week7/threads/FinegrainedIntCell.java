package ss.week7.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class FinegrainedIntCell implements IntCell{
	
	public static ReentrantLock l1 = new ReentrantLock();
	final static Condition read = l1.newCondition();
	final static Condition written = l1.newCondition();
	public int value;
	public static void main(String[] args) {
		FinegrainedIntCell cell = new FinegrainedIntCell();
		Thread prod1 = new IntProducer(1, cell);
		Thread prod2 = new IntProducer(2, cell);
		Thread cons1 = new IntConsumer(1, cell);
		Thread cons2 = new IntConsumer(2, cell);

		prod1.start();
		prod2.start();
		cons1.start();
		cons2.start();
	}
	@Override
	public void setValue(int val) {
		l1.lock();
		try {
			
			value = val;
			written.signal();
			try {
				read.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} finally {
			l1.unlock();
		}
	}

	@Override
	public int getValue() {
		l1.lock();
		try {
			
			try {
				written.await();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return value;
		} finally {
			read.signal();
			l1.unlock();
			
		}
	}
	
}
