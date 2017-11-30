package state.diagram.resources;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;

/**
 * Class creates a circle with number label which represents thread in diagrams
 * The circle is limited to 3 only if more than 3 circles are created then last colour and label number will be used in more than 3 circles created
 * 
 * @author Satpal Singh
 * @version 1.0
 */
public class CircleObject extends StackPane {
	
	//Colour to be used
	private static Color[] COLORS = { Color.ORANGE, Color.GREEN, Color.PINK };
	
	
	/**
	 * Number of Circles created
	 */
	protected static int NUMBER = 0;
	private Circle circle;
	//label
	private Text label;
	
	/**
	 * Creates a new instance of circle given the centerX, centerY coordinates and radius
	 * @param centerX - {@link javafx.scene.shape.Circle#centerXProperty()}
	 * @param centerY - {@link javafx.scene.shape.Circle#centerYProperty()}
	 * @param radius - {@link javafx.scene.shape.Circle#radiusProperty()}
	 */
	public CircleObject(double centerX, double centerY, double radius) {
		super();
		this.setLayoutX(centerX);
		this.setLayoutY(centerY);
		circle = new Circle(radius, COLORS[NUMBER]);
		label = new Text(String.valueOf(NUMBER+1));
		label.setBoundsType(TextBoundsType.VISUAL);
		this.getChildren().addAll(circle, label);
		incrementNumber();
		
	}
	
	/**
	 * Gets the circle object in the class
	 * @return {@link Circle}
	 */
	public Circle getCircle(){
		return circle;
	}
	
	
	/**
	 * Gets the label of the circle
	 * @return {@link javafx.scene.control.Label}
	 */
	public Text getLabel(){
		return label;
	}
	
	/**
	 * Increments the number of the circles count up to 3
	 */
	protected static void incrementNumber(){
		if (NUMBER < 3)
			NUMBER++;
	}
	
	/**
	 * Resets the NUMBER class variable
	 */
	public static void reset(){
		NUMBER = 0;
	}

}
