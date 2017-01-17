package ss.week6.voteMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;


public class VoteTUIView implements Observer, VoteView {
	public VoteMachine vm;
	public VoteTUIView(VoteMachine vm1) {
		this.vm = vm1;
	}
	public void start() {
		Scanner in = new Scanner(System.in);
		input:
		while (in.hasNext()) {
			String next = in.next();
				switch (next) {
					case "VOTE":    String vote = in.next();
							        vm.vote(vote);
							        break;
					case "ADD":     if(in.next().equals("PARTY")) {
								      String party = in.next();
								 	  vm.addParty(party);
								    }
								    break;
					case "VOTES":   showVotes(getVotes());
								    break;
					case "PARTIES": showParties(getParties());
									break;
					case "EXIT":	break input;
					case "HELP":	String[] cases = {"VOTE", "ADD PARTY", "VOTES", "PARTIES", "EXIT", "HELP"};
									String[] descr = {"Vote for a party.", "Adds a party to the partylist.", "Shows amount of votes for each party.", "Shows all parties on the partylist.", "Exits the vote machine.", "Shows this very usefull info."};
									for (int i=0; i < 6; i++) {
										System.out.printf("%-15s %s %n", cases[i], descr[i]);
									}			
 			}
		}
	}
	
	public ArrayList<String> getParties() {
		return vm.getParties();
	}
	
	public Map<String, Integer> getVotes() {
		return vm.getVotes();
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
	
	public void showError(String e) {
		System.out.println("An error occured: " + e);
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg1.equals("party")) {
			System.out.println("A new party was added to the partylist.");
		} else {
			System.out.println("The votes have changed.");
		}
	}
}
