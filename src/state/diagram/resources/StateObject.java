package state.diagram.resources;

import java.util.ArrayList;

import gui.ScreenSelection;
import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.util.Duration;
import thread.ThreadState;

/**
 * Abstract class models a generic state diagram's object which represents the thread
 * 
 * @author Satpal Singh
 * @version 1.0
 */
public abstract class StateObject extends CircleObject {

	//radius calculated based on the state diagram height
	protected static double RADIUS = 0.0234285 * ScreenSelection.STATE_SEQUENCE_HEIGHT;
	//positions of the object
	protected double waitingCenterX;
	protected double waitingCenterY;
	protected double terminatedCenterX;
	protected double terminatedCenterY;
	//thread state
	protected ThreadState state;
	protected boolean firstInstance;
	protected double screenHeight;
	protected double screenWidth;
	protected int threadNumber;
	//text associated with the object
	protected StateDiagramText displayText;

	//path transitions
	protected PathTransition moveFromNewToRunningPT;
	protected PathTransition moveFromRunningToCriticalPT;
	protected PathTransition moveFromNewToWaitingPT;
	protected PathTransition moveFromWaitingToRunningPT;
	protected PathTransition moveFromRunningToTerminatedPT;
	protected PathTransition moveFromCriticalToRunningPT;
	protected ArrayList<PathTransition> animationList;

	/**
	 * Creates a new instance of StateObject object with specified coordinates, width and height
	 * @param centerX - {@link javafx.scene.shape.Circle#centerXProperty()}
	 * @param centerY - {@link javafx.scene.shape.Circle#centerYProperty()}
	 * @param height - property used to calculation the Y position of the circle in state diagram
	 * @param width - property used to calculation the X position of the circle in state diagram
	 * @param displayText - the text associated with the object
	 */
	public StateObject(double centerX, double centerY, double height, double width,
			StateDiagramText displayText) {
		super(centerX, centerY, RADIUS);
		state = ThreadState.NEW;
		screenHeight = height;
		screenWidth = width;
		this.displayText = displayText;
		waitingCenterX = 0.621 * width;
		waitingCenterY = 0.028 * height;
		terminatedCenterX = 0.621 * width;
		terminatedCenterY = 0.583 * height;
		threadNumber = NUMBER;
		//check if the object is the very first instance
		//used to assign to first thread
		if (NUMBER == 1) {
			firstInstance = true;
		} else {
			firstInstance = false;
		}
		animationList = new ArrayList<PathTransition>();
	}

	/**
	 * Gets the value of the first instance
	 * @return True if the object if the first instance else false
	 */
	public boolean isFirstInstance() {
		return firstInstance;
	}

	

	/**
	 * Creates and plays the state diagram animation from new to running  and delays the start with given property
	 * @param delay - delays the start of the animation
	 */
	public void moveFromNewToRunning(double delay) {
		assert state == ThreadState.NEW;
		state = ThreadState.RUNNING;
		moveFromNewToRunningPT = StateAnimation.moveFromNewToRunning_CS(this, screenWidth, screenHeight);
		moveFromNewToRunningPT.setDelay(Duration.seconds(delay));
		animationList.add(moveFromCriticalToRunningPT);
		displayText.changeText(delay);
		displayText.setVisible(true, delay);
		moveFromNewToRunningPT.setOnFinished(e -> {
			displayText.changeText(0.1);
			displayText.setVisible(true, 0.1);
			moveFromRunningToCritical(delay);
		});
		moveFromNewToRunningPT.play();
	}

	/**
	 * Creates and plays the state diagram animation from running to critical  and delays the start with given property
	 * @param delay - delays the start of the animation
	 */
	public void moveFromRunningToCritical(double delay) {
		state = ThreadState.RUNNING;
		moveFromRunningToCriticalPT = StateAnimation.moveFromRunningToCritical_CS(this, screenWidth, screenHeight);
		animationList.add(moveFromRunningToCriticalPT);
		moveFromRunningToCriticalPT.setOnFinished(e -> {
			moveFromCriticalToRunning(delay);
		});
		moveFromRunningToCriticalPT.play();
	}

	/**
	 * Creates and plays the state diagram animation from critical to running  and delays the start with given property
	 * @param delay - delays the start of the animation
	 */
	public void moveFromCriticalToRunning(double delay) {
		state = ThreadState.RUNNING;
		moveFromCriticalToRunningPT = StateAnimation.moveFromCriticalToRunning(this, screenWidth, screenHeight);
		animationList.add(moveFromCriticalToRunningPT);
		moveFromCriticalToRunningPT.play();
	}

