package ss.week3.pw;


public class TimedPassword extends Password {
	public long expireTime;
	public long createdAt;
	
	public TimedPassword(long validtime) {
		expireTime = (1000*validtime);
		createdAt = System.currentTimeMillis();
	}
	public TimedPassword() {
		expireTime = 300000;
		createdAt = System.currentTimeMillis();
	}
	
	public boolean isExpired() {
		return System.currentTimeMillis() - createdAt > expireTime;
	}
	
	public boolean setWord(String oldpass, String newpass) {
		if (super.setWord(oldpass, newpass)) {
			createdAt = System.currentTimeMillis();
			return true;
		} else {
			return false;
		}
	}
}
