/**
 * 
 */
package code.panel.resources;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.util.Duration;

/**
 * Class creates a new waiting code panel (circle) that represents a thread object
 * 
 * @author Satpal Singh
 * @version 1.0
 */
public class WaitingCodePanelObject extends CodePanelObject{
	
	//PathTansition variables to be used to define the path animation
	private PathTransition pathTransitionUseJunction;
	private PathTransition pathTransitionUse;
	private PathTransition pathTransitionWaiting;
	private PathTransition pathTransitionWaitSync;
	private PathTransition pathTransitionFromWaitingToSync;
	private PathTransition pathTransitionSetBusyTrue;
	private PathTransition pathTransitionSetBusyFalse;
	private PathTransition pathTransitionCritical;
	private PathTransition pathTransitionEnd;

	/**
	 * Creates new instance of WaitingCodePanelObject with specified x, y coordinates and radius
	 * @param double centerX - the centre x coordinate for the circle
	 * @param double centerY - the centre Y coordinate for the circle
	 * @param double radius - the radius for the circle
	 */
	public WaitingCodePanelObject(double centerX, double centerY, double radius) {
		super(centerX, centerY, radius);
	}

	/**
	 * Creates and plays the path animation to use statement in run method
	 * @param double delay - property to delay the start of the animation in seconds
	 */
	public void moveToRunwayUse(double delay) {
		pathTransitionUseJunction = codeAnimation.animateToRunwayUse_WS(this);
		pathTransitionUseJunction.setDelay(Duration.seconds(delay));
		pathTransitionUseJunction.play();

	}

	/**
	 * Creates and plays the path animation to useRunway method
	 * @param double delay - property to delay the start of the animation in seconds
	 */
	public void moveToUseRunwayMethod(double delay) {
		pathTransitionUse = codeAnimation.animateToUseRunway_WS(this);
		pathTransitionUse.setDelay(Duration.seconds(delay));
		pathTransitionUse.play();
	}
	
	/**
	 * Creates and plays the path animation to wait sync block in useRunway method
	 * @param double delay - property to delay the start of the animation in seconds
	 */
	public void moveFromUseToWaitSync(double delay) {
		pathTransitionWaitSync = codeAnimation.animateToWaitSync_WS(this);
		pathTransitionWaitSync.setDelay(Duration.seconds(delay));
		pathTransitionWaitSync.play();
	}

	/**
	 * Creates and plays the path animation to wait statement in useRunway method
	 * @param double delay - property to delay the start of the animation in seconds
	 */
	public void animateToWait(double delay) {
		pathTransitionWaiting = codeAnimation.animateToWait_WS(this);
		pathTransitionWaiting.setDelay(Duration.seconds(delay));
			pathTransitionWaiting.play();
	}
	
	/**
	 * Creates and plays the path animation to setBusy statement in useRunway method
	 * @param double delay - property to delay the start of the animation in seconds
	 */
	public void animateFromWaitingToSetBusy(double delay) {
		pathTransitionFromWaitingToSync = codeAnimation.animateFromWaitToSetBusyTrue_WS(this);
		pathTransitionFromWaitingToSync.setDelay(Duration.seconds(delay));
		pathTransitionFromWaitingToSync.play();
	}

	/**
	 * Creates and plays the path animation to setBusy(true) statement in useRunway method
	 * @param double delay - property to delay the start of the animation in seconds
	 */
	public void animateToSetBusyTrue(double delay) {
		pathTransitionSetBusyTrue = codeAnimation.animateToSetBusyTrue_WS(this);
		pathTransitionSetBusyTrue.setDelay(Duration.seconds(delay));
			pathTransitionSetBusyTrue.play();
	}
	
	/**
	 * Creates and plays the path animation to setBusy(false) statement in useRunway method
	 * @param double delay - property to delay the start of the animation in seconds
	 */
	public void animateToSetBusyFalse(double delay) {
		pathTransitionSetBusyFalse = codeAnimation.animateToSetBusyFalse_WS(this);
		pathTransitionSetBusyFalse.setDelay(Duration.seconds(delay));
		pathTransitionSetBusyFalse.play();
	}

