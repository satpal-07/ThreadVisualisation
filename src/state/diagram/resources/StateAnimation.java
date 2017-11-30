package state.diagram.resources;

import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.animation.PathTransition.OrientationType;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

/**
 * Class used for animating objects in state machine diagram
 * 
 * @author Satpal Singh
 * @version 1.0
 */
public class StateAnimation {

	//transition for running state
	public static Transition lineTransition;

	/**
	 * Creates and returns animations from new to running state for critical section
	 * @param node - the node on which the animation is applied
	 * @param width - the width of the screen to calculate the relative y position of the animation
	 * @param height  - the height of the screen to calculate the relative y position of the animation
	 * @return {@link PathTransition} 
	 */
	public static PathTransition moveFromNewToRunning_CS(Pane node, double width, double height) {
		Path path = new Path();
		path.getElements().add(new MoveTo(20, 20));
		path.getElements().add(new LineTo(0.342 * width - node.getLayoutX(), 20));
		path.getElements().add(new LineTo(0.342 * width - node.getLayoutX(),0.125 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.409 * width - node.getLayoutX(),0.125 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.409 * width - node.getLayoutX(), 0.667 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.202 * width - node.getLayoutX(), 0.677 * height - node.getLayoutY()));
		PathTransition pathTransition = new PathTransition(Duration.seconds(4), path, node);
		pathTransition.setCycleCount(1);
		pathTransition.setAutoReverse(false);
		return pathTransition;
	}
	
	/**
	 * Creates and returns animations from new to running state for waiting section
	 * @param node - the node on which the animation is applied
	 * @param width - the width of the screen to calculate the relative y position of the animation
	 * @param height  - the height of the screen to calculate the relative y position of the animation
	 * @return {@link PathTransition} 
	 */
	public static PathTransition moveFromNewToRunning_WS(Pane node, double width, double height) {
		Path path = new Path();
		path.getElements().add(new MoveTo(20, 20));
		path.getElements().add(new LineTo(0.342 * width - node.getLayoutX(), 20));
		path.getElements().add(new LineTo(0.342 * width - node.getLayoutX(),0.125 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.409 * width - node.getLayoutX(),0.125 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.409 * width - node.getLayoutX(), 0.667 * height - node.getLayoutY()));
		PathTransition pathTransition = new PathTransition(Duration.seconds(4), path, node);
		pathTransition.setCycleCount(1);
		pathTransition.setAutoReverse(false);
		return pathTransition;
	}
	
	/**
	 * Creates and returns animations from running to critical section in running state for waiting section
	 * @param node - the node on which the animation is applied
	 * @param width - the width of the screen to calculate the relative y position of the animation
	 * @param height  - the height of the screen to calculate the relative y position of the animation
	 * @return {@link PathTransition} 
	 */
	public static PathTransition moveFromRunningToCritical_WS(Pane node, double width, double height) {
		Path path = new Path();
		path.getElements().add(new MoveTo(0.409 * width- node.getLayoutX(), 0.667 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.342 * width - node.getLayoutX(), 0.667 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.342 * width - node.getLayoutX(), 0.857 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.202 * width - node.getLayoutX(), 0.857 * height - node.getLayoutY()));
		PathTransition pathTransition = new PathTransition(Duration.seconds(2), path, node);
		return pathTransition;
	}
	
	/**
	 * Creates and returns animations from running to critical section in running state for critical section
	 * @param node - the node on which the animation is applied
	 * @param width - the width of the screen to calculate the relative y position of the animation
	 * @param height  - the height of the screen to calculate the relative y position of the animation
	 * @return {@link PathTransition} 
	 */
	public static PathTransition moveFromRunningToCritical_CS(Pane node, double width, double height) {
		Path path = new Path();
		path.getElements().add(new MoveTo(0.202 * width- node.getLayoutX(), 0.677 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.342 * width - node.getLayoutX(), 0.677 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.342 * width - node.getLayoutX(), 0.857 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.202 * width - node.getLayoutX(), 0.857 * height - node.getLayoutY()));
		PathTransition pathTransition = new PathTransition(Duration.seconds(2), path, node);
		return pathTransition;
	}
	
