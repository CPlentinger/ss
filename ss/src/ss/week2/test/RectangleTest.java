package ss.week2.test;

import org.junit.Before;
import org.junit.Test;
import ss.week2.Rectangle;
import static org.junit.Assert.assertEquals;
import org.junit.rules.ExpectedException;
import org.junit.Rule;
public class RectangleTest {
    private Rectangle rec0;
    private Rectangle rec1;
    private Rectangle rec2;
    
    @Rule
    public ExpectedException thrown= ExpectedException.none();
    
    @Before
    public void setUp() {
        rec0 = new Rectangle(0, 0);
        rec1 = new Rectangle(5, 3);
        thrown.expect(AssertionError.class);
        rec2 = new Rectangle(-3, -5);
    }
    
    @Test
    public void testLenght() {
        assertEquals(0, rec0.length());
        assertEquals(5, rec1.length());
    }

    @Test
    public void testWidth() {
        assertEquals(0, rec0.width());
        assertEquals(3, rec1.width());
    }

    @Test
    public void testArea() {
        assertEquals(0, rec0.area());
        assertEquals(15, rec1.area());
    }

    @Test
    public void testPerimeter() {
        assertEquals(0, rec0.perimeter());
        assertEquals(16, rec1.perimeter());
    }
}
