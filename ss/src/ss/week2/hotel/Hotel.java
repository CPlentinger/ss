package ss.week2.hotel;

import ss.week2.hotel.Room;
import ss.week2.hotel.Guest;
import ss.week2.hotel.Safe;

public class Hotel 
{
	// Initialize variables
	public String name;
	
	// Initialize objects
	public Room room1;
	public Room room2;
	public Safe safe1;
	public Safe safe2;
	public Password hotel_password;
	
	// Constructor for Hotel
	public Hotel(String name){
		this.name = name;
		hotel_password = new Password();
		
		room1 = new Room(1);
		safe1 = new Safe();
		room1.setSafe(safe1);
		
		room2 = new Room(1);
		safe2 = new Safe();
		room2.setSafe(safe2);
	}
	
	// Checks in the guest into a free room if the password is correct
	//@ ensures (pass == getPassword().password && getFreeRoom() != null && getRoom(nameGuest) == null) ==> \result != null;
	/*@ pure */ public Room checkIn (String pass, String nameGuest)
	{
		if(hotel_password.testWord(pass) && getFreeRoom() != null &&
				getRoom(nameGuest) == null) {
			Guest guest = new Guest(nameGuest);
			getFreeRoom().setGuest(guest);
			return getRoom(nameGuest);
		} else {
			return null;
		}
	}
	
	// Checks out the guest from his room and deactivates the safe
	/*@ pure */ public void checkOut (String nameGuest)
	{
		if(getRoom(nameGuest) != null) {
			getRoom(nameGuest).getGuest().checkout();
			getRoom(nameGuest).getSafe().deactivate();
			getRoom(nameGuest).setGuest(null);
		}
	}
	
	// Find a free room
	//@ ensures (room1.getGuest() != null && room2.getGuest() != null) ==> \result == null;
	/*@ pure */ public Room getFreeRoom() {
		if(room1.getGuest() == null) {
			return room1;
		} else if (room2.getGuest() == null){
			return room2;
		} else {
			return null;
		}
	}
	
	// Get the room of a guest
	/*@ pure */ public Room getRoom (String nameGuest) {
		  if (room1.getGuest() != null && room1.getGuest().getName() == nameGuest){
			  return room1;
		  }
		  else if (room2.getGuest() != null && room2.getGuest().getName() == nameGuest){
			  return room2;
		  }
		  else return null;  
	}
	
	// Get the password of the hotel
	//@ requires hotel_password.password.length() >= 6 && !hotel_password.password.contains(" ");
	/*@ pure */ public Password getPassword () {
		return hotel_password;
	}
	
	
	// Display info about the hotel
	/*@ pure */ public String toString () {
		  if (room1.getGuest() != null && room2.getGuest() != null) {
			  return "Room " + room1.getNumber() + " contains " + room1.getGuest().getName() + " and the activation status of the safe is " + room1.getSafe().isActive()
					  + " and Room " + room2.getNumber() + " contains " + room2.getGuest().getName() + " and the activation status of the safe is " + room2.getSafe().isActive();
		  }
		  else if (room1.getGuest() != null && room2.getGuest() == null) {
			  return "Room " + room1.getNumber() + " contains " + room1.getGuest().getName() + " and the activation status of the safe is " + room1.getSafe().isActive();
		  }
		  else if (room1.getGuest() == null && room2.getGuest() != null) {
			  return "Room " + room2.getNumber() + " contains " + room2.getGuest().getName() + " and the activation status of the safe is " + room2.getSafe().isActive();
		  }
		  else{
			  return null;
		  }
	 }
	
}