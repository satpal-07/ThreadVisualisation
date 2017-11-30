package diagram;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Abstract class represents diagram model for sequence and state machine diagram
 * 
 * @author Satpal Singh
 * @version 1.0
 */
public abstract class Diagram {
	
	//declare variable
	protected ImageView imageView;
	protected Group root;
	protected double width;
	protected double height;
	
	
	/**
	 * Creates a diagram with specified image path
	 * @param diagram - String representing the image name and path
	 * @param width - {@link ImageView#fitWidthProperty()}
	 * @param height - {@link ImageView#fitHeightProperty()}
	 */
	public Diagram(String diagram, double width, double height) {
		Image image = new Image(diagram);
		ImageView imageView = new ImageView(image);
		this.width = width;
		this.height = height;
		imageView.setFitWidth(width);
		imageView.setFitHeight(height);
		root = new Group();
		root.getChildren().add(imageView);
	}

	/**
	 * Gets the root object that contains the diagram
	 */
	public Group getRoot(){
		return root;
	}
	
	/**
	 * Resets the objects in diagram to the starting position
	 */
	public abstract void reset();
	
	/**
	 * Plays the animation in diagram
	 */
	public abstract void play();

	/**
	 * Pauses the animation in diagram
	 */
	public abstract void pause();

	/**
	 * Stops the animation in diagram
	 */
	public abstract void stop();
}
