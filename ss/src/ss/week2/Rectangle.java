package ss.week2;

public class Rectangle {
    private int length;
    private int width;
    //@ private invariant length >= 0;
    //@ private invariant width >= 0;
    /**
     * Create a new Rectangle with the specified length and width.
     */
    //@ ensures theLength == this.length() && theWidth == this.width();
    public Rectangle(int theLength, int theWidth) {
    	assert theLength >= 0;
    	assert theWidth >= 0;
    	length = theLength;
    	width = theWidth;
    	assert theLength == this.length();
    	assert theWidth == this.width();
    }
    
    /**
     * The length of this Rectangle.
     */
    //@ ensures \result >= 0;
    //@ pure;
    public int length() {
    	return this.length;
    }

    /**
     * The width of this Rectangle.
     */
    //@ ensures \result >= 0;
    //@ pure;
    public int width() {
    	return this.width;
    }

    /**
     * The area of this Rectangle.
     */
    //@ ensures \result == this.length() * this.width() && \result >= 0;
    public int area() {
    	int area;
    	area = length * width;
    	assert area >= 0;
    	assert area == length * width;
    	return area;
    }

    /**
     * The perimeter of this Rectangle.
     */
    //@ ensures \result == (2*this.length())+(2*this.width()) && \result >= 0;
    public int perimeter() {
    	int perimeter;
    	perimeter = (2*length)+(2*width);
    	assert perimeter >= 0;
    	assert perimeter == (2*length)+(2*width);
    	return perimeter;
    }
}
