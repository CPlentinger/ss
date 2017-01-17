package ss.week4.math;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PolynomialTest {

	public double[] array = {1,2,3,4};
	public Polynomial x;
	
	@Before
	public void setUp() throws Exception {
		x = new Polynomial(array);
	}

	@Test
	public void testApply() {
		assertTrue(x.apply(2) == 49);
		assertTrue(x.apply(4) == 313);
	}

	@Test
	public void testDerivative() {
		assertTrue(x.derivative().apply(2) == 62);
		assertTrue(x.derivative().apply(4) == 218);
	}

	@Test
	public void testIntegrand() {
		assertTrue(x.integrand().apply(2) == 30);
		assertTrue(x.integrand().apply(4) == 340);
	}

}
