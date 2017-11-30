package code.panel.resources;

import code.panel.CodePanel;
import gui.ScreenSelection;
import javafx.animation.PathTransition;
import javafx.scene.layout.Pane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

/**
 * Class that represents the code panel for waiting section
 * 
 * @author Satpal Singh
 * @version 1.0
 */
public class CodePanelAnimation {
	
	//class variables that are used for positioning the code panel objects
	private static double TAB_INDENT = 75;
	private static double NEXTLINE = 31;
	private static double USE_METHOD_X_POSITION = 0.34 * ScreenSelection.SHOW_CODE_WIDTH;
	private static double USE_METHOD_Y_POSITION = -30;
	private static double USE_METHOD_SLEEP_X_POSITION = 0.625 * ScreenSelection.SHOW_CODE_WIDTH;
	private static double USE_METHOD_SLEEP_Y_POSITION = 98;
	private static double END_X_POSITION = 0.015 * ScreenSelection.SHOW_CODE_WIDTH;
	private static double END_Y_POSITION =  130;
	private static double TAB_INDENT_MEDIUM = 64;
	private static double NEXTLINE_MEDIUM = 27; 
	private static double SMALL_TAB_INDENT = 45;
	private static double SMALL_NEXTLINE = 18;
	private static double WAITING_X_POSITION = 0.618 * ScreenSelection.SHOW_CODE_WIDTH;
	private static double WAITING_Y_POSITION = 68;
	private static double SET_BUSY_X_POSITION = 0.587 * ScreenSelection.SHOW_CODE_WIDTH;
	private static double SET_BUSY_Y_POSITION = 102;
	private static double USE_RUNWAY_METHOD_X_POSITION = 0.37 * ScreenSelection.SHOW_CODE_WIDTH;
	private static double USE_RUNWAY_METHOD_Y_POSITION = -35;
	private static double SET_BUSY_FALSE_X_POSITION = 0.596 * ScreenSelection.SHOW_CODE_WIDTH;
	private static double SET_BUSY_FALSE_Y_POSITION = 0.717 * ScreenSelection.SHOW_CODE_HEIGHT;
	private double currentX;
	private double currentY;
	
	/**
	 * Creates new instance of the code panel animation
	 */
	public CodePanelAnimation() {
		currentX = CodePanel.RADIUS;
		currentY = CodePanel.RADIUS;
	}
	
	/**
	 * Creates and returns animation to useJunction method of critical scenario
	 * @param node - object that will be animated
	 * @return PathTransition animation path to the useJuntion method
	 */
	public PathTransition animateToUseJunction_CS(Pane node) {
		
		updateXAndY(CodePanel.RADIUS, CodePanel.RADIUS);
		Path path = new Path();
		path.getElements().add(new MoveTo(currentX, currentY));
		path.getElements().add(new LineTo(currentX, currentY + (NEXTLINE * 2)));
		path.getElements().add(new LineTo(currentX+TAB_INDENT, currentY + (NEXTLINE * 2)));
		updateXAndY(currentX+TAB_INDENT, currentY + (NEXTLINE * 2));
		PathTransition pathTransition = new PathTransition(Duration.seconds(1), path, node);
		pathTransition.setCycleCount(1);
		pathTransition.setAutoReverse(false);
		return pathTransition;
	}
	
	/**
	 * Creates and returns animation to use statement in run method of critical scenario
	 * @param node - object that will be animated
	 * @return PathTransition animation path to the use statement in run method
	 */
	public PathTransition animateToUse_CS(Pane node) {
		Path path = new Path();
		path.getElements().add(new MoveTo(currentX, currentY));
		path.getElements().add(new LineTo(currentX-TAB_INDENT, currentY + NEXTLINE * 2));
		path.getElements().add(new LineTo(USE_METHOD_X_POSITION, USE_METHOD_Y_POSITION));
		updateXAndY(USE_METHOD_X_POSITION, USE_METHOD_Y_POSITION);
		PathTransition pathTransition = new PathTransition(Duration.seconds(1), path, node);
		pathTransition.setCycleCount(1);
		pathTransition.setAutoReverse(false);
		return pathTransition;
	}
	
