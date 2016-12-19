package ss.week4.math;

public class Constant implements Function, Intergrandable {
	
	double constant;
	
	public Constant(double val){
		constant = val;
	}

	@Override
	public double apply(double arg) {
		return constant;
	}

	@Override
	public Function derivative() {
		return new Constant(0);
	}

	@Override
	public Function integrand() {
		return new LinearProduct(new Constant(constant), new Exponent(1));
	}
	
	@Override
	public String toString(){
		return "(" + constant + ")";
	}
}
