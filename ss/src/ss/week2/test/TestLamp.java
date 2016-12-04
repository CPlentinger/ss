package ss.week2.test;
import ss.week2.ThreeWayLamp2;
public class TestLamp {
	public static void main(String[] args) {
		ThreeWayLampTest test = new ThreeWayLampTest();
		test.run();
	}
}
class ThreeWayLampTest{
	private ThreeWayLamp2 lamp;
	public void setUp(){
		lamp = new ThreeWayLamp2();
	}
	public void run(){
		setUp();
		testSwitch(); 
	}
	public void testSwitch(){
		lamp.incSetting();
		lamp.incSetting();
		lamp.incSetting();
		System.out.println("Setting:"+ lamp.getSetting());
	}
}