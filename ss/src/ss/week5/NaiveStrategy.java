package ss.week5;

import java.util.HashSet;
import java.util.ArrayList;
import ss.week4.tictactoe.Board;
import ss.week4.tictactoe.Mark;

public class NaiveStrategy implements Strategy {

	@Override
	public String getName() {
		return "Naive";
	}

	@Override
	public int determineMove(Board b, Mark m) {
		HashSet<Integer> empty = new HashSet<Integer>();
		for (int i=0; i < Board.DIM*Board.DIM; i++) {
			if (b.isEmptyField(i)) {
				empty.add(i);
			}
		}
		ArrayList<Integer> results = new ArrayList<Integer>();
		results.addAll(empty);
		return results.get((int) Math.random()*(results.size()-1));
	}

}