	/**
	 * Creates and plays the path animation to critical section in useRunway method
	 * @param double delay - property to delay the start of the animation in seconds
	 */
	public void animateToCritical(double delay) {
		pathTransitionCritical = codeAnimation.animateToCriticalSection_WS(this);
		pathTransitionCritical.setDelay(Duration.seconds(delay));
		pathTransitionCritical.play();

	}

	/**
	 * Creates and plays the path animation to the end of run method
	 * @param double delay - property to delay the start of the animation in seconds
	 */
	public void animateToEndRun(double delay) {
		pathTransitionEnd = codeAnimation.animateToEndRun_WS(this);
		pathTransitionEnd.setDelay(Duration.seconds(delay));
		pathTransitionEnd.play();

	}

	/* (non-Javadoc)
	 * @see code.panel.resources.CodePanelObject#pause()
	 */
	@Override
	public void pause() {
		if (pathTransitionUseJunction != null)
			pathTransitionUseJunction.pause();
		if (pathTransitionUse != null)
			pathTransitionUse.pause();
		if (pathTransitionWaiting != null)
			pathTransitionWaiting.pause();
		if (pathTransitionFromWaitingToSync != null)
			pathTransitionFromWaitingToSync.pause();
		if (pathTransitionSetBusyTrue != null)
			pathTransitionSetBusyTrue.pause();
		if (pathTransitionCritical != null)
			pathTransitionCritical.pause();
		if (pathTransitionEnd != null)
			pathTransitionEnd.pause();
		if (pathTransitionSetBusyFalse != null)
			pathTransitionSetBusyFalse.pause();
	}

	/* (non-Javadoc)
	 * @see code.panel.resources.CodePanelObject#play()
	 */
	@Override
	public void play() {
		if (pathTransitionUseJunction != null && pathTransitionUseJunction.getStatus()==Animation.Status.PAUSED)
			pathTransitionUseJunction.play();
		if (pathTransitionUse != null && pathTransitionUse.getStatus()==Animation.Status.PAUSED)
			pathTransitionUse.play();
		if (pathTransitionWaiting != null && pathTransitionWaiting.getStatus()==Animation.Status.PAUSED)
			pathTransitionWaiting.play();
		if (pathTransitionFromWaitingToSync != null && pathTransitionFromWaitingToSync.getStatus()==Animation.Status.PAUSED)
			pathTransitionFromWaitingToSync.play();
		if (pathTransitionCritical != null && pathTransitionCritical.getStatus()==Animation.Status.PAUSED)
			pathTransitionCritical.play();
		if (pathTransitionSetBusyTrue != null && pathTransitionSetBusyTrue.getStatus()==Animation.Status.PAUSED)
			pathTransitionSetBusyTrue.play();
		if (pathTransitionEnd != null && pathTransitionEnd.getStatus()==Animation.Status.PAUSED)
			pathTransitionEnd.play();
		if (pathTransitionSetBusyFalse != null && pathTransitionSetBusyFalse.getStatus()==Animation.Status.PAUSED)
			pathTransitionSetBusyFalse.play();
	}


	/* (non-Javadoc)
	 * @see code.panel.resources.CodePanelObject#stop()
	 */
	@Override
	public void stop() {
		if (pathTransitionUseJunction != null)
			pathTransitionUseJunction.stop();
		if (pathTransitionUse != null)
			pathTransitionUse.stop();
		if (pathTransitionWaiting != null)
			pathTransitionWaiting.stop();
		if (pathTransitionFromWaitingToSync != null)
			pathTransitionFromWaitingToSync.stop();
		if (pathTransitionSetBusyTrue != null)
			pathTransitionSetBusyTrue.stop();
		if (pathTransitionCritical != null)
			pathTransitionCritical.stop();
		if (pathTransitionEnd != null)
			pathTransitionEnd.stop();
		if (pathTransitionSetBusyFalse != null)
			pathTransitionSetBusyFalse.stop();
	}

	
}
