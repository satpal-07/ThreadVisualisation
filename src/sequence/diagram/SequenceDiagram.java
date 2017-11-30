package sequence.diagram;

import java.util.ArrayList;

import diagram.Diagram;
import gui.ScreenSelection;
import javafx.animation.PathTransition;
import sequence.diagram.resource.Arrow;

/**
 * Abstract class that models generic sequence diagram
 * 
 * @author Satpal Singh
 * @version 1.0
 */

public abstract class SequenceDiagram extends Diagram {

	//lists to hold reference to the animations and arrows
	protected ArrayList<PathTransition> animations;
	protected ArrayList<Arrow> arrowList;

	/**
	 * Creates a new instance of sequence diagram with given image name and path
	 * @param diagram - String representing the image name and path
	 */
	public SequenceDiagram(String diagram) {
		//use the screenselection sequence width and height class variable for the width and height properties
		super(diagram, ScreenSelection.SEQUENCE_WIDTH, ScreenSelection.STATE_SEQUENCE_HEIGHT);
		animations = new ArrayList<PathTransition>();
	}
	
}
