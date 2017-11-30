package state.diagram;

import state.diagram.resources.StateObject;
import state.diagram.resources.WaitingStateObject;

/**
 * Class creates state diagram for waiting section scenario
 * 
 * @author Satpal Singh
 * @version 1.0
 */
public class WaitingStateDiagram extends StateDiagram {
	
	//Objects to be used as threads in the diagram
	private StateObject circle;
	private StateObject circle2;
	
	/**
	 * Creates as new instance of WaitingStateDiagram represents the state machine diagram for waiting section scenario
	 */
	public WaitingStateDiagram() {
		super("/ThreadStatesWaiting.jpg", true);
		createObjects();
		root.getChildren().addAll(displayText.getText(), circle, circle2);
	}
	
	/**
	 * Gets the first thread object in state machine diagram
	 * @return {@link StateObject}
	 */
	public StateObject getFirstObject() {
		return circle;
	}

	/**
	 * Gets the second thread object in state machine diagram
	 * @return {@link StateObject}
	 */
	public StateObject getSecondObject() {
		return circle2;
	}

	/* (non-Javadoc)
	 * @see state.diagram.StateDiagram#createObjects()
	 */
	@Override
	public void createObjects() {
		circle = new WaitingStateObject(0.229 * width, 0.192 * height, height, width, displayText);
		circle2 = new WaitingStateObject(0.180 * width, 0.192 * height, height, width, displayText);
		
	}

	/* (non-Javadoc)
	 * @see diagram.Diagram#reset()
	 */
	@Override
	public void reset(){
		StateObject.reset();	
		displayText.reset();
		root.getChildren().remove(circle);
		root.getChildren().remove(circle2);		
		createObjects();
		root.getChildren().addAll(circle, circle2);
	}
	
	/* (non-Javadoc)
	 * @see diagram.Diagram#pause()
	 */
	public void pause(){
		circle.pause();
		circle2.pause();
		displayText.pause();
	}
	
	/* (non-Javadoc)
	 * @see diagram.Diagram#play()
	 */
	@Override
	public void play(){
		circle.play();
		circle2.play();
		displayText.play();
	}

	/* (non-Javadoc)
	 * @see diagram.Diagram#stop()
	 */
	@Override
	public void stop() {
		circle.stop();
		circle2.stop();
		displayText.stop();
		
	}

}
