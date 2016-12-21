package ss.week5;
import ss.week4.tictactoe.*;
public class ComputerPlayer extends Player {
	private Strategy strategy;
	
	public ComputerPlayer(Strategy strat, Mark mark) {
		super(strat + "-" + mark, mark);
		strategy = strat;
	}
	
	public ComputerPlayer(Mark mark) {
		this(new NaiveStrategy(), mark);
	}
	
	public Strategy getStrategy() {
		return strategy;
	}
	
	public void updateStrategy(Strategy strat) {
		strategy = strat;
	}

	@Override
	public int determineMove(Board board) {
		return getStrategy().determineMove(board, this.getMark());
	}

}
