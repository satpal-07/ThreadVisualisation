package state.diagram;
import diagram.Diagram;
import gui.ScreenSelection;
import state.diagram.resources.StateDiagramText;
import state.diagram.resources.StateObject;


/**
 * Abstract class that models generic state machine diagram
 * 
 * @author Satpal Singh
 * @version 1.0
 */
public abstract class StateDiagram extends Diagram {

	//Text to be displayed to th user when the thread changes states
	protected StateDiagramText displayText;

	/**
	 * Creates a new instance of state diagram with given image name and path
	 * @param diagram - String representing the image name and path
	 * @param isTextcenter - used to determine the position of the text
	 */
	public StateDiagram(String diagram, boolean isTextcenter) {
		//use the screenselection sequence width and height class variable for the width and height properties
		super(diagram, ScreenSelection.STATE_WIDTH, ScreenSelection.STATE_SEQUENCE_HEIGHT);
		displayText = new StateDiagramText(isTextcenter);
		StateObject.reset();
	}
	
	/**
	 * Initialises the objects in the state diagram
	 */
	public abstract void createObjects();
	
}
