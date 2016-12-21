package ss.week5;
import ss.week4.tictactoe.*;
public class ComputerPlayer extends Player {
	
	public ComputerPlayer(Strategy strat, Mark mark) {
		super(strat + "-" + mark, mark);
	}
	
	public ComputerPlayer(Mark mark) {
		this(new NaiveStrategy(), mark);
	}

	@Override
	public int determineMove(Board board) {
		Object strategy = (this.getName().split("-"))[0];
		System.out.println(strategy.getClass());
		return 0;
	}

}
