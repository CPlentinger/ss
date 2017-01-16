package ss.week6.voteMachine;
import java.util.HashMap;
import java.util.Map;
public class VoteList {
	public HashMap<String,Integer> VoteList;
	
	public VoteList() {
		VoteList = new HashMap<String,Integer>();
	}
	
	public void addVote(String party) {
		if (VoteList.containsKey(party)) {
			VoteList.put(party, VoteList.get(party) + 1);
		} else {
			VoteList.put(party, 1);
		}
	}
	
	public Map<String,Integer> getVotes() {
		return VoteList;
	}
	
}
