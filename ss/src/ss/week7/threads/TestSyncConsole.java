package ss.week7.threads;

public class TestSyncConsole extends Thread {
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	private synchronized void sum() throws InterruptedException {
		int first = SyncConsole.readInt("8");
		int second = SyncConsole.readInt("5");
		SyncConsole.println(Integer.toString(first+second));
		System.out.println(1);
	}
}
