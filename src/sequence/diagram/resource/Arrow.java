package sequence.diagram.resource;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;

/**
 * Class creates arrow for the sequence diagram interaction
 * 
 * @author Satpal Singh
 * @version 1.0
 */
public class Arrow extends Polygon {
	
	/**
	 * Creates a new instance of arrow based on the coordinates provided and colour by using JavaFX Polygon
	 * @param points - x and y coordinates where to plot the arrow in the diagram
	 * @param color - colour of the arrow
	 */
	public Arrow(double[] points, Color color) {
		super(points);
		setFill(color);
	}

	/**
	 * Changes the colour of the arrow with delay given
	 * @param value - colour value
	 * @param delaySec - delay in seconds
	 */
	public void setFillWithDelay(Paint value, int delaySec) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(delaySec*1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Arrow.super.setFill(value);
			}
		}).start();

	}

}
