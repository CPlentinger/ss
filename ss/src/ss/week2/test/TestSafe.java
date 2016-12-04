package ss.week2.test;
import ss.week2.hotel.Safe;
import ss.week2.hotel.Password;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
public class TestSafe {
	private Safe safe1;
	
	@Before
	public void setUp() {
		safe1 = new Safe();
	}

	@Test
	public void testInital() {
		assertFalse(safe1.active);
		assertFalse(safe1.open);
		assertTrue(safe1.getPassword().testWord(Password.INITIAL));
	}
	
	@Test
	public void testActive() {
		assertFalse(safe1.active);
		safe1.activate("Not the password");
		assertFalse(safe1.active);
		
		
	}
}
