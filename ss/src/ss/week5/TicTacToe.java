package ss.week5;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Executable class for the game Tic Tac Toe. The game can be played against the
 * computer. Lab assignment Module 2
 * 
 * @author Theo Ruys
 * @version $Revision: 1.4 $
 */
public class TicTacToe {
    public static void main(String[] args) {
    	ArrayList<String> arg = new ArrayList<String>(Arrays.asList(args));
    	Game game1;
    	Player[] players = {null,null};
    	if (arg.contains("-N") && arg.toString().contains("-S")) {
    		players[arg.indexOf("-N")] = new ComputerPlayer(new NaiveStrategy(), Mark.OO);
    		players[arg.indexOf("-S")] = new ComputerPlayer(new SmartStrategy(), Mark.XX);
    	} else if (arg.contains("-N")) {
    		players[arg.indexOf("-N")] = new ComputerPlayer(new NaiveStrategy(), Mark.OO);
    		players[Math.abs(arg.indexOf("-N")-1)] = new HumanPlayer(args[Math.abs(arg.indexOf("-N")-1)], Mark.XX);
    	} else if (arg.contains("-S")) {
    		players[arg.indexOf("-S")] = new ComputerPlayer(new SmartStrategy(), Mark.OO);
    		players[Math.abs(arg.indexOf("-S")-1)] = new HumanPlayer(args[Math.abs(arg.indexOf("-S")-1)], Mark.XX);
    	} else {
    		players[0] = new HumanPlayer(args[0], Mark.XX);
    		players[1] = new HumanPlayer(args[1], Mark.XX);
    	}
    	
    	game1 = new Game(players[0], players[1]);
    	game1.start();
    }
    public Player createPlayer(String strategy, Mark m) {
    	if (strategy.equals("-S")) {
    		return new ComputerPlayer(new SmartStrategy(), m);
    	} else {
    		return new ComputerPlayer(new NaiveStrategy(), m);
    	}
    }
}