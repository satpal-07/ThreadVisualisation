package code.panel;

import gui.ScreenSelection;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * CodePanel abstract class represents the generic panel that displays the code
 * in execution for each thread visualisation.
 * 
 * @author Satpal Singh
 * @version 1.0
 */
public abstract class CodePanel {

	// Class variable for radius of the code panel object
	public static final double RADIUS = 12;

	// declare variables
	protected Text run;
	protected Text use;
	protected Pane root;
	protected ThreadCode sourceCode;

	/**
	 * Creates new instance of CodePanel that contains the code for run and use
	 * method of threads
	 */
	public CodePanel() {
		sourceCode = new ThreadCode();
		root = new Pane();
		run = new Text();
		use = new Text();
		run.setFont(Font.font("Verdana", 24));
		use.setLayoutX(0.522 * ScreenSelection.SHOW_CODE_WIDTH);
		run.setLayoutX(0.15 * ScreenSelection.SHOW_CODE_WIDTH);
		run.setLayoutY(40);
		// TODO: can move this run and use add in subclasses
		root.getChildren().addAll(run, use);
		// TODO: remove
		root.setOnMouseClicked(e -> {
			System.out.println("Text X :" + e.getX());
			System.out.println("Text Y :" + e.getY());
		});
	}

	/**
	 * Gets the text that contains the run method code
	 * 
	 * @return the run Text
	 */
	public Text getRunMethodCode() {
		return run;
	}

	/**
	 * Gets the text that contains the use method code
	 * 
	 * @return The Text that contains the runMethod code
	 */
	public Text getUseMethodCode() {
		return use;
	}

	/**
	 * Gets the root that holds the run and use text objects
	 * 
	 * @return Code panel Pane
	 */
	public Pane getRoot() {
		return root;
	}

	/**
	 * Plays the animation in code panel
	 */
	public abstract void play();

	/**
	 * Pauses the animation in code panel
	 */
	public abstract void pause();

	/**
	 * Stops the animation in code panel
	 */
	public abstract void stop();

}
