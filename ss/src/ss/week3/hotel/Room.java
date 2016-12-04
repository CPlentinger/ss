package ss.week3.hotel;

/**
 * Hotel room with number and possibly a guest.
 * @author Arend Rensink
 * @version $Revision: 1.2 $
 */
public class Room {
    // ------------------ Instance variables ----------------

    private int number;
    private Guest guest;
    public PricedSafe psafe;
    public Safe safe;

    // ------------------ Constructor ------------------------

    /**
     * Creates a <code>Room</code> with the given number, without a guest.
     * @param no number of the new <code>Room</code>
     */
    public Room(int no){
    	number = no;
    	safe = new Safe();
    }
    
    public Room(int no, PricedSafe Psafe) {
    	number = no;
    	psafe = Psafe;
    }

    // ------------------ Queries --------------------------

    /**
     * Returns the number of this <code>Room</code>.
     */
    public int getNumber() {
    	return number;
    }

    /**
     * Returns the current guest living in this <code>Room</code>.
     * @return the guest of this <code>Room</code>;
     *         <code>null</code> if this <code>Room</code> 
     *         is not currently rented
     */
    public Guest getGuest() {
    	return guest;
    }
    
    public Safe getSafe() {
    	return safe;
    }

	public String toString(){
		if (this.getNumber() != 0 && this.getGuest() != null) {
			System.out.println("Room " + this.getNumber() + " is rented by " + this.getGuest().getName() + ".");
			return "Room " + this.getNumber() + " is rented by " + this.getGuest().getName() + ".";
		} else {
			System.out.println("Room " + this.getNumber() + " is empty.");
			return "Room " + this.getNumber() + " is empty.";
		}
	}
    // ------------------ Commands --------------------------

    /**
     * Assigns a <code>Guest</code> to this <code>Room</code>.
     * @param g the next guest renting this <code>Room</code>;
     *        if <code>null</code> is passed, this <code>Room</code>
     *        is empty afterwards
     */
    public void setGuest(Guest g) {
    	guest = g;
    }
    
    public void setSafe(Safe thesafe) {
    	safe = thesafe;
    }
}
