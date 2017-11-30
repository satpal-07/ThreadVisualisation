package sequence.diagram.resource;

import gui.ScreenSelection;
import javafx.scene.paint.Color;

/**
 * Class that creates the list of arrows to be used for waiting section sequence diagram
 * 
 * @author Satpal Singh
 * @version 1.0
 */
public class WaitingSequenceArrowList extends SequenceDiagramArrowList {
	
	//Arrows
	private Arrow createRunwayArrow;
	private Arrow createAirplane1Arrow;
	private Arrow createAirplane2Arrow;
	private Arrow useRunwayAirplane1;
	private Arrow useRunwayAirplane2;
	private Arrow airplane2Wait;
	private Arrow airplane1Notify;
	private Arrow airplane2Acquire;
	private Arrow airplane2Notify;
	//height and width properties
	private double width;
	private double height;
	
	/**
	 * Creates new instance of WaitingSequenceArrowlist that contain list of arrow
	 */
	public WaitingSequenceArrowList() {
		super();
		width = ScreenSelection.SEQUENCE_WIDTH;
		height = ScreenSelection.STATE_SEQUENCE_HEIGHT;
		createArrows();
		addToList();
	}
	
	/* (non-Javadoc)
	 * @see sequence.diagram.resource.SequenceDiagramArrowList#createArrows()
	 */
	protected void createArrows() {
		createRunwayArrow = new ArrowForward(0.117 * width, 0.193 * height, 0.028 * height, Color.BLACK);
		createAirplane1Arrow = new ArrowForward(0.117 * width, 0.249 * height, 0.028 * height, Color.BLACK);
		createAirplane2Arrow = new ArrowForward(0.117 * width, 0.304 * height, 0.028 * height, Color.BLACK);
		useRunwayAirplane1 = new ArrowForward(0.313 * width, 0.414 * height, 0.028 * height, Color.ORANGE);
		useRunwayAirplane2 = new ArrowForward(0.511 * width, 0.486 * height, 0.028 * height, Color.GREEN);
		airplane2Wait = new ArrowForward(0.714 * width, 0.5 * height, 0.028 * height, Color.GREEN);
		airplane1Notify = new ArrowForward(0.714 * width, 0.592 * height, 0.028 * height, Color.ORANGE);
		airplane2Acquire = new ArrowBackward(0.881 * width, 0.664 * height, 0.028 * height, Color.GREEN);
		airplane2Notify = new ArrowForward(0.714 * width, 0.759 * height, 0.028 * height, Color.GREEN);
	}
	
	/* (non-Javadoc)
	 * @see sequence.diagram.resource.SequenceDiagramArrowList#addToList()
	 */
	protected void addToList(){
		arrowList.add(createRunwayArrow);
		arrowList.add(createAirplane1Arrow);
		arrowList.add(useRunwayAirplane1);
		arrowList.add(airplane1Notify); 
		arrowList.add(createAirplane2Arrow); 
		arrowList.add(useRunwayAirplane2);
		arrowList.add(airplane2Acquire);
		arrowList.add(airplane2Wait);
		arrowList.add(airplane2Notify);
	}
	
	

}
