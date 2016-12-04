package ss.week2;

public class ThreeWayLamp2 {
	public enum Setting {OFF,LOW,MEDIUM,HIGH}
	private static Setting setting;
	
	//@ ensures getSetting() == Setting.OFF;
	//@ pure
	public ThreeWayLamp2(){
		setting = Setting.OFF;
		assert setting == Setting.OFF;
	}
	
	//@ ensures theSetting == this.getSetting();
	//@ pure
	public ThreeWayLamp2(Setting theSetting){
		setting = theSetting;
		assert setting == theSetting;
	}
	//@ pure
	public Setting getSetting(){
		return setting;
	}
	
	//@ ensures \old(this.getSetting()) == Setting.OFF ==> this.getSetting() == Setting.LOW;
	//@ ensures \old(this.getSetting()) == Setting.LOW ==> this.getSetting() == Setting.MEDIUM;
	//@ ensures \old(this.getSetting()) == Setting.MEDIUM ==> this.getSetting() == Setting.HIGH;
	//@ ensures \old(this.getSetting()) == Setting.HIGH ==> this.getSetting() == Setting.OFF;
	public void incSetting(){
		switch (setting) {
			case OFF:
				setting = Setting.LOW;
				break;
				
			case LOW:
				setting = Setting.MEDIUM;
				break;
				
			case MEDIUM:
				setting = Setting.HIGH;
				break;
				
			case HIGH:
				setting = Setting.OFF;
				break;
			
			default:
				break;
		
		}
	}
}