	/**
	 * Creates and returns animation to sync method of critical scenario
	 * @param node - object that will be animated
	 * @return PathTransition animation path to the sync method
	 */
	public PathTransition animateToSync_CS(Pane node) {
		Path path = new Path();
		path.getElements().add(new MoveTo(currentX, currentY));
		path.getElements().add(new LineTo(currentX, currentY +NEXTLINE_MEDIUM));
		path.getElements().add(new LineTo(currentX+TAB_INDENT_MEDIUM,  currentY +NEXTLINE_MEDIUM));
		updateXAndY(currentX+TAB_INDENT_MEDIUM, currentY +NEXTLINE_MEDIUM);
		PathTransition pathTransition = new PathTransition(Duration.seconds(1), path, node);
		pathTransition.setCycleCount(1);
		pathTransition.setAutoReverse(false);
		return pathTransition;
	}
	
	/**
	 * Creates and returns animation to critical statement in useJunction method of critical scenario
	 * @param node - object that will be animated
	 * @return PathTransition animation path to the critical statement in useJunction method
	 */
	public PathTransition animateToCritical_CS(Pane node) {
		Path path = new Path();
		path.getElements().add(new MoveTo(currentX, currentY));
		path.getElements().add(new LineTo(currentX, currentY + NEXTLINE));
		path.getElements().add(new LineTo(currentX + TAB_INDENT_MEDIUM, currentY + NEXTLINE_MEDIUM));
		path.getElements().add(new LineTo(USE_METHOD_SLEEP_X_POSITION - node.getLayoutX(), USE_METHOD_SLEEP_Y_POSITION  - node.getLayoutY()));
		PathTransition pathTransition = new PathTransition(Duration.seconds(1), path, node);
		pathTransition.setCycleCount(1);
		pathTransition.setAutoReverse(false);
		return pathTransition;
	}
	
	/**
	 * Creates and returns animation to the end of useJunction method of critical scenario
	 * @param node - object that will be animated
	 * @return PathTransition animation path to the end of useJunction  method
	 */
	public PathTransition animateToUseEnd_CS(Pane node) {
		Path path = new Path();
		path.getElements().add(new MoveTo(USE_METHOD_SLEEP_X_POSITION - node.getLayoutX(), USE_METHOD_SLEEP_Y_POSITION - node.getLayoutY()));
		path.getElements().add(new LineTo((USE_METHOD_SLEEP_X_POSITION - TAB_INDENT_MEDIUM) - node.getLayoutX(), (USE_METHOD_SLEEP_Y_POSITION+NEXTLINE_MEDIUM*4)- node.getLayoutY()));
		path.getElements().add(new LineTo((USE_METHOD_SLEEP_X_POSITION - TAB_INDENT_MEDIUM*3) - node.getLayoutX(), (USE_METHOD_SLEEP_Y_POSITION+NEXTLINE_MEDIUM*5)- node.getLayoutY()));
		PathTransition pathTransition = new PathTransition(Duration.seconds(2), path, node);
		pathTransition.setCycleCount(1);
		pathTransition.setAutoReverse(false);
		return pathTransition;
	}
	
	/**
	 * Creates and returns animation to the end of run method of critical scenario
	 * @param node - object that will be animated
	 * @return PathTransition animation path to the end of run  method
	 */
	public PathTransition animateToRunEnd_CS(Pane node) {
		Path path = new Path();
		path.getElements().add(new MoveTo((USE_METHOD_SLEEP_X_POSITION - TAB_INDENT_MEDIUM*3) - node.getLayoutX(), (USE_METHOD_SLEEP_Y_POSITION+NEXTLINE_MEDIUM*5)- node.getLayoutY()));
		path.getElements().add(new LineTo(END_X_POSITION, END_Y_POSITION));
		PathTransition pathTransition = new PathTransition(Duration.seconds(1), path, node);
		pathTransition.setCycleCount(1);
		pathTransition.setAutoReverse(false);
		pathTransition.setOnFinished(e -> {
			
		});
		return pathTransition;
	}
	
