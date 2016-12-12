package ss.week4.math;

public class Homework {

	public static void main(String[] args) {
		LinearProduct f1 = new LinearProduct(new Constant(6), new Exponent(3));
		Function f1d = f1.derivative();
		Function f1i = f1.integrand();
		System.out.println("f(x) = " + f1 + ", f(8) =  " + f1.apply(8));
		System.out.println("f'(x) = " + f1d + ", f'(8) =  " + f1d.apply(8));
		System.out.println("F(x) = " + f1i + ", F(8) =  " + f1i.apply(8));
		
		Sum f2 = new Sum(new Exponent(2), new Constant(18));
		Function f2d = f2.derivative();
		System.out.println("f(x) = " + f2 + ", f(6) =  " + f2.apply(6));
		System.out.println("f'(x) = " + f2d + ", f'(6) =  " + f2d.apply(6));
		
		Product f3 = new Product(new Exponent(4), new Exponent(1));
		Function f3d = f3.derivative();
		System.out.println("f(x) = " + f3 + ", f(4) =  " + f3.apply(4));
		System.out.println("f'(x) = " + f3d + ", f'(4) =  " + f3d.apply(4));		
	}

}
