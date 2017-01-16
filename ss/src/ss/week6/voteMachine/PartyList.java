package ss.week6.voteMachine;

import java.util.ArrayList;

public class PartyList {
	
	ArrayList<String> PartyList;
	public PartyList() {
		PartyList  = new ArrayList<String>();
	}
	public void addParty(String party) {
		PartyList.add(party);
	}
	
	public ArrayList<String> getParties() {
		return PartyList;
	}
	
	public boolean hasParty(String party) {
		return PartyList.contains(party);		
	}
}
