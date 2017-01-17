package ss.week7.threads;

public class TestConsole extends Thread {
	public static void main(String[] args) {
		TestConsole one = new TestConsole();
		TestConsole two = new TestConsole();
		one.start();
		two.start();
	}
	
	public void run() {
		sum();
	}
	
	private static void sum() {
		String result = Integer.toString(Console.readInt("6") + Console.readInt("3"));
		Console.println(result);
	}
}
