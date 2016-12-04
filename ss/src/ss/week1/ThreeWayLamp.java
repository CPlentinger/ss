package ss.week1;

public class ThreeWayLamp {
	private static final int NUM_SETTINGS = 3;
	private static int setting;
	public ThreeWayLamp(){
		setting = 0;
	}
	public int getSetting(){
		return setting;
	}
	
	public void incSetting(){
		setting = (setting + 1) % (NUM_SETTINGS + 1);
	}
}