package sequence.diagram.resource;

import java.util.ArrayList;

/**
 * Class that creates a list of arrows to be used for sequence diagram
 * 
 * @author Satpal Singh
 * @version 1.0
 */
public abstract class SequenceDiagramArrowList {
	
	// list that holds arrows
	protected ArrayList<Arrow> arrowList;
	
	/**
	 * Creates a new instance of sequence diagram arrows in an ArrayList
	 */
	public SequenceDiagramArrowList() {
		arrowList = new ArrayList<Arrow>();
	}
	
	/**
	 * Gets the list that holds the arrows
	 * @return ArrayList containing arrows
	 */
	public ArrayList<Arrow> getArrows() {
		return arrowList;
	}
	
	/**
	 * Resets the arrows coordinates
	 */
	public void reset(){
		createArrows();
		arrowList.clear();
		addToList();
	}
	
	/**
	 * Creates the arrows
	 */
	abstract protected void createArrows();
	
	/**
	 * Adds the arrows to the list to be used to carry out play, pause and stop animation operations
	 */
	abstract protected void addToList();

}