	/**
	 * Creates and returns animation to the useRunway.use statement in run method of waiting scenario
	 * @param node - object that will be animated
	 * @return PathTransition animation path to the useRunway.use statement in run method
	 */
	public PathTransition animateToRunwayUse_WS(Pane node) {
		updateXAndY(CodePanel.RADIUS, CodePanel.RADIUS);
		Path path = new Path();
		path.getElements().add(new MoveTo(currentX, currentY));
		path.getElements().add(new LineTo(currentX, currentY + NEXTLINE * 2));
		path.getElements().add(new LineTo(currentX+TAB_INDENT, currentY + NEXTLINE * 2));
		updateXAndY(currentX + TAB_INDENT, currentY + NEXTLINE * 2);
		PathTransition pathTransition = new PathTransition(Duration.seconds(1), path, node);
		pathTransition.setCycleCount(1);
		pathTransition.setAutoReverse(false);
		return pathTransition;
	}
	
	/**
	 * Creates and returns animation to the useRunway method of waiting scenario
	 * @param node - object that will be animated
	 * @return PathTransition animation path to the useRunway method
	 */
	public PathTransition animateToUseRunway_WS(Pane node) {
		Path path = new Path();
		path.getElements().add(new MoveTo(currentX, currentY));
		path.getElements().add(new LineTo(currentX-TAB_INDENT, currentY + NEXTLINE * 2));
		path.getElements().add(new LineTo(USE_RUNWAY_METHOD_X_POSITION, USE_RUNWAY_METHOD_Y_POSITION));
		updateXAndY(USE_RUNWAY_METHOD_X_POSITION, USE_RUNWAY_METHOD_Y_POSITION);
		PathTransition pathTransition = new PathTransition(Duration.seconds(3), path, node);
		pathTransition.setCycleCount(1);
		pathTransition.setAutoReverse(false);
		return pathTransition;
	}
	
	/**
	 * Creates and returns animation to the waiting sync statement in useRunway method of waiting scenario
	 * @param node - object that will be animated
	 * @return PathTransition animation path to the waiting sync statement in useRunway method
	 */
	public PathTransition animateToWaitSync_WS(Pane node) {
		Path path = new Path();
		path.getElements().add(new MoveTo(USE_RUNWAY_METHOD_X_POSITION, USE_RUNWAY_METHOD_Y_POSITION));
		path.getElements().add(new LineTo(currentX+SMALL_TAB_INDENT*2, currentY + SMALL_NEXTLINE));
		updateXAndY(currentX + SMALL_TAB_INDENT*2, currentY + SMALL_NEXTLINE);
		PathTransition pathTransition = new PathTransition(Duration.seconds(1), path, node);
		pathTransition.setCycleCount(1);
		pathTransition.setAutoReverse(false);
		return pathTransition;
	}
	
	/**
	 * Creates and returns animation to the wait() statement in useRunway method of waiting scenario
	 * @param node - object that will be animated
	 * @return PathTransition animation path to the wait statement in useRunway method
	 */
	public PathTransition animateToWait_WS(Pane node) {
		Path path = new Path();
		path.getElements().add(new MoveTo(currentX, currentY));
		path.getElements().add(new LineTo(currentX, currentY + SMALL_NEXTLINE));
		path.getElements().add(new LineTo(currentX + SMALL_TAB_INDENT, currentY + SMALL_NEXTLINE));
		path.getElements().add(new LineTo(currentX + SMALL_TAB_INDENT * 2, currentY + SMALL_NEXTLINE * 2));
		path.getElements().add(new LineTo(WAITING_X_POSITION - node.getLayoutX(), WAITING_Y_POSITION - node.getLayoutY()));
		PathTransition pathTransition = new PathTransition(Duration.seconds(1), path, node);
		pathTransition.setCycleCount(1);
		pathTransition.setAutoReverse(false);
		return pathTransition;
	}
	
