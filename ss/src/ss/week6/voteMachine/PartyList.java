package ss.week6.voteMachine;

import java.util.ArrayList;
import java.util.Observable;

public class PartyList extends Observable {
	
	ArrayList<String> PartyList;
	public PartyList() {
		PartyList  = new ArrayList<String>();
	}
	public void addParty(String party) {
		PartyList.add(party);
		setChanged();
		notifyObservers("party");
	}
	
	public ArrayList<String> getParties() {
		return PartyList;
	}
	
	public boolean hasParty(String party) {
		return PartyList.contains(party);		
	}
}
