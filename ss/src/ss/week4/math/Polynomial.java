package ss.week4.math;

import java.util.ArrayList;
import java.util.List;

public class Polynomial implements Function, Intergrandable {

	public List<LinearProduct> l1 = new ArrayList<LinearProduct>();
	
	
	public Polynomial(double[] val) {
		for (int i = 0; i < val.length; i++) {
			l1.add(new LinearProduct(new Constant(val[i]), new Exponent(i)));
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
		List<Sum> l2 = new ArrayList<Sum>();
		for (int i = 0; i < l1.size() -1; i += 2) {
			l2.add(new Sum(l1.get(i).derivative(), l1.get(i+1).derivative()));
		}
		while (l2.size() > 1) {
			for (int i = 0; i < l2.size()-1; i++) {
				Sum first = l2.get(i);
				Sum second = l2.get(i+1);
				l2.remove(i+1);
				l2.remove(i);
				l2.add(i, new Sum(first, second));
			}
		}
		return l2.get(0);
	}

	@Override
	public Function integrand() {
		List<Sum> l2 = new ArrayList<Sum>();
		for (int i = 0; i < l1.size() -1; i += 2) {
			l2.add(new Sum(l1.get(i).integrand(), l1.get(i+1).integrand()));
		}
		while (l2.size() > 1) {
			for (int i = 0; i < l2.size()-1; i++) {
				Sum first = l2.get(i);
				Sum second = l2.get(i+1);
				l2.remove(i+1);
				l2.remove(i);
				l2.add(i, new Sum(first, second));
			}
		}
		return l2.get(0);
	}
}
