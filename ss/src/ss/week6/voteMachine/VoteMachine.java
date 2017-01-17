package ss.week6.voteMachine;

import java.util.ArrayList;
import java.util.Map;

import ss.week6.voteMachine.gui.VoteGUIView;

public class VoteMachine {
	VoteView view;
	Controller ctrl;
	public VoteMachine(Controller control) {
		ctrl = control;
		view = new VoteGUIView(this);
		ctrl.l1.addObserver(view);
		ctrl.v1.addObserver(view);
	}
	
	public void start() {
		view.start();
	}
	
	public void addParty(String party) {
		ctrl.addParty(party);
	}
	
	public ArrayList<String> getParties() {
		return ctrl.l1.getParties();
	}

	public void vote(String party) {
		ctrl.vote(party);
	}

	public Map<String, Integer> getVotes() {
		return ctrl.v1.getVotes();
	}
}
