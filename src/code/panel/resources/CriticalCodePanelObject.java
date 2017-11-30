/**
 * 
 */
package code.panel.resources;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.util.Duration;

/**
 * Class creates a new critical code panel (circle) that represents a thread object
 * 
 * @author Satpal Singh
 * @version 1.0
 */
public class CriticalCodePanelObject extends CodePanelObject {
	
	//PathTansition variables to be used to define the path animation
	private PathTransition pathTransitionUseJunction;
	private PathTransition pathTransitionUse;
	private PathTransition pathTransitionSync;
	private PathTransition pathTransitionCritical;
	private PathTransition pathTransitionUseEnd;
	private PathTransition pathTransitionRunEnd;
	
	/**
	 * Creates new instance of CriticalCodePanelObject with specified x, y coordinates and radius
	 * @param double centerX - the centre x coordinate for the circle
	 * @param double centerY - the centre Y coordinate for the circle
	 * @param double radius - the radius for the circle
	 */
	public CriticalCodePanelObject(double centerX, double centerY, double radius) {
		super(centerX, centerY, radius);
	}
	
	
	/**
	 * Creates and plays the path animation to use junction method
	 * and calls the sequential animations to move the object to the sync block
	 * @param double delay - property to delay the start of the animation in seconds
	 */
	public void moveToUseJunction(double delay) {
		pathTransitionUseJunction = codeAnimation.animateToUseJunction_CS(this);
		pathTransitionUseJunction.setDelay(Duration.seconds(delay));
		pathTransitionUseJunction.play();
		moveToUse();
		moveToSync();
	}

	/**
	 * Creates and plays the path animation to use use method
	 */
	public void moveToUse() {
		pathTransitionUse = codeAnimation.animateToUse_CS(this);
		pathTransitionUse.setOnFinished(e -> moveToSync());
		pathTransitionUseJunction.setOnFinished(e -> {
			pathTransitionUse.play();
		});
	}

	/**
	 * Creates and plays the path animation to sync block in useJunction method
	 */
	public void moveToSync() {
		pathTransitionSync = codeAnimation.animateToSync_CS(this);
		pathTransitionUse.setOnFinished(e -> {
			pathTransitionSync.play();
		});
	}

	/**
	 * Creates and plays the path animation to critical section in use junction method
	 * @param double delay - property to delay the start of the animation in seconds
	 */
	public void moveToCritical(double delay) {
		pathTransitionCritical = codeAnimation.animateToCritical_CS(this);
		pathTransitionCritical.setDelay(Duration.seconds(delay));
		pathTransitionCritical.play();
	}

	/**
	 * Creates and plays the path animation to the end of use method
	 * also calls the move to run end method on finish with no delay
	 * @param double delay - delays the start of the animation in seconds
	 */
	public void moveToUseEnd(double delay) {
		pathTransitionUseEnd = codeAnimation.animateToUseEnd_CS(this);
		pathTransitionUseEnd.setDelay(Duration.seconds(delay));
		pathTransitionUseEnd.setOnFinished(e -> {
			moveToRunEnd(0);
		});
		pathTransitionUseEnd.play();

	}
	
	/**
	 * Creates and plays the path animation to the end of run method
	 * @param double delay - property to delay the start of the animation in seconds
	 */
	public void moveToRunEnd(double delay) {
		pathTransitionRunEnd = codeAnimation.animateToRunEnd_CS(this);
		pathTransitionRunEnd.setDelay(Duration.seconds(delay));
		pathTransitionRunEnd.play();

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
		if (pathTransitionSync != null)
			pathTransitionSync.pause();
		if (pathTransitionCritical != null)
			pathTransitionCritical.pause();
		if (pathTransitionUseEnd != null)
			pathTransitionUseEnd.pause();
		if (pathTransitionRunEnd != null)
			pathTransitionRunEnd.pause();
		
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
		if (pathTransitionSync != null && pathTransitionSync.getStatus()==Animation.Status.PAUSED)
			pathTransitionSync.play();
		if (pathTransitionCritical != null && pathTransitionCritical.getStatus()==Animation.Status.PAUSED)
			pathTransitionCritical.play();
		if (pathTransitionUseEnd != null && pathTransitionUseEnd.getStatus()==Animation.Status.PAUSED)
			pathTransitionUseEnd.play();
		if (pathTransitionRunEnd != null && pathTransitionRunEnd.getStatus()==Animation.Status.PAUSED)
			pathTransitionRunEnd.play();
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
		if (pathTransitionSync != null)
			pathTransitionSync.stop();
		if (pathTransitionCritical != null)
			pathTransitionCritical.stop();
		if (pathTransitionUseEnd != null)
			pathTransitionUseEnd.stop();
		if (pathTransitionUseEnd != null)
			pathTransitionUseEnd.pause();
		
	}

}
