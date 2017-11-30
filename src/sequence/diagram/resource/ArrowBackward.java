package sequence.diagram.resource;

import javafx.scene.paint.Color;

/**
 * Class that creates backward facing arrow
 * 
 * @author Satpal Singh
 * @version 1.0
 */
public class ArrowBackward extends Arrow {

	/**
	 * Creates a new instance of backward facing arrow by using Arrow class
	 * @param positionX - X coordinate of the arrow
	 * @param positionY - Y coordinate of the arrow
	 * @param height - height of the arrow
	 * @param color - color of the arrow
	 */
	public ArrowBackward(double positionX, double positionY, double height, Color color) {
		super(new double[] { positionX, positionY - (height / 2), positionX, positionY + (height / 2),
				positionX - height, positionY }, color);
	}

}
