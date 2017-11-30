/**
 * 
 */
package state.diagram.resources;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.util.Duration;
import thread.ThreadState;

/**
 * Class creates a CircleObject specifically for waiting section state diagrams
 * 
 * @author Satpal Singh
 * @version 1.0
 */
public class WaitingStateObject extends StateObject {

	//additional path transition required for the wait-notify scenario
	private PathTransition waitingCSToWaitingConditionPT;
	private PathTransition waitingConditionToWaitingCSPT;
	private PathTransition moveFromCriticalToTerminated;

	/**
	 * Creates a new instance of WaitingStateObject with specified parameters
	 * @param centerX - {@link javafx.scene.shape.Circle#centerXProperty()}
	 * @param centerY - {@link javafx.scene.shape.Circle#centerYProperty()}
	 * @param height - property used to calculation the Y position of the circle in state diagram
	 * @param width - property used to calculation the X position of the circle in state diagram
	 * @param displayText - the text associated with the object
	 */
	public WaitingStateObject(double centerX, double centerY, double height, double width,
			StateDiagramText displayText) {
		super(centerX, centerY, height, width, displayText);
	}

	/* (non-Javadoc)
	 * @see state.diagram.resources.StateObject#moveFromWaitingToRunning(double)
	 */
	@Override
	public void moveFromWaitingToRunning(double delay) {
		//assert state == ThreadState.WAITING;
		state = ThreadState.RUNNING;
		moveFromWaitingToRunningPT = StateAnimation.moveFromWaitingCriticalToRunning_WS(this, waitingCenterX,
				waitingCenterY, screenWidth, screenHeight);
		moveFromWaitingToRunningPT.setDelay(Duration.seconds(delay));
		displayText.changeText(delay+1);
		displayText.setVisible(true, delay+1);
		moveFromWaitingToRunningPT.setOnFinished(e -> {
			moveFromCriticalToRunning(0);
			displayText.changeText(0.1);
			displayText.setVisible(true, 0.1);
			});
		moveFromWaitingToRunningPT.play();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see state.diagram.resources.StateObject#moveFromNewToWaiting()
	 */
	@Override
	public void moveFromNewToWaiting(double delay) {
		state = ThreadState.WAITING;
		moveFromNewToWaitingPT = StateAnimation.moveFromNewToWaiting_CS(this, waitingCenterX, waitingCenterY,
				screenWidth, screenHeight, 6);
		// moveFromNewToWaitingPT.setDelay(Duration.seconds(1));
		moveFromNewToWaitingPT.setDelay(Duration.seconds(delay));
		moveFromNewToWaitingPT.setOnFinished(e -> waitingCriticalSectionToWaitingCondition());
		moveFromNewToWaitingPT.play();
	}

	/**
	 * Creates and plays the state diagram animation from waiting for critical state to waiting condition and delays the start with given property
	 * @param delay - delays the start of the animation
	 */
	public void waitingCriticalSectionToWaitingCondition() {
		waitingCSToWaitingConditionPT = StateAnimation.moveFromWaitingCriticalToWaitingCondition_WS(this,
				waitingCenterX, waitingCenterY, screenWidth, screenHeight);
		waitingCSToWaitingConditionPT.play();
	}

	/**
	 * Creates and plays the state diagram animation from waiting condition to waiting for critical state and delays the start with given property
	 * @param delay - delays the start of the animation
	 */
	public void waitingConditionToWaitingCriticalSection(double delay) {
		waitingConditionToWaitingCSPT = StateAnimation.moveFromWaitingConditionToWaitingCritical_WS(this,
				waitingCenterX, waitingCenterY, screenWidth, screenHeight);
		waitingConditionToWaitingCSPT.setDelay(Duration.seconds(delay));
		waitingConditionToWaitingCSPT.setOnFinished(e -> moveFromWaitingToRunning(2));
		waitingConditionToWaitingCSPT.play();
	}

	/* (non-Javadoc)
	 * @see state.diagram.resources.StateObject#moveToRunning(double)
	 */
	@Override
	public void moveToRunning(double delay) {
		if (firstInstance && state == ThreadState.NEW) {
			moveFromNewToRunning(delay);
		} else if (state == ThreadState.WAITING) {
			waitingConditionToWaitingCriticalSection(delay);
		}
	}

	/**
	 * Creates and plays the state diagram animation from new to running state and delays the start with given property
	 * @param delay - delays the start of the animation
	 */
	public void moveFromNewToRunning(double delay) {
		assert state == ThreadState.NEW;
		state = ThreadState.RUNNING;
		moveFromNewToRunningPT = StateAnimation.moveFromNewToRunning_WS(this, screenWidth, screenHeight);
		moveFromNewToRunningPT.setDelay(Duration.seconds(delay));
		displayText.changeText(delay);
		displayText.setVisible(true, delay);
		moveFromNewToRunningPT.play();
		moveFromNewToRunningPT.setOnFinished(e -> {
			displayText.changeText(0.1);
			displayText.setVisible(true, 0.1);
			moveFromRunningToCritical(delay);
		});
	}

	/**
	 * Creates and plays the state diagram animation from running to critical section and delays the start with given property
	 * @param delay - delays the start of the animation
	 */
	public void moveFromRunningToCritical(double delay) {
		state = ThreadState.RUNNING;
		moveFromRunningToCriticalPT = StateAnimation.moveFromRunningToCritical_WS(this, screenWidth, screenHeight);
		moveFromRunningToCriticalPT.setOnFinished(e -> {
			moveFromCriticalToRunning(delay);
		});
		moveFromRunningToCriticalPT.play();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see state.diagram.resources.StateObject#moveFromRunningToTerminated()
	 */
	@Override
	public void moveFromRunningToTerminated(double delay) {
		state = ThreadState.TERMINATED;
		moveFromRunningToTerminatedPT = StateAnimation.moveFromRunningToCritical_WS(this, terminatedCenterX,
				terminatedCenterY, screenWidth, screenHeight);
		displayText.setVisible(true, delay);
		displayText.changeText(delay);
		moveFromRunningToTerminatedPT.setDelay(Duration.seconds(delay));
		moveFromRunningToTerminatedPT.setOnFinished(e -> {
			moveFromCriticalToTerminated(5);
			displayText.setVisible(true, 0.1);
			displayText.changeText(0.1);
		});
		moveFromRunningToTerminatedPT.play();

	}


	/**
	 * Creates and plays the state diagram animation from critical to terminate state and delays the start with given property
	 * @param delay - delays the start of the animation
	 */
	public void moveFromCriticalToTerminated(double delay) {
		assert state == ThreadState.RUNNING;
		state = ThreadState.TERMINATED;
		moveFromCriticalToTerminated = StateAnimation.moveFromCriticalToTerminated_WS(this, terminatedCenterX,
				terminatedCenterY, screenWidth, screenHeight);
		displayText.setVisible(true, delay);
		displayText.changeText(delay);
		moveFromCriticalToTerminated.setDelay(Duration.seconds(delay));
		moveFromCriticalToTerminated.play();
		 if (threadNumber == 2)
			 moveFromCriticalToTerminated.setOnFinished(e -> displayText.setVisible(false, 0.1));

	}

	/* (non-Javadoc)
	 * @see state.diagram.resources.StateObject#pause()
	 */
	@Override
	public void pause() {
		super.pause();
		if (waitingCSToWaitingConditionPT != null)
			waitingCSToWaitingConditionPT.pause();
		if (moveFromCriticalToTerminated != null)
			moveFromCriticalToTerminated.pause();
		if (waitingConditionToWaitingCSPT != null)
			waitingConditionToWaitingCSPT.pause();
	}

	/* (non-Javadoc)
	 * @see state.diagram.resources.StateObject#play()
	 */
	@Override
	public void play() {
		super.play();
		if (waitingCSToWaitingConditionPT != null
				&& waitingCSToWaitingConditionPT.getStatus() == Animation.Status.PAUSED)
			waitingCSToWaitingConditionPT.play();
		if (moveFromCriticalToTerminated != null && moveFromCriticalToTerminated.getStatus() == Animation.Status.PAUSED)
			moveFromCriticalToTerminated.play();
		if (waitingConditionToWaitingCSPT != null
				&& waitingConditionToWaitingCSPT.getStatus() == Animation.Status.PAUSED)
			waitingConditionToWaitingCSPT.play();
	}

	/* (non-Javadoc)
	 * @see state.diagram.resources.StateObject#stop()
	 */
	@Override
	public void stop() {
		super.stop();
		if (waitingCSToWaitingConditionPT != null)
			waitingCSToWaitingConditionPT.stop();
		if (moveFromCriticalToTerminated != null)
			moveFromCriticalToTerminated.stop();
		if (waitingConditionToWaitingCSPT != null)
			waitingConditionToWaitingCSPT.stop();
	}

}
