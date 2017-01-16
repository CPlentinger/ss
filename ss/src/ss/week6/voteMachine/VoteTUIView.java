package ss.week6.voteMachine;

import java.util.List;
import java.util.Map;

public class VoteTUIView {
	public void start() {
		
	}
	
	public void showVotes(Map<String,Integer> map) {
		for (String party : map.keySet()) {
			System.out.print(party + " has " + map.get(party) + " vote(s), ");
		}
	}
	
	public void showParties(List<String> list) {
		System.out.println("There are " + list.size() + " parties:");
		for (String party : list) {
			System.out.print(party + ", ");
		}
	}
}
