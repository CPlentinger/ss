package ss.week4.math;

public class LinearProduct extends Product {
	
	public LinearProduct(Function x, Constant y){
		super(x, y);
	}
	
	public double apply(double arg) {
		return f2.apply(arg)*f1.apply(arg);
	}
	public Function derivative() {
		return new LinearProduct(f1.derivative(), new Constant(f2.apply(0))	);
	}
}