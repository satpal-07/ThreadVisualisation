package sequence.diagram.resource;

import gui.ScreenSelection;
import javafx.scene.paint.Color;

/**
 * Class that creates the list of arrows to be used for critical section sequence diagram
 * 
 * @author Satpal Singh
 * @version 1.0
 */
public class CriticalSequenceArrowList extends SequenceDiagramArrowList {
	
	//Arrows
	private Arrow createRoadArrow;
	private Arrow createCar1Arrow;
	private Arrow createCar2Arrow;
	private Arrow createCar3Arrow;
	private Arrow useRoadCar1Arrow;
	private Arrow useRoadCar2Arrow;
	private Arrow useRoadCar3Arrow;
	private Arrow leftRoadCar1ReturnArrow;
	private Arrow leftRoadCar2ReturnArrow;
	private Arrow leftRoadCar3ReturnArrow;
	//height and width properties
	private double width;
	private double height;
	
	/**
	 * Creates new instance of CriticalSequenceArrowlist that contain list of arrow
	 */
	public CriticalSequenceArrowList() {
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
		createRoadArrow = new ArrowForward(0.117 * width, 0.193 * height, 0.028 * height, Color.BLACK);
		createCar1Arrow = new ArrowForward(0.117 * width, 0.249 * height, 0.028 * height, Color.BLACK);
		createCar2Arrow = new ArrowForward(0.117 * width, 0.304 * height, 0.028 * height, Color.BLACK);
		createCar3Arrow = new ArrowForward(0.117 * width, 0.359 * height, 0.028 * height, Color.BLACK);
		useRoadCar1Arrow = new ArrowForward(0.313 * width, 0.414 * height, 0.028 * height, Color.ORANGE);
		useRoadCar2Arrow = new ArrowForward(0.511 * width, 0.486 * height, 0.028 * height, Color.GREEN);
		useRoadCar3Arrow = new ArrowForward(0.707 * width, 0.549 * height, 0.028 * height,  Color.PINK);
		leftRoadCar1ReturnArrow = new ArrowBackward(0.88 * width, 0.609 * height, 0.028 * height, Color.ORANGE);
		leftRoadCar2ReturnArrow = new ArrowBackward(0.871 * width, 0.783 * height, 0.028 * height, Color.GREEN);
		leftRoadCar3ReturnArrow = new ArrowBackward(0.862 * width, 0.948 * height, 0.028 * height, Color.PINK);
	}
	
	/* (non-Javadoc)
	 * @see sequence.diagram.resource.SequenceDiagramArrowList#addToList()
	 */
	protected void addToList(){
		arrowList.add(createRoadArrow);
		arrowList.add(createCar1Arrow);
		arrowList.add(useRoadCar1Arrow);
		arrowList.add(leftRoadCar1ReturnArrow);
		arrowList.add(createCar2Arrow);
		arrowList.add(useRoadCar2Arrow);
		arrowList.add(leftRoadCar2ReturnArrow);
		arrowList.add(createCar3Arrow);
		arrowList.add(useRoadCar3Arrow);
		arrowList.add(leftRoadCar3ReturnArrow);
	}

	

}
