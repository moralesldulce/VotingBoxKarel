/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	// You fill in this part
	public void run() {
		while(frontIsClear()) {
			putOneRowOfBeepers();
			if (frontIsBlocked()) {
				doubleCheckBeepers();
			}
			oddRow();
			turnRight();
		}
		//oddRow();
		//evenRow();
		//if (leftIsClear() && rightIsBlocked()) {
			//placeBeepersBottomToTop();
		//}
	}
	private void putOneRowOfBeepers() {
		while (facingEast()) {
			putBeeper();
			move();
			if (frontIsClear()) {
				move();
			}
			//if (frontIsBlocked()) {
				//turnAround();
			//}
		}	
	}
	private void doubleCheckBeepers() {
		if (frontIsBlocked()) {
			turnAround();
			if (frontIsClear()) {
				move();
			}
			if (beepersPresent()) {
				move();
				move();
			//nextRow();
			}
		}
	}
	private void oddRow() {
		if (frontIsBlocked() && beepersPresent()) {
			turnRight();
				move();
				turnRight();
				move();
		}
	}
	//private void evenRow() {
		//if (frontIsBlocked() && noBeepersPresent()) {
			//turnRight();
			//move();
			//putBeeper();
			//turnRight();
		//}
	//}
	//private void placeBeepersBottomToTop() {
		//turnLeft();	
		//while (frontIsClear()) {
			//	putBeeper();
				//move();
				//if (frontIsClear()) {
					//move();
				//}
			//}
	//}

}
