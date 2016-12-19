package ss.week4.math;

public class Sum implements Function, Intergrandable{
	public Function f1;
	public Function f2;
	public Sum(Function x, Function y){		
		f1 = x;
		f2 = y;
	}
	
	@Override
	public double apply(double arg) {
		return f1.apply(arg)+f2.apply(arg);
	}
	@Override
	public Function derivative() {
		return new Sum(f1.derivative(), f2.derivative());
	}
	@Override
	public Function integrand() {
		if (f1 instanceof Intergrandable && f2 instanceof Intergrandable) {
			return new Sum(((Intergrandable) f1).integrand(), ((Intergrandable) f2).integrand());
		} else {
			return null;
		}
	}
	
	@Override
	public String toString() {
		return f1.toString() + " + " + f2.toString();
	}

}
