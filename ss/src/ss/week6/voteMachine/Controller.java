package ss.week6.voteMachine;

public class Controller {
	VoteMachine m1;
	PartyList l1;
	VoteList v1;
	
	public Controller(String[] parties, String[] votes) {
		l1 = new PartyList();
		v1 = new VoteList();
		for (String party : parties) {
			this.addParty(party);
			v1.getVotes().put(party, 0);
		}
	}
	
	public static void main(String[] args) {
		VoteMachine m1 = new VoteMachine(new PartyList(), new VoteList());
		m1.getVoteList().addVote("one");
		m1.getVoteList().addVote("one");
		m1.getVoteList().addVote("two");
		m1.start();
	}
	public void addParty(String party) {
		l1.addParty(party);
	}
	public void vote(String party) {
		v1.addVote(party);
	}
}
