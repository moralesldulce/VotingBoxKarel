import stanford.karel.SuperKarel;

public class VotingBox extends SuperKarel {

	// You fill in this part
	/*precondition- Karel is facing East and standing at
	 * the center of the ballot rectangle, giving it 
	 * access to the voting area along the center
	 * postcondition- Karel must be facing East, at the end
	 * of the ballot card  
	 */
	public void run() {
		while (frontIsClear()) {
			moveToPunchArea();
			inspectPunchArea();
			skipCenterBeeper();
			}
		}
	/*precondition- since this method is called for in the run
	 * method, which uses a while loop, an if loop is used in  
	 *this method so that karel knows to stop at the end of 
	 *the ballot
	 *postcondition-karel must stop at the end of the ballot 
	 */
	private void moveToPunchArea() {
		if (frontIsClear()) {
			move();
		}
	}
	/*precondition-if there is a beeper present in the center of
	 * the voting rectangle karel should recognize it and skip 
	 * over this rectangle
	 * postcondition-karel is able to recognize when to skip over
	 * a voting rectangle that the voter did not interact with
	 */
	private void skipCenterBeeper() {
		if (beepersPresent()) {
			move();
		}
	}
	/*precondition-the center of the voting rectangle is clear,
	 * karel recognizes this int the inspectPunchArea() method
	 * and proceeds to inspect the top + bottom area of the 
	 * voting rectangle
	 * postcondition-if there is a stray chad/beeper present
	 * karel will pick up the beeper so that the vote can be
	 * counted
	 */
	private void ClearOutStrayChads() {
		while(beepersPresent ()) {
			pickBeeper();
		}
	}
	/*precondition- the center of the voting rectangle is clear
	 * therefore karel will go on to inspect the top and bottom
	 * of this rectangle
	 * postcondition- karel is once again at the center voting
	 * rectangle facing East
	 */
	private void inspectPunchArea() {
		if (noBeepersPresent()) {
			inspectTopArea();
			ClearOutStrayChads();
			inspsectBottomArea();
			ClearOutStrayChads();
			KarelReturnsToOriginalStance();
		}
	}
	/*precondition- karel is facing east and at the center voting
	 * area of the voting rectangle
	 *postcondition- karel is no facing north and at the top of the
	 *voting rectangle area
	 */
	private void inspectTopArea() {
		turnLeft();
		if (frontIsClear()) {
			move();
		}
	}
	/*precondition- karel is now facing north and at the top of the
	 * voting rectangle
	 * postcondition- karel is at the bottom of the voting rectangle
	 * and is facing south
	 */
	private void inspsectBottomArea() {
		turnAround();
		if (frontIsClear()) {
			move();
			move();
		}
	}
	/*precondition- karel is facing south at the bottom of the
	 * voting rectangle
	 * postcondition- karel is now back at the center of the 
	 * voting rectangle and is facing East
	 */
	private void KarelReturnsToOriginalStance() {
		turnAround();
		move();
		turnRight();
		move();
	}
}
