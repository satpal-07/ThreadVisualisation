package sequence.diagram.resource;

import javafx.animation.PathTransition;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 * Class that creates animations for arrows in sequence diagram
 * 
 * @author Satpal Singh
 * @version 1.0
 */
public class ArrowAnimation {

	
	/**
	 * Creates and returns the animation on the arrow with provided parameters
	 * @param arrow - arrow that will be animated
	 * @param toX - ending x coordinate
	 * @param duration - duration of the animation
	 * @param delay - delay the start of the animation
	 * @return PathTransition that holds the animation created
	 */
	public static PathTransition animate(Arrow arrow, double toX, double duration, int delay) {
		Path path = new Path();
		double fromX = (arrow.getPoints().get(0)+arrow.getPoints().get(4))/2;
		double y = arrow.getPoints().get(5);
		path.getElements().add(new MoveTo(fromX, y));
		path.getElements().add(new LineTo(toX, y));
		PathTransition pathTransition = new PathTransition(Duration.seconds(duration), path, arrow);
		pathTransition.setDelay(Duration.seconds(delay));
		return pathTransition;
	}

	/**
	 * Creates and returns the animation with text displayed on complete
	 * @param arrow - arrow that will be animated
	 * @param toX - ending x coordinate
	 * @param duration - duration of the animation
	 * @param delay - delay the start of the animation
	 * @param text - text to be displayed on finish of animation
	 * @return PathTransition that holds the animation created
	 */
	public static PathTransition animateWithText(Arrow arrow, double toX, double duration,
			int delay, Text text) {
		PathTransition pathTransition = animate(arrow, toX, duration, delay);
		pathTransition.setOnFinished(e -> {
			text.setVisible(true);
			text.setStyle("-fx-font-weight: bold;");
		});
		return pathTransition;
	}

}
