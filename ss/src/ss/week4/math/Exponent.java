package ss.week4.math;

public class Exponent implements Function {

	public double exponent;

	public Exponent(double val) {
		exponent = val;
	}

	@Override
	public double apply(double arg) {
		return Math.pow(arg, exponent);
	}

	@Override
	public Function derivative() {
		return new LinearProduct(new Exponent((this.exponent - 1)), new Constant(exponent));
	}

}
