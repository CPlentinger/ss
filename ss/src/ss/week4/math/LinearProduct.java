package ss.week4.math;

public class LinearProduct extends Product implements Intergrandable {
	
	public LinearProduct(Constant y, Function x){
		super(x, y);
	}
	
	public double apply(double arg) {
		return f1.apply(arg)*f2.apply(arg);
	}
	public Function derivative() {
		return new LinearProduct(new Constant(f2.apply(0)), f1.derivative());
	}

	@Override
	public Function integrand() {
		if (f1 instanceof Intergrandable && f2 instanceof Constant) {
			return new LinearProduct((Constant) f2, ((Intergrandable) f1).integrand());
		} else {
			return null;
		}
	}
	
	@Override
	public String toString(){
		return f2.toString() + " * " + f1.toString(); 
	}
}