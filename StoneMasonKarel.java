/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {

	// You fill in this part
	/*precondition-karel is at the corner of the intersection
	 * (1,1) and is facing east
	 *postcondition-karel is at the corner of the intersection
	 *(13,1), is facing east and all columns are fixed
	 *in order to avoid the fencepost error the methods 
	 *karelChecksColumn and KarelDoubleChecksColumn are added 
	 *at the end of the run method,outside of the while loop
	 */
	public void run() {
		while(frontIsClear()) {
			karelChecksColumn();
			karelDoubleChecksColumn();
			karelGoesToNextColumn();
		}
		karelChecksColumn();
		karelDoubleChecksColumn();
	}
	/*precondition-karel is facing East and is at the base of a
	 * column
	 *postcondition-karel has repaired the single column and is
	 *at the top of the column facing north
	 */
	private void karelChecksColumn() {
		turnLeft();
		karelRepairsSingleColumn();
	}
	/*precondition-karel is at the top of the column, and is 
	 * facing north
	 *postcondition-karel has returned to the base of the 
	 *column and is once again facing east
	 */
	private void karelDoubleChecksColumn() {
		turnAround();
		karelRepairsSingleColumn();
		turnLeft();
	}
	/*precondition-karel is facing north or south at the top or
	 * base of a column
	 *postcondition-karel has fixed the column and placed all
	 *beepers where needed
	 */
	private void karelRepairsSingleColumn() {
		while (frontIsClear()) {
			if (beepersPresent()) {
				move();
			}
			if (noBeepersPresent()) {
				putBeeper();
			}
		}
	}
	/*precondition-karel has fixed a column, has returned to the
	 * base of a column and is facing east
	 *postcondition-karel has moved exactly 4 spaces to the right
	 *it is at the base of a column and is facing east
	 */
	private void karelGoesToNextColumn() {
		for (int i=0; i<4; i++) {
			move();
		}
	}

}
