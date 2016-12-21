package ss.week5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ss.week4.tictactoe.Board;
import ss.week4.tictactoe.Mark;
import ss.week4.tictactoe.Player;

public class ComputerPlayerTest {

	Player test;
	Board board;
	@Before
	public void setUp() throws Exception {
		test = new ComputerPlayer(Mark.OO);
		board = new Board();
	}

	@Test
	public void test() {
		test.determineMove(board);
	}

}