	/**
	 * Creates and returns animations from critical section to running state for waiting section
	 * @param node - the node on which the animation is applied
	 * @param width - the width of the screen to calculate the relative y position of the animation
	 * @param height  - the height of the screen to calculate the relative y position of the animation
	 * @return {@link PathTransition} 
	 */
	public static PathTransition moveFromCriticalToRunning(Pane node, double width, double height) {
		Path path = new Path();
		path.getElements().add(new MoveTo(0.202 * width - node.getLayoutX(), 0.857 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.342 * width - node.getLayoutX(), 0.857 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.342 * width - node.getLayoutX(), 0.677 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.202 * width- node.getLayoutX(), 0.677 * height - node.getLayoutY()));
		PathTransition pathTransition = new PathTransition(Duration.seconds(2), path, node);
		pathTransition.setDelay(Duration.seconds(3));
		pathTransition.setOnFinished(e -> {
			lineTransition = lineTransition(node, width, height);
			lineTransition.play();
		});
		return pathTransition;
	}

	/**
	 * Creates and returns animations from new state to waiting state for critical section
	 * @param node - the node on which the animation is applied
	 * @param width - the width of the screen to calculate the relative y position of the animation
	 * @param height  - the height of the screen to calculate the relative y position of the animation
	 * @return {@link PathTransition} 
	 */
	public static PathTransition moveFromNewToWaiting_CS(Node node, double toX, double toY, double width, double height, double duration) {
		Path path = new Path();
		path.getElements().add(new MoveTo(20, 20));
		path.getElements().add(new LineTo(0.342 * width - node.getLayoutX(), 20));
		path.getElements().add(new LineTo(0.342 * width - node.getLayoutX(), 0.125 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.409 * width - node.getLayoutX(), 0.125 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.409 * width - node.getLayoutX(), 0.661 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.6 * width - node.getLayoutX(), 0.125 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.6 * width - node.getLayoutX(), 0.125 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.662 * width - node.getLayoutX(), 0.125 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.662 * width - node.getLayoutX(), toY));
		path.getElements().add(new LineTo(toX, toY));
		// 8 secs
		PathTransition pathTransition = new PathTransition(Duration.seconds(duration), path, node);
		pathTransition.setCycleCount(1);
		pathTransition.setAutoReverse(false);
		return pathTransition;
	}
	
	/**
	 * Creates and returns animations from waiting state to running state for critical section
	 * @param node - the node on which the animation is applied
	 * @param width - the width of the screen to calculate the relative y position of the animation
	 * @param height  - the height of the screen to calculate the relative y position of the animation
	 * @return {@link PathTransition} 
	 */
	public static PathTransition moveFromWaitingToRunning_CS(Pane node, double fromX, double fromY, double width, double height){
		Path path = new Path();
		path.getElements().add(new MoveTo(fromX, fromY));
		path.getElements().add(new LineTo(0.662 * width - node.getLayoutX(), fromY));
		path.getElements().add(new LineTo(0.662 * width - node.getLayoutX(), 0.125 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.6 * width - node.getLayoutX(), 0.125 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.414 * width - node.getLayoutX(), 0.677 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.202 * width - node.getLayoutX(), 0.677 * height - node.getLayoutY()));
		PathTransition pathTransition = new PathTransition(Duration.seconds(4), path, node);
		pathTransition.setCycleCount(1);
		pathTransition.setAutoReverse(false);
		return pathTransition;
	}
	

