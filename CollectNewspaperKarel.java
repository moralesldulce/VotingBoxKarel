/*
 * File: CollectNewspaperKarel.java
 * --------------------------------
 * At present, the CollectNewspaperKarel subclass does nothing.
 * Your job in the assignment is to add the necessary code to
 * instruct Karel to walk to the door of its house, pick up the
 * newspaper (represented by a beeper, of course), and then return
 * to its initial position in the upper left corner of the house.
 */

import stanford.karel.*;

public class CollectNewspaperKarel extends SuperKarel {

	// You fill in this part
	/*precondition-karel is facing east at the top left corner
	 * of it's house
	 *postcondition-karel returns to it's original state of 
	 *facing east at the top left corner of it's house
	 */
	public void run () {
		karelGoesToTheDoor();
		karelGoesOutside();
		karelReturnsHome();
	}
	/*precondition-karel is positioned at the top left corner of
	 * it's house facing east
	 *postcondition-karel is now at the front door of it's house
	 *facing east but still inside of the house
	 */
	private void karelGoesToTheDoor() {
		while (frontIsClear()) {
			move();
		}
		turnRight();
		move();
		turnLeft();
	}
	/*precondition-karel is facing east at the frontdoor of
	 * it's house
	 *postcondition-karel has steped out to the front of the house
	 *and has picked up the newspaper
	 */
	private void karelGoesOutside() {
		move();
		if(beepersPresent()) {
			pickBeeper();
		}
	}
	/*precondition-karel is one corner in front of it's house and 
	 * has picked up the newspaper, karel is facing east
	 *postcondition-karel has returned to it's original state
	 *and is once again facing east at the top left corner of it's 
	 *house
	 */
	private void karelReturnsHome() {
		turnAround();
		karelGoesToTheDoor();
		turnAround();
	}
}


