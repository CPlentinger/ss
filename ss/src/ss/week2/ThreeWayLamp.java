package ss.week2;

public class ThreeWayLamp {
	public static final int NUM_SETTINGS = 3;
	private static int setting;
	//@ private invariant setting <= NUM_SETTINGS && setting >= 0;
	//@ private invariant NUM_SETTINGS == 3;
	
	//@ ensures this.getSetting() == 0;
	//@ requires theSetting <= 3 && theSetting >= 0;
	//@ pure;
	public ThreeWayLamp(int theSetting){
		setting = theSetting;
		assert setting >= 0 && setting <= NUM_SETTINGS;
	}

	//@ pure;
	public int getSetting(){
		return setting;
	}
	
	//@ ensures this.getSetting() == (\old(this.getSetting()) + 1) % (NUM_SETTINGS + 1);
	//@ ensures \old(this.getSetting() == 0) ==> this.getSetting() == 1;
	//@ ensures \old(this.getSetting() == 1) ==> this.getSetting() == 2;
	//@ ensures \old(this.getSetting() == 2) ==> this.getSetting() == 3;
	//@ ensures \old(this.getSetting() == 3) ==> this.getSetting() == 0;
	public void incSetting(){
		int oldSetting = this.getSetting();
		setting = (setting + 1) % 4;
		assert setting == (oldSetting + 1) % (NUM_SETTINGS + 1);
	}
}