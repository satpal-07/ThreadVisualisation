package sequence.diagram;

import java.util.ArrayList;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.util.Duration;
import sequence.diagram.resource.ArrowAnimation;
import sequence.diagram.resource.CriticalSequenceArrowList;
import sequence.diagram.resource.SequenceDiagramArrowList;
import sequence.diagram.resource.SequenceDiagramDisplayText;

/**
 * Class creates sequence diagram for critical section scenario
 * 
 * @author Satpal Singh
 * @version 1.0
 */
public class CriticalSequenceDiagram extends SequenceDiagram {

	// animation coordinates
	private final double[] animationCoordinates = { 0.879, 0.286, 0.871, 0.322, 0.483, 0.861, 0.520, 0.679, 0.851,
			0.717 };
	
	private SequenceDiagramDisplayText displayText;
	//list to hold arrows
	private SequenceDiagramArrowList arrows;
	//path transitions
	private PathTransition createRoadPT;
	private PathTransition createCar1PT;
	private PathTransition createCar2PT;
	private PathTransition createCar3PT;
	private PathTransition car1UseRoadPT;
	private PathTransition car2UseRoadPT;
	private PathTransition car3UseRoadPT;
	private PathTransition car1LeftRoadPT;
	private PathTransition car2LeftRoadPT;
	private PathTransition car3LeftRoadPT;
	//timeline to pause the text display in sequence diagram
	private Timeline car1LeftRoadDelay;
	private Timeline car2LeftRoadDelay;
	private Timeline car3LeftRoadDelay;
	//list to hold the reference to the timeline
	private ArrayList<Timeline> textTimelines;

	/**
	 * Creates as new instance of CriticalSequenceDiagram that contains multiple cars using junction scenario
	 */
	public CriticalSequenceDiagram() {
		super("/CarSequence1.jpg");
		arrows = new CriticalSequenceArrowList();
		arrowList = arrows.getArrows();
		root.getChildren().addAll(arrowList);
		displayText = new SequenceDiagramDisplayText(width, height);
		root.getChildren().addAll(displayText.getCar1Text(), displayText.getCar2Text(), displayText.getCar3Text());
		textTimelines = new ArrayList<Timeline>();
	}

	
	/**
	 * Creates and plays the sequence diagram animation of road create interaction with given duration and delay
	 * @param delay - property to delay the start of the animation in seconds
	 * @param duration - property for the duration of the animation in seconds
	 */
	public void createRoadMove(int delay, int duration) {
		createRoadPT = ArrowAnimation.animate(arrowList.get(0), animationCoordinates[0] * width, duration, delay);
		animations.add(createRoadPT);
		createRoadPT.play();
	}

	/**
	 * Creates and plays the sequence diagram animation of create car 1 interaction with given duration and delay
	 * @param delay - property to delay the start of the animation in seconds
	 * @param duration - property for the duration of the animation in seconds
	 */
	public void createCar1Move(int delay, int duration) {
		createCar1PT = ArrowAnimation.animate(arrowList.get(1), animationCoordinates[1] * width, duration, delay);
		animations.add(createCar1PT);
		createCar1PT.play();

	}

	/**
	 * Creates and plays the sequence diagram animation of car 1 use road interaction with given duration and delay
	 * @param delay - property to delay the start of the animation in seconds
	 * @param duration - property for the duration of the animation in seconds
	 */
	public void car1UseRoad(int delay, int duration) {
		car1UseRoadPT = ArrowAnimation.animateWithText(arrowList.get(2), animationCoordinates[2] * width, duration,
				delay, displayText.getCar1Text());
		animations.add(car1UseRoadPT);
		car1UseRoadPT.play();
	}

	/**
	 * Creates and plays the sequence diagram animation of car 1 left road interaction with given duration and delay
	 * and displays a annotation on the sequence diagram
	 * @param delay - property to delay the start of the animation in seconds
	 * @param duration - property for the duration of the animation in seconds
	 */
	public void car1LeftRoad(int delay, int duration) {
		car1LeftRoadPT = ArrowAnimation.animate(arrowList.get(3), animationCoordinates[3] * width, duration, delay);
		animations.add(car1LeftRoadPT);
		car1LeftRoadPT.play();
		car1LeftRoadDelay = new Timeline(new KeyFrame(
		        Duration.seconds(delay),
		        ae -> {
					displayText.setCar1Bold(false);
					displayText.setCar2Visible(true);
					displayText.setCar2Bold(true);
		        }));
		car1LeftRoadDelay.play();
		textTimelines.add(car1LeftRoadDelay);
	}