	/**
	 * Creates and returns animations from trying to access critical section to waiting state for waiting section
	 * @param node - the node on which the animation is applied
	 * @param width - the width of the screen to calculate the relative y position of the animation
	 * @param height  - the height of the screen to calculate the relative y position of the animation
	 * @return {@link PathTransition} 
	 */
	public static PathTransition moveFromWaitingCriticalToWaitingCondition_WS(Pane node, double fromX, double fromY, double width, double height){
		Path path = new Path();
		path.getElements().add(new MoveTo(fromX, fromY));
		path.getElements().add(new LineTo(0.662 * width - node.getLayoutX(), fromY));
		path.getElements().add(new LineTo(0.662 * width - node.getLayoutX(), 0.125 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.6 * width - node.getLayoutX(), 0.125 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.6 * width - node.getLayoutX(), 0.398 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.804 * width - node.getLayoutX(), 0.398 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.804 * width - node.getLayoutX(), 0.478 * height - node.getLayoutY()));
		PathTransition pathTransition = new PathTransition(Duration.seconds(4), path, node);
		pathTransition.setCycleCount(1);
		pathTransition.setAutoReverse(false);
		return pathTransition;
	}
	
	/**
	 * Creates and returns animations from waiting state to waiting critical section for waiting section
	 * @param node - the node on which the animation is applied
	 * @param width - the width of the screen to calculate the relative y position of the animation
	 * @param height  - the height of the screen to calculate the relative y position of the animation
	 * @return {@link PathTransition} 
	 */
	public static PathTransition moveFromWaitingConditionToWaitingCritical_WS(Pane node, double toX, double toY, double width, double height){
		Path path = new Path();
		path.getElements().add(new MoveTo(0.804 * width - node.getLayoutX(), 0.478 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.804 * width - node.getLayoutX(), 0.398 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.6 * width - node.getLayoutX(), 0.398 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.6 * width - node.getLayoutX(), 0.125 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.662 * width - node.getLayoutX(), 0.125 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.662 * width - node.getLayoutX(), toY));
		path.getElements().add(new LineTo(toX, toY));
		PathTransition pathTransition = new PathTransition(Duration.seconds(4), path, node);
		pathTransition.setCycleCount(1);
		pathTransition.setAutoReverse(false);
		return pathTransition;
	}
	
	/**
	 * Creates and returns animations from waiting critical to running state for waiting section
	 * @param node - the node on which the animation is applied
	 * @param width - the width of the screen to calculate the relative y position of the animation
	 * @param height  - the height of the screen to calculate the relative y position of the animation
	 * @return {@link PathTransition} 
	 */
	public static PathTransition moveFromWaitingCriticalToRunning_WS(Pane node,double fromX, double fromY, double width, double height){
		Path path = new Path();
		path.getElements().add(new MoveTo(fromX, fromY));
		path.getElements().add(new LineTo(0.662 * width - node.getLayoutX(), fromY));
		path.getElements().add(new LineTo(0.662 * width - node.getLayoutX(), 0.125 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.6 * width - node.getLayoutX(), 0.125 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.409 * width - node.getLayoutX(), 0.667 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.342 * width - node.getLayoutX(), 0.667 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.342 * width - node.getLayoutX(), 0.857 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.202 * width - node.getLayoutX(), 0.857 * height - node.getLayoutY()));
		PathTransition pathTransition = new PathTransition(Duration.seconds(4), path, node);
		return pathTransition;
	}
	
	public static PathTransition moveFromRunningToTerminate_CS(Node node, double toX, double toY, double width, double height){
		//if line transition is playing then stop the transition
		if (lineTransition != null) {
			lineTransition.stop();
		}
		Path path = new Path();
		path.getElements().add(new MoveTo(0.202 * width- node.getLayoutX(), 0.677 * height - node.getLayoutY()));
		//path.getElements().add(new LineTo(0.342 * width - node.getLayoutX(), 0.771 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.342 * width - node.getLayoutX(), 0.677 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.414 * width - node.getLayoutX(), 0.677 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.6 * width - node.getLayoutX(), 0.677 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.662 * width - node.getLayoutX(), 0.677 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.662 * width - node.getLayoutX(), toY));
		path.getElements().add(new LineTo(toX, toY));
		PathTransition pathTransition = new PathTransition(Duration.seconds(4), path, node);
		pathTransition.setCycleCount(1);
		return pathTransition;
	}
	
