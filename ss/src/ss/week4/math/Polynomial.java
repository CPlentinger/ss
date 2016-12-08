package ss.week4.math;

import java.util.ArrayList;
import java.util.List;

public class Polynomial implements Function {

	public List<LinearProduct> l1 = new ArrayList<LinearProduct>();

	public Polynomial(double[] val) {
		for (int i = 0; i < val.length; i++) {
			l1.add(new LinearProduct(new Exponent(i), new Constant(val[i])));
		}
	}

	@Override
	public double apply(double arg) {
		double sum = 0;
		for (int i = 0; i < l1.size(); i++) {
			sum += l1.get(i).apply(arg);
		}
		return sum;
	}

	@Override
	public Function derivative() {
		for (int i = 0; i < l1.size(); i++) {
			new Sum(l1.get(i), l1.get(i+1));
			
		}
		return sum;
	}

}
