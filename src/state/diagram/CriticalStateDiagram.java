package state.diagram;

import state.diagram.resources.CriticalStateObject;
import state.diagram.resources.StateObject;

/**
 * Class creates state diagram for critical section scenario
 * 
 * @author Satpal Singh
 * @version 1.0
 */
public class CriticalStateDiagram extends StateDiagram {
	
	//Objects to be used as threads in the diagram
	private StateObject circle1;
	private StateObject circle2;
	private StateObject circle3;
	
	/**
	 * Creates as new instance of CriticalStateDiagram represents the state machine diagram for critical section scenario
	 */
	public CriticalStateDiagram() {
		super("/ThreadStatesCritical.jpg", false);
		createObjects();
		root.getChildren().addAll(displayText.getText(), circle1, circle2, circle3);
	}
	
	/* (non-Javadoc)
	 * @see state.diagram.StateDiagram#createObjects()
	 */
	public void createObjects(){
		circle1 = new CriticalStateObject(0.229 * width, 0.192 * height, height, width, displayText);
		circle2 = new CriticalStateObject(0.180 * width, 0.192 * height, height, width, displayText);
		circle3 = new CriticalStateObject(0.131 * width, 0.192 * height, height, width, displayText);
	}
	
	/**
	 * Gets the first thread object in state machine diagram
	 * @return {@link StateObject}
	 */
	public StateObject getFirstObject() {
		return circle1;
	}

	/**
	 * Gets the second thread object in state machine diagram
	 * @return {@link StateObject}
	 */
	public StateObject getSecondObject() {
		return circle2;
	}

	/**
	 * Gets the third thread object in state machine diagram
	 * @return {@link StateObject}
	 */
	public StateObject getThirdObject() {
		return circle3;
	}
	
	/* (non-Javadoc)
	 * @see diagram.Diagram#reset()
	 */
	@Override
	public void reset(){
		StateObject.reset();	
		displayText.reset();
		root.getChildren().remove(circle1);
		root.getChildren().remove(circle2);
		root.getChildren().remove(circle3);		
		createObjects();
		root.getChildren().addAll(circle1, circle2, circle3);
	}

	
	/* (non-Javadoc)
	 * @see diagram.Diagram#pause()
	 */
	@Override
	public void pause() {
		circle1.pause();
		circle2.pause();
		circle3.pause();
		displayText.pause();
	}
	
	
	/* (non-Javadoc)
	 * @see diagram.Diagram#play()
	 */
	@Override
	public void play() {
		circle1.play();
		circle2.play();
		circle3.play();
		displayText.play();
	}

	
	/* (non-Javadoc)
	 * @see diagram.Diagram#stop()
	 */
	@Override
	public void stop() {
		circle1.stop();
		circle2.stop();
		circle3.stop();
		displayText.stop();
	}
	
	
}
