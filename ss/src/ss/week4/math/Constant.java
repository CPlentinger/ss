package ss.week4.math;

public class Constant implements Function {
	
	double constant;
	Function derivative;
	
	public Constant(double val){
		constant = val;
	}

	@Override
	public double apply(double arg) {
		return constant;
	}

	@Override
	public Function derivative() {
		return derivative = new Constant(0);
	}
	
	public String toString(){
		return "The constant is: f(x)=" + constant;
	}
}
