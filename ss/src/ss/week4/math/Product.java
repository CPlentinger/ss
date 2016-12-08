package ss.week4.math;

public class Product implements Function {
	
	public Function f1;
	public Function f2;
	
	public Product(Function x, Function y) {
		f1 = x;
		f2 = y;
	}
	
	@Override
	public double apply(double arg) {
		return f1.apply(arg)*f2.apply(arg);
	}

	@Override
	public Function derivative() {
		return new Sum(new Product(f1.derivative(),f2), new Product(f1,f2.derivative()));
	}

}