	/**
	 * Creates and returns animation from wait to the setBusy(true) statement in useRunway method of waiting scenario
	 * @param node - object that will be animated
	 * @return PathTransition animation path from wait to the setBusy(true) statement in useRunway method
	 */
	public PathTransition animateFromWaitToSetBusyTrue_WS(Pane node) {
		Path path = new Path();
		path.getElements().add(new MoveTo(WAITING_X_POSITION - node.getLayoutX(), WAITING_Y_POSITION - node.getLayoutY()));
		path.getElements().add(new LineTo((WAITING_X_POSITION - SMALL_TAB_INDENT) - node.getLayoutX(), (WAITING_Y_POSITION + SMALL_NEXTLINE)- node.getLayoutY()));
		path.getElements().add(new LineTo((WAITING_X_POSITION - SMALL_TAB_INDENT) - node.getLayoutX(), (WAITING_Y_POSITION - SMALL_NEXTLINE)- node.getLayoutY()));
		path.getElements().add(new LineTo((WAITING_X_POSITION - SMALL_TAB_INDENT) - node.getLayoutX(), (WAITING_Y_POSITION + SMALL_NEXTLINE * 2)- node.getLayoutY()));
		path.getElements().add(new LineTo(SET_BUSY_X_POSITION - node.getLayoutX(), SET_BUSY_Y_POSITION - node.getLayoutY()));
		PathTransition pathTransition = new PathTransition(Duration.seconds(3), path, node);
		pathTransition.setCycleCount(1);
		pathTransition.setAutoReverse(false);
		return pathTransition;
	}
	
	/**
	 * Creates and returns animation to the setBusy(true) statement in useRunway method of waiting scenario
	 * @param node - object that will be animated
	 * @return PathTransition animation path to the setBusy(true) statement in useRunway method
	 */
	public PathTransition animateToSetBusyTrue_WS(Pane node) {
		Path path = new Path();
		path.getElements().add(new MoveTo(currentX, currentY));
		path.getElements().add(new LineTo(currentX,  currentY+ SMALL_NEXTLINE));
		path.getElements().add(new LineTo(currentX + SMALL_TAB_INDENT,  currentY+ SMALL_NEXTLINE));
		path.getElements().add(new LineTo(currentX+ SMALL_TAB_INDENT, currentY + SMALL_NEXTLINE * 2));
		path.getElements().add(new LineTo(currentX+ SMALL_TAB_INDENT, currentY + SMALL_NEXTLINE * 2));
		path.getElements().add(new LineTo(SET_BUSY_X_POSITION - node.getLayoutX(), SET_BUSY_Y_POSITION - node.getLayoutY()));
		PathTransition pathTransition = new PathTransition(Duration.seconds(1), path, node);
		pathTransition.setCycleCount(1);
		pathTransition.setAutoReverse(false);
		return pathTransition;
	}
	
	/**
	 * Creates and returns animation to the setBusy(false) statement in useRunway method of waiting scenario
	 * @param node - object that will be animated
	 * @return PathTransition animation path to the setBusy(false) statement in useRunway method
	 */
	public PathTransition animateToSetBusyFalse_WS(Pane node) {
		Path path = new Path();
		path.getElements().add(new MoveTo(currentX,  currentY));
		path.getElements().add(new LineTo(SET_BUSY_FALSE_X_POSITION - node.getLayoutX(), SET_BUSY_FALSE_Y_POSITION - node.getLayoutY()));
		updateXAndY(SET_BUSY_FALSE_X_POSITION - node.getLayoutX(), SET_BUSY_FALSE_Y_POSITION - node.getLayoutY());
		PathTransition pathTransition = new PathTransition(Duration.seconds(1), path, node);
		pathTransition.setCycleCount(1);
		pathTransition.setAutoReverse(false);
		return pathTransition;
	}
	
