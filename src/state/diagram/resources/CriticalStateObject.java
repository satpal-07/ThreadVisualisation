/**
 * 
 */
package state.diagram.resources;

import javafx.util.Duration;
import thread.ThreadState;

/**
 * Class creates a CircleObject specifically for Critical section state diagrams
 * 
 * @author Satpal Singh
 * @version 1.0
 */
public class CriticalStateObject extends StateObject {

	
	/**
	 * Creates a new instance of CriticalStateObject with specified parameters
	 * @param centerX - {@link javafx.scene.shape.Circle#centerXProperty()}
	 * @param centerY - {@link javafx.scene.shape.Circle#centerYProperty()}
	 * @param height - property used to calculation the Y position of the circle in state diagram
	 * @param width - property used to calculation the X position of the circle in state diagram
	 * @param displayText - the text associated with the object
	 */
	public CriticalStateObject(double centerX, double centerY, double height, double width,
			StateDiagramText displayText) {
		super(centerX, centerY, height, width, displayText);
	}

	/* (non-Javadoc)
	 * @see state.diagram.resources.StateObject#moveFromNewToWaiting()
	 */
	@Override
	public void moveFromNewToWaiting(double delay) {
		assert state == ThreadState.NEW;
		state = ThreadState.WAITING;
		moveFromNewToWaitingPT = StateAnimation.moveFromNewToWaiting_CS(this, waitingCenterX, waitingCenterY,
				screenWidth, screenHeight, 8);
		//moveFromNewToWaitingPT.setDelay(Duration.seconds(1));
		moveFromNewToWaitingPT.setDelay(Duration.seconds(delay));
		moveFromNewToWaitingPT.play();
		
	}
	
	/* (non-Javadoc)
	 * @see state.diagram.resources.StateObject#moveFromWaitingToRunning(double)
	 */
	@Override
	public void moveFromWaitingToRunning(double delay) {
		assert state == ThreadState.WAITING;
		state = ThreadState.RUNNING;
		moveFromWaitingToRunningPT = StateAnimation.moveFromWaitingToRunning_CS(this, waitingCenterX, waitingCenterY,
				screenWidth, screenHeight);
		displayText.changeText(delay);
		displayText.setVisible(true, delay);
		moveFromWaitingToRunningPT.setDelay(Duration.seconds(delay));
		moveFromWaitingToRunningPT.setOnFinished(e -> {
			displayText.changeText(0.1);
			displayText.setVisible(true, 0.1);
			moveFromRunningToCritical(delay);
		});
		moveFromWaitingToRunningPT.play();
}

	/* (non-Javadoc)
	 * @see state.diagram.resources.StateObject#moveFromRunningToTerminated()
	 */
	@Override
	public void moveFromRunningToTerminated(double delay) {
		assert state == ThreadState.RUNNING;
		state = ThreadState.TERMINATED;
		displayText.changeText(delay);
		displayText.setVisible(true, delay);
		moveFromRunningToTerminatedPT = StateAnimation.moveFromRunningToTerminate_CS(this, terminatedCenterX,
				terminatedCenterY, screenWidth, screenHeight);
		moveFromRunningToTerminatedPT.setDelay(Duration.seconds(delay));
		moveFromRunningToTerminatedPT.play();
		if (threadNumber == 3)
			moveFromRunningToTerminatedPT.setOnFinished(e -> displayText.setVisible(false, 0.1));
		
	}


}