	/**
	 * Creates and plays the sequence diagram animation of create car 2 interaction with given duration and delay
	 * @param delay - property to delay the start of the animation in seconds
	 * @param duration - property for the duration of the animation in seconds
	 */
	public void createCar2Move(int delay, int duration) {
		createCar2PT = ArrowAnimation.animate(arrowList.get(4), animationCoordinates[4] * width, duration, delay);
		animations.add(createCar2PT);
		createCar2PT.play();

	}

	/**
	 * Creates and plays the sequence diagram animation of car 2 use road interaction with given duration and delay
	 * @param delay - property to delay the start of the animation in seconds
	 * @param duration - property for the duration of the animation in seconds
	 */
	public void car2UseRoad(int delay, int duration) {
		car2UseRoadPT = ArrowAnimation.animate(arrowList.get(5), animationCoordinates[5] * width, duration, delay);
		animations.add(car2UseRoadPT);
		car2UseRoadPT.play();

	}

	/**
	 * Creates and plays the sequence diagram animation of car 2 left road interaction with given duration and delay
	 * and displays a annotation on the sequence diagram
	 * @param delay - property to delay the start of the animation in seconds
	 * @param duration - property for the duration of the animation in seconds
	 */
	public void car2LeftRoad(int delay, int duration) {
		car2LeftRoadPT = ArrowAnimation.animate(arrowList.get(6), animationCoordinates[6] * width, duration, delay);
		animations.add(car2LeftRoadPT);
		car2LeftRoadPT.play();
		car2LeftRoadDelay = new Timeline(new KeyFrame(
		        Duration.seconds(delay),
		        ae -> {
		        	displayText.setCar2Bold(false);
					displayText.setCar3Visible(true);
					displayText.setCar3Bold(true);
		        }));
		car2LeftRoadDelay.play();
		textTimelines.add(car2LeftRoadDelay);
	}

	/**
	 * Creates and plays the sequence diagram animation of create car 3 interaction with given duration and delay
	 * @param delay - property to delay the start of the animation in seconds
	 * @param duration - property for the duration of the animation in seconds
	 */
	public void createCar3Move(int delay, int duration) {
		createCar3PT = ArrowAnimation.animate(arrowList.get(7), animationCoordinates[7] * width, duration, delay);
		animations.add(createCar3PT);
		createCar3PT.play();

	}

	/**
	 * Creates and plays the sequence diagram animation of car 3 use road interaction with given duration and delay
	 * @param delay - property to delay the start of the animation in seconds
	 * @param duration - property for the duration of the animation in seconds
	 */
	public void car3UseRoad(int delay, int duration) {
		car3UseRoadPT = ArrowAnimation.animate(arrowList.get(8), animationCoordinates[8] * width, duration, delay);
		animations.add(car3UseRoadPT);
		car3UseRoadPT.play();

	}

	/**
	 * Creates and plays the sequence diagram animation of car 3 left road interaction with given duration and delay
	 * and displays a annotation on the sequence diagram
	 * @param delay - property to delay the start of the animation in seconds
	 * @param duration - property for the duration of the animation in seconds
	 */
	public void car3LeftRoad(int delay, int duration) {
		car3LeftRoadPT = ArrowAnimation.animate(arrowList.get(9), animationCoordinates[9] * width, duration, delay);
		animations.add(car3LeftRoadPT);
		car3LeftRoadPT.play();
		car3LeftRoadDelay = new Timeline(new KeyFrame(
		        Duration.seconds(delay),
		        ae -> {
		        	displayText.setCar3Bold(false);
		        }));
		car3LeftRoadDelay.play();
		textTimelines.add(car3LeftRoadDelay);

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
		for (Timeline t : textTimelines) {
			if (t != null)
				t.stop();
		}
		root.getChildren().removeAll(arrowList);
		arrows.reset();
		displayText.reset();
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
		for (Timeline t : textTimelines) {
			if (t != null)
				t.pause();
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
		for (Timeline t : textTimelines) {
			if (t != null && t.getStatus() == Animation.Status.PAUSED)
				t.play();
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
		for (Timeline t : textTimelines) {
			if (t != null)
				t.stop();
		}

	}
}
