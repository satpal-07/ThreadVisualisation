package sequence.diagram.resource;

import javafx.scene.paint.Color;

/**
 * Class that creates forward facing arrow
 * 
 * @author Satpal Singh
 * @version 1.0
 */
public class ArrowForward extends Arrow {

	/**
	 * Creates a new instance of forward facing arrow by using Arrow class
	 * @param positionX - X coordinate of the arrow
	 * @param positionY - Y coordinate of the arrow
	 * @param height - height of the arrow
	 * @param color - color of the arrow
	 */
	public ArrowForward(double positionX, double positionY, double height, Color color) {
		super(new double[] { positionX, positionY - (height / 2), positionX, positionY + (height / 2),
				positionX + height, positionY }, color);
	}

}
