package ss.week2.hotel;

public class Guest {
    // ------------------ Instance variables ----------------
	
	String name;
	private Room room;
	
    // ------------------ Constructor ------------------------
	
	/**
     * Creates a <code>Guest</code> with the given name, without a room.
     * @param n name of the new <code>Guest</code>
     */
	public Guest(java.lang.String n){
		name = n;
	}
	
    // ------------------ Queries --------------------------
	
	/**
     * Returns the name of this <code>Guest</code>.
     * @return the name of this <code>Guest</code>
     * 		<code>null</code> if this <code>Guest</code>
     * 		does not exists.
     */
	public String getName(){
		return name;
	}
	
	/**
     * Returns the Room that is rented by this <code>Guest</code>.
     * @return the room of this <code>Guest</code>;
     *         <code>null</code> if this <code>Guest</code> 
     *         does not rent a room
     */
	public Room getRoom(){
			return room;
	}
	
	public String toString(){
		if (this.getName() != null && this.getRoom() != null) {
			System.out.println("Guest " + this.getName() + " rented room " + this.getRoom().getNumber() + ".");
			return "Guest " + this.getName() + " rented room " + this.getRoom().getNumber() + ".";
		} else {
			System.out.println("Guest " + this.getName() + " did not rent a room.");
			return "Guest " + this.getName() + " did not rent a room.";
		}
	}
    // ------------------ Commands --------------------------
	
	/**
     * Rents a <code>Room</code> to this <code>Guest</code>.
     * @param r the next room rented by this <code>Guest</code>\;
     *        if <code>false</code> is passed, this <code>Guest</code>
     *        already has a <code>Room</code>
     *        or <code>Room</code> already has a Guest
     */
	public boolean checkin(Room r){
		if (r.getGuest() == null && this.getRoom() == null){
			room = r;
			r.setGuest(this);
			return true;
		} else {
			return false;
		}
	}
	
	/**
     * Sets this <code>Room</code> of this <code>Guest</code> to null.
     * Also resets the reference of the current <code>Room</code>
     *        if <code>false</code> is passed, this <code>Guest</code>
     *        does not have a <code>Room</code>
     */
	public boolean checkout(){
		 if (this.getRoom() != null) {
			room.setGuest(null);
			room = null;
			return true;
		} else {
			return false;
		}
	}
}
