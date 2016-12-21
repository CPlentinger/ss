package ss.week5;

public class SmartStrategy implements Strategy {
	
	@Override
	public String getName() {
		return "Smart";
	}

	@Override
	public int determineMove(Board b, Mark m) {
		int middle = ((Board.DIM*Board.DIM)-1)/2;
		for (int i = 0; i < Board.DIM*Board.DIM-1; i++) {
			if (b.isEmptyField(i)) {
				Board copy = b.deepCopy();
				copy.setField(i, Mark.XX);
				if (copy.isWinner(Mark.XX)) {
					return i;
				}
				copy.setField(i, Mark.OO);
				if (copy.isWinner(Mark.OO)) {
					return i;
				}
			}		
		}
		if (b.isEmptyField(middle)) {
			return middle;
		}
		Strategy random = new NaiveStrategy();
		return random.determineMove(b, m);
	}

}
