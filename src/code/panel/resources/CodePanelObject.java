package code.panel.resources;

import state.diagram.resources.CircleObject;

/**
 * Class that models a generic thread object for the code panel
 * 
 * @author Satpal Singh
 * @version 1.0
 */
public abstract class  CodePanelObject extends CircleObject {

	//declare the object to be used to create animation
	protected CodePanelAnimation codeAnimation;

	/**
	 * Creates new thread object (circle) with specified x, y coordinates and radius
	 * @param double centerX - the centre x coordinate for the circle
	 * @param double centerY - the centre Y coordinate for the circle
	 * @param double radius - the radius for the circle
	 */
	public CodePanelObject(double centerX, double centerY, double radius) {
		super(centerX, centerY, radius);
		this.setVisible(false);
		codeAnimation = new CodePanelAnimation();
	}
	
	/**
	 * Plays the animation of code panel objects
	 */
	public abstract void play();

	/**
	 * Pauses the animation of code panel objects
	 */
	public abstract void pause();

	/**
	 * Stops the animation of code panel objects
	 */
	public abstract void stop();

}
