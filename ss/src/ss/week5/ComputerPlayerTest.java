package ss.week5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ComputerPlayerTest {

	ComputerPlayer test;
	Board board;
	@Before
	public void setUp() throws Exception {
		test = new ComputerPlayer(Mark.OO);
		board = new Board();
	}

	@Test
	public void test() {
		test.determineMove(board);
		test.getStrategy();
	}

}
