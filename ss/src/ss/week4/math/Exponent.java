package ss.week4.math;

public class Exponent implements Function, Intergrandable {

	public int exponent;

	public Exponent(int val) {
		exponent = val;
	}

	@Override
	public double apply(double arg) {
		return Math.pow(arg, exponent);
	}

	@Override
	public Function derivative() {
		return new LinearProduct(new Constant(exponent), new Exponent((this.exponent - 1)));
	}

	@Override
	public Function integrand() {
		return new LinearProduct(new Constant(1.0/(this.exponent+1)), new Exponent(this.exponent+1));
	}
	
	@Override
	public String toString() {
		if (exponent != 0 && exponent != 1) {
			return "(x^" + exponent + ")";
		} else if (exponent == 0) {
			return "(1)";
		} else {
			return "(x)";
		}
	}
}