	/**
	 * Creates and returns animations from running state to running critical section for waiting section
	 * @param node - the node on which the animation is applied
	 * @param width - the width of the screen to calculate the relative y position of the animation
	 * @param height  - the height of the screen to calculate the relative y position of the animation
	 * @return {@link PathTransition} 
	 */
	public static PathTransition moveFromRunningToCritical_WS(Node node, double toX, double toY, double width, double height){
		//if line transition is playing then stop the transition
		if (lineTransition != null) {
			lineTransition.stop();
		}
		Path path = new Path();
		path.getElements().add(new MoveTo(0.202 * width- node.getLayoutX(), 0.677 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.342 * width - node.getLayoutX(), 0.677 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.342 * width - node.getLayoutX(), 0.857 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.202 * width - node.getLayoutX(), 0.857 * height - node.getLayoutY()));
		PathTransition pathTransition = new PathTransition(Duration.seconds(2), path, node);
		pathTransition.setCycleCount(1);
		return pathTransition;
	}
	
	/**
	 * Creates and returns animations from critical section to terminate state for waiting section
	 * @param node - the node on which the animation is applied
	 * @param width - the width of the screen to calculate the relative y position of the animation
	 * @param height  - the height of the screen to calculate the relative y position of the animation
	 * @return {@link PathTransition} 
	 */
	public static PathTransition moveFromCriticalToTerminated_WS(Node node, double toX, double toY, double width, double height){
		//if line transition is playing then stop the transition
		if (lineTransition != null) {
			lineTransition.stop();
		}
		Path path = new Path();
		path.getElements().add(new MoveTo(0.202 * width - node.getLayoutX(), 0.857 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.342 * width- node.getLayoutX(), 0.857 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.342 * width - node.getLayoutX(), 0.677 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.414 * width - node.getLayoutX(), 0.677 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.6 * width - node.getLayoutX(), 0.677 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.662 * width - node.getLayoutX(), 0.677 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.662 * width - node.getLayoutX(), toY));
		path.getElements().add(new LineTo(toX, toY));
		PathTransition pathTransition = new PathTransition(Duration.seconds(4), path, node);
		pathTransition.setCycleCount(1);
		return pathTransition;
	}
	
	/**
	 * Creates and returns animations from critical section to terminate state for waiting section
	 * @param node - the node on which the animation is applied
	 * @param width - the width of the screen to calculate the relative y position of the animation
	 * @param height  - the height of the screen to calculate the relative y position of the animation
	 * @return {@link PathTransition} 
	 */
	public static Transition createTransition(Shape path, Pane node) {
		PathTransition pathTransition = new PathTransition(Duration.seconds(1), path, node);
		pathTransition.setOrientation(OrientationType.NONE);
		pathTransition.setCycleCount(Timeline.INDEFINITE);
		pathTransition.setInterpolator(Interpolator.LINEAR);
		return pathTransition;
	}
	
	/**
	 * Creates and returns line transition with in running state
	 * @param node - the node on which the animation is applied
	 * @param width - the width of the screen to calculate the relative y position of the animation
	 * @param height  - the height of the screen to calculate the relative y position of the animation
	 * @return {@link PathTransition} 
	 */
	public static Transition lineTransition(Pane node, double width, double height) {
		Path path = new Path();
		path.getElements().add(new MoveTo(0.202 * width - node.getLayoutX(), 0.677 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.105 * width - node.getLayoutX(), 0.677 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.311 * width - node.getLayoutX(), 0.677 * height - node.getLayoutY()));
		path.getElements().add(new LineTo(0.202 * width - node.getLayoutX(), 0.677 * height - node.getLayoutY()));
		PathTransition pathTransition = new PathTransition(Duration.seconds(1), path, node);
		pathTransition.setOrientation(OrientationType.NONE);
		pathTransition.setCycleCount(2);
		pathTransition.setInterpolator(Interpolator.LINEAR);
		return pathTransition;
	}
	
}