	/**
	 * Creates and plays the state diagram animation from new to waiting and delays the start with given property
	 * @param delay - delays the start of the animation
	 */
	public abstract void moveFromNewToWaiting(double delay);

	/**
	 * Creates and plays the state diagram animation that moves to running either from waiting or new state and delays the start with given property
	 * @param delay - delays the start of the animation
	 */
	public void moveToRunning(double delay) {
		if (firstInstance && state == ThreadState.NEW) {
			moveFromNewToRunning(delay);
		} else if (state == ThreadState.WAITING) {
			moveFromWaitingToRunning(delay);
		}
	}

	/**
	 * Creates and plays the state diagram animation from waiting to running state and delays the start with given property
	 * @param delay - delays the start of the animation
	 */
	public abstract void moveFromWaitingToRunning(double delay);


	/**
	 * Creates and plays the state diagram animation from running to terminate state and delays the start with given property
	 * @param delay - delays the start of the animation
	 */
	public abstract void moveFromRunningToTerminated(double delay);
	
	/**
	 * Gets the number of the thread
	 * @return int - the threadNumber property 
	 */
	public int getNumber() {
		return threadNumber;
	}

	/**
	 * Gets the state of the thread
	 * @return ThreadState which could be new, running, waiting and terminated
	 */
	public ThreadState getState() {
		return state;
	}

	/**
	 * Pauses the applied and playing animation
	 */
	public void pause() {
		if (moveFromNewToRunningPT != null)
			moveFromNewToRunningPT.pause();
		if (moveFromRunningToCriticalPT != null)
			moveFromRunningToCriticalPT.pause();
		if (moveFromNewToWaitingPT != null)
			moveFromNewToWaitingPT.pause();
		if (moveFromWaitingToRunningPT != null)
			moveFromWaitingToRunningPT.pause();
		if (moveFromRunningToTerminatedPT != null)
			moveFromRunningToTerminatedPT.pause();
		if (moveFromCriticalToRunningPT != null)
			moveFromCriticalToRunningPT.pause();
		if (StateAnimation.lineTransition != null)
			StateAnimation.lineTransition.pause();

	}

	/**
	 * plays the animation paused
	 */
	public void play() {
		if (moveFromNewToRunningPT != null && moveFromNewToRunningPT.getStatus() == Animation.Status.PAUSED)
			moveFromNewToRunningPT.play();
		if (moveFromRunningToCriticalPT != null && moveFromRunningToCriticalPT.getStatus() == Animation.Status.PAUSED)
			moveFromRunningToCriticalPT.play();
		if (moveFromNewToWaitingPT != null && moveFromNewToWaitingPT.getStatus() == Animation.Status.PAUSED)
			moveFromNewToWaitingPT.play();
		if (moveFromWaitingToRunningPT != null && moveFromWaitingToRunningPT.getStatus() == Animation.Status.PAUSED)
			moveFromWaitingToRunningPT.play();
		if (moveFromRunningToTerminatedPT != null
				&& moveFromRunningToTerminatedPT.getStatus() == Animation.Status.PAUSED)
			moveFromRunningToTerminatedPT.play();
		if (moveFromCriticalToRunningPT != null && moveFromCriticalToRunningPT.getStatus() == Animation.Status.PAUSED)
			moveFromCriticalToRunningPT.play();
		if (StateAnimation.lineTransition != null
				&& StateAnimation.lineTransition.getStatus() == Animation.Status.PAUSED)
			StateAnimation.lineTransition.play();
	}
	
	/**
	 * stops the applied and playing animation
	 */
	public void stop() {
		if (moveFromNewToRunningPT != null)
			moveFromNewToRunningPT.stop();
		if (moveFromRunningToCriticalPT != null)
			moveFromRunningToCriticalPT.stop();
		if (moveFromNewToWaitingPT != null)
			moveFromNewToWaitingPT.stop();
		if (moveFromWaitingToRunningPT != null)
			moveFromWaitingToRunningPT.stop();
		if (moveFromRunningToTerminatedPT != null)
			moveFromRunningToTerminatedPT.stop();
		if (moveFromCriticalToRunningPT != null)
			moveFromCriticalToRunningPT.stop();
		if (StateAnimation.lineTransition != null)
			StateAnimation.lineTransition.stop();

	}

}
