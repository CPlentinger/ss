package ss.week2.hotel;

public class Safe {
		public boolean active = false;
		public boolean open = false;
		private Password password;
		/*
		 public static void main(String[] args) {
			 Safe Safe2;
			 Safe2 = new Safe();
			 Safe2.open(Password.INITIAL);
		 }
		*/
		/** Create's a new Safe */
		public Safe(){
			password = new Password();
		}
		
		/** Makes the safe active,
		 * only if it's inactive and the correct password is provided.
		 */
		//@ requires active == false;
		//@ requires this.getPassword().testWord(thePassword);
		//@ ensures active == true;
		public void activate (String thePassword) {
			assert !active;
			assert getPassword().testWord(thePassword);
			active = true;
			assert active;
		}
		
		/** Makes the safe inactive,
		 * only if it's active.
		 */
		//@ requires active == true;
		//@ ensures active == false;
		public void deactivate() {
			assert active;
			this.active = false;
			assert !active;
		}
		
		/** opens the safe,
		 * only if it's active and correct password is provided.
		 */
		//@ requires active == true && this.getPassword().testWord(thePassword);
		//@ requires open == false;
		//@ ensures open == true;
		public void open(String thePassword) {
			assert active;
			assert getPassword().testWord(thePassword);
			assert !open;
			open = true;
			assert open;
		}
		
		/** closes the safe,
		 * only if it's active.
		 */
		//@ requires open == true && active == true;
		//@ ensures open == false;
		public void close() {
			assert active;
			assert open;
			open = false;
			assert !open;
		}
		
		/** checks if the safe is active */
		//@ ensures \result == this.active;
		//@ pure;
		public boolean isActive() {
			boolean result;
			result = active;
			assert result == active;
			return result;
		}
		/** checks if the safe is open */
		//@ ensures \result == this.open;
		//@ pure;
		public boolean isOpen() {
			boolean result;
			result = open;
			assert result == open;
			return result;
		}
		
		/** provides the password of the safe */
		//@ pure;
		public Password getPassword () {
			return password;
		}
	
	}

