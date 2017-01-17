package ss.week6.voteMachine;

public class Controller {
	PartyList l1;
	VoteList v1;
	public static void main(String[] args) {
		Controller c1 = new Controller();
		VoteMachine m1 = new VoteMachine(c1);
		m1.start();
	}
	public Controller() {
		l1 = new PartyList();
		v1 = new VoteList();
		addParty("1");
		addParty("2");
	}
	
	public void addParty(String party) {
		l1.addParty(party);
	}
	public void vote(String party) {
		v1.addVote(party);
	}
}
