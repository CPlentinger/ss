package ss.week3.pw;


public class TimedPassword extends Password {
	public Password password;
	public long expireTime;
	public long createdAt;
	
	public TimedPassword(long validtime) {
		expireTime = (1000*validtime);
		createdAt = System.currentTimeMillis();
		password = new Password();
	}
	public TimedPassword() {
		expireTime = 300000;
		createdAt = System.currentTimeMillis();
		password = new Password();
		
	}
	
	public boolean isExpired() {
		if (System.currentTimeMillis() - createdAt < expireTime) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean setWord(String oldpass, String newpass) {
		super.setWord(oldpass, newpass);
		createdAt = System.currentTimeMillis();
		return true;
	}
}
