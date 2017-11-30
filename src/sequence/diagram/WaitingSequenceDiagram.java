package sequence.diagram;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import sequence.diagram.resource.WaitingSequenceArrowList;
import sequence.diagram.resource.ArrowAnimation;
import sequence.diagram.resource.SequenceDiagramArrowList;

/**
 * Class creates sequence diagram for wait-notify section scenario
 * 
 * @author Satpal Singh
 * @version 1.0
 */
public class WaitingSequenceDiagram extends SequenceDiagram {

	// animation coordinates
	private final double[] animationCoordinates = { 0.685, 0.286, 0.678, 0.871, 0.482, 0.669, 0.724, 0.871, 0.880 };
	//list to hold arrows
	private SequenceDiagramArrowList arrows;
	//path transitions
	private PathTransition createRunwayPT;
	private PathTransition createAirplane1PT;
	private PathTransition createAirplane2PT;
	private PathTransition airplane1UseRunwayPT;
	private PathTransition airplane2UseRunwayPT;
	private PathTransition airplane1NotifyPT;
	private PathTransition airplane2NotifyPT;
	private PathTransition airplane2AcquireRunwayPT;
	private PathTransition aiplane2WaitPT;

	
	/**
	 * Creates a new instance of WaitingSequenceDiagram that contains air-plane taking-off scenario
	 */
	public WaitingSequenceDiagram() {
		super("/AirplaneSequence1.jpg");
		arrows = new WaitingSequenceArrowList();
		arrowList = arrows.getArrows();
		root.getChildren().addAll(arrowList);
	}

	/**
	 * Creates and plays the sequence diagram animation of create runway interaction with given duration and delay
	 * @param delay - property to delay the start of the animation in seconds
	 * @param duration - property for the duration of the animation in seconds
	 */
	public void createRunwayMove(int delay, double duration) {
		createRunwayPT = ArrowAnimation.animate(arrowList.get(0), animationCoordinates[0] * width, duration, delay);
		animations.add(createRunwayPT);
		createRunwayPT.play();

	}

	/**
	 * Creates and plays the sequence diagram animation of create airplane 1 interaction with given duration and delay
	 * @param delay - property to delay the start of the animation in seconds
	 * @param duration - property for the duration of the animation in seconds
	 */
	public void createAirplane1Move(int delay, double duration) {
		createAirplane1PT = ArrowAnimation.animate(arrowList.get(1), animationCoordinates[1] * width, duration, delay);
		animations.add(createAirplane1PT);
		createAirplane1PT.play();

	}

	/**
	 * Creates and plays the sequence diagram animation of create airplane 1 using runway interaction with given duration and delay
	 * @param delay - property to delay the start of the animation in seconds
	 * @param duration - property for the duration of the animation in seconds
	 */
	public void airplane1UseRunway(int delay, double duration) {
		airplane1UseRunwayPT = ArrowAnimation.animate(arrowList.get(2), animationCoordinates[2] * width, duration,
				delay);
		animations.add(airplane1UseRunwayPT);
		airplane1UseRunwayPT.play();
	}

	/**
	 * Creates and plays the sequence diagram animation of create airplane 1 notify other waiting airplanes interaction with given duration and delay
	 * @param delay - property to delay the start of the animation in seconds
	 * @param duration - property for the duration of the animation in seconds
	 */
	public void airplane1Notify(int delay, double duration) {
		airplane1NotifyPT = ArrowAnimation.animate(arrowList.get(3), animationCoordinates[3] * width, duration, delay);
		animations.add(airplane1NotifyPT);
		airplane1NotifyPT.play();
	}

	/**
	 * Creates and plays the sequence diagram animation of create airplane 2 interaction with given duration and delay
	 * @param delay - property to delay the start of the animation in seconds
	 * @param duration - property for the duration of the animation in seconds
	 */
	public void createAirplane2Move(int delay, double duration) {
		createAirplane2PT = ArrowAnimation.animate(arrowList.get(4), animationCoordinates[4] * width, duration, delay);
		animations.add(createAirplane2PT);
		createAirplane2PT.play();

	}

	/**
	 * Creates and plays the sequence diagram animation of create airplane 2 using runway interaction with given duration and delay
	 * @param delay - property to delay the start of the animation in seconds
	 * @param duration - property for the duration of the animation in seconds
	 */
	public void airplane2UseRunway(int delay, double duration) {
		airplane2UseRunwayPT = ArrowAnimation.animate(arrowList.get(5), animationCoordinates[5] * width, duration,
				delay);
		animations.add(airplane2UseRunwayPT);
		airplane2UseRunwayPT.play();

	}

	/**
	 * Creates and plays the sequence diagram animation of create airplane 2 acquiring runway interaction with given duration and delay
	 * @param delay - property to delay the start of the animation in seconds
	 * @param duration - property for the duration of the animation in seconds
	 */
	public void airplane2AcquireRunway(int delay, double duration) {
		airplane2AcquireRunwayPT = ArrowAnimation.animate(arrowList.get(6), animationCoordinates[6] * width, duration,
				delay);
		animations.add(airplane2AcquireRunwayPT);
		airplane2AcquireRunwayPT.play();
	}

	/**
	 * Creates and plays the sequence diagram animation of create airplane 2 moving to waiting room interaction with given duration and delay
	 * @param delay - property to delay the start of the animation in seconds
	 * @param duration - property for the duration of the animation in seconds
	 */
	public void aiplane2Wait(int delay, double duration) {
		aiplane2WaitPT = ArrowAnimation.animate(arrowList.get(7), animationCoordinates[7] * width, duration, delay);
		animations.add(aiplane2WaitPT);
		aiplane2WaitPT.play();

	}

	/**
	 * Creates and plays the sequence diagram animation of create airplane 2 notify other waiting airplanes interaction with given duration and delay
	 * @param delay - property to delay the start of the animation in seconds
	 * @param duration - property for the duration of the animation in seconds
	 */
	public void airplane2Notify(int delay, double duration) {
		airplane2NotifyPT = ArrowAnimation.animate(arrowList.get(8), animationCoordinates[8] * width, duration, delay);
		animations.add(airplane2NotifyPT);
		airplane2NotifyPT.play();

	}

	/* (non-Javadoc)
	 * @see diagram.Diagram#reset()
	 */
	@Override
	public void reset() {
		for (PathTransition p : animations) {
			if (p != null)
				p.stop();
		}
		root.getChildren().removeAll(arrowList);
		arrows.reset();
		root.getChildren().addAll(arrowList);
	}

	/* (non-Javadoc)
	 * @see diagram.Diagram#pause()
	 */
	@Override
	public void pause() {
		for (PathTransition p : animations) {
			if (p != null)
				p.pause();
		}
	}

	/* (non-Javadoc)
	 * @see diagram.Diagram#play()
	 */
	@Override
	public void play() {
		for (PathTransition p : animations) {
			if (p != null && p.getStatus() == Animation.Status.PAUSED)
				p.play();
		}
	}

	/* (non-Javadoc)
	 * @see diagram.Diagram#stop()
	 */
	@Override
	public void stop() {
		for (PathTransition p : animations) {
			if (p != null)
				p.stop();
		}
	}
}
