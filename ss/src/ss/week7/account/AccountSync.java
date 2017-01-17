package ss.week7.account;

public class AccountSync {
	public static Account acc = new Account();
	public static void main(String[] args) {
		Thread one = new MyThread(-100, 12, acc);
		Thread two = new MyThread(100, 15, acc);
		one.start();
		two.start();
		try {
			one.join();
			two.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(acc.getBalance());
	}
}