	/**
	 * Creates and returns animation to the critical section in useRunway method of waiting scenario
	 * @param node - object that will be animated
	 * @return PathTransition animation path to the critical section in useRunway method
	 */
	public PathTransition animateToCriticalSection_WS(Pane node) {
		Path path = new Path();
		path.getElements().add(new MoveTo(SET_BUSY_X_POSITION - node.getLayoutX(), SET_BUSY_Y_POSITION - node.getLayoutY()));
		path.getElements().add(new LineTo((SET_BUSY_X_POSITION - SMALL_TAB_INDENT) - node.getLayoutX(), (SET_BUSY_Y_POSITION + (SMALL_NEXTLINE * 2)) - node.getLayoutY()));
		updateXAndY((SET_BUSY_X_POSITION - SMALL_TAB_INDENT) - node.getLayoutX(), (SET_BUSY_Y_POSITION + (SMALL_NEXTLINE * 2)) - node.getLayoutY());
		PathTransition pathTransition = new PathTransition(Duration.seconds(1), path, node);
		pathTransition.setCycleCount(1);
		pathTransition.setAutoReverse(false);
		return pathTransition;
	}
	
	/**
	 * Creates and returns animation to the end of the run method of waiting scenario
	 * @param node - object that will be animated
	 * @return PathTransition animation path  to the end of the run method
	 */
	public PathTransition animateToEndRun_WS(Pane node) {
		Path path = new Path();
		
		path.getElements().add(new MoveTo(currentX, currentY));
		path.getElements().add(new LineTo(currentX,  currentY+ SMALL_NEXTLINE ));
		path.getElements().add(new LineTo(currentX- SMALL_TAB_INDENT, currentY + SMALL_NEXTLINE * 2));
		path.getElements().add(new LineTo(currentX- SMALL_TAB_INDENT*2, currentY + SMALL_NEXTLINE * 3));
		path.getElements().add(new LineTo(END_X_POSITION, END_Y_POSITION));
		PathTransition pathTransition = new PathTransition(Duration.seconds(3), path, node);
		pathTransition.setCycleCount(1);
		pathTransition.setAutoReverse(false);
		return pathTransition;
	}
	
	/**
	 * Updates x and y positions
	 * @param double x axis position
	 * @param double y axis position
	 */
	public void updateXAndY(double x, double Y){
		currentX = x;
		currentY = Y;
	}
	
	/**
	 * Recalculates the position of the class variables
	 */
	public static void recalculate(){
		TAB_INDENT = 75;
		NEXTLINE = 31;
		USE_METHOD_X_POSITION = 0.34 * ScreenSelection.SHOW_CODE_WIDTH;
		USE_METHOD_Y_POSITION = -30;
		USE_METHOD_SLEEP_X_POSITION = 0.625 * ScreenSelection.SHOW_CODE_WIDTH;
		USE_METHOD_SLEEP_Y_POSITION = 98;
		END_X_POSITION = 0.015 * ScreenSelection.SHOW_CODE_WIDTH;
		END_Y_POSITION =  132;
		SMALL_TAB_INDENT = 45;
		SMALL_NEXTLINE =  18;
		WAITING_X_POSITION = 0.636 * ScreenSelection.SHOW_CODE_WIDTH;
		WAITING_Y_POSITION = 0.2935 * ScreenSelection.SHOW_CODE_HEIGHT;
		SET_BUSY_X_POSITION = 0.587* ScreenSelection.SHOW_CODE_WIDTH;
		SET_BUSY_Y_POSITION = 102;
		SET_BUSY_FALSE_X_POSITION = 0.596 * ScreenSelection.SHOW_CODE_WIDTH;
		SET_BUSY_FALSE_Y_POSITION = 0.717 * ScreenSelection.SHOW_CODE_HEIGHT;
		USE_RUNWAY_METHOD_X_POSITION = 0.37 * ScreenSelection.SHOW_CODE_WIDTH;
		USE_RUNWAY_METHOD_Y_POSITION = -35;
	}
}
