package state.diagram.resources;

import java.util.ArrayList;

import gui.ScreenSelection;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.scene.text.TextFlow;
import javafx.util.Duration;

/**
 * Class that creates Display text to be used in state diagram for stating the movements of thread
 * 
 * @author Satpal Singh
 * @version 1.0
 */
public class StateDiagramText {
	
	//Text components
	private TextFlow textFlow;
	private Text text;
	private String[] textToDisplayCritical; 
	private int index;
	//timeline for playing, pausing and stopping the text display
	private ArrayList<Timeline> timelines;

	/**
	 * Creates a new instance of stateDiagramTect for critical and waiting state scenarios based on the boolean value
	 * @param isWaitingSection - flag to differentiate the scenarios
	 */
	public StateDiagramText(boolean isWaitingSection) {
		textFlow = new TextFlow();
		text = new Text();
		text.setFont(Font.font("Verdana", 0.0125 * ScreenSelection.SCREEN_WIDTH));
		text.setBoundsType(TextBoundsType.VISUAL);
		index = 0;
		// adding text to the Text object based on the scenario
		if (isWaitingSection) {
			textToDisplayCritical = new String[10];
			textToDisplayCritical[0] = "Thread 1 is entering critical section";
			textToDisplayCritical[1] = "Thread 1 has entered critical section";
			textToDisplayCritical[2] = "Thread 1 has finished its task";
			textToDisplayCritical[3] = "Thread 1 has invoked notify method";
			textToDisplayCritical[4] = "Thread 1 has left critical section";
			textToDisplayCritical[5] = "Thread 2 is entering critical section";
			textToDisplayCritical[6] = "Thread 2 has entered critical section";
			textToDisplayCritical[7] = "Thread 2 has finished its task";
			textToDisplayCritical[8] = "Thread 2 has invoked notify method";
			textToDisplayCritical[9] = "Thread 2 has left critical section";
			textFlow.relocate(ScreenSelection.STATE_WIDTH * 0.15 - (text.getLayoutBounds().getWidth() / 2),
					ScreenSelection.STATE_SEQUENCE_HEIGHT * 0.5 - (text.getLayoutBounds().getHeight() / 2));
		} else {
			textToDisplayCritical = new String[9];
			textToDisplayCritical[0] = "Thread 1 is entering critical section";
			textToDisplayCritical[1] = "Thread 1 has entered critical section";
			textToDisplayCritical[2] = "Thread 1 has left critical section";
			textToDisplayCritical[3] = "Thread 2 is entering the critical section";
			textToDisplayCritical[4] = "Thread 2 has entered the critical section";
			textToDisplayCritical[5] = "Thread 2 has left the critical section";
			textToDisplayCritical[6] = "Thread 3 is entering the critical section";
			textToDisplayCritical[7] = "Thread 3 has entered the critical section";
			textToDisplayCritical[8] = "Thread 3 has left the critical section";
			
			textFlow.relocate(ScreenSelection.STATE_WIDTH * 0.30 - (text.getLayoutBounds().getWidth() / 2),
					ScreenSelection.STATE_SEQUENCE_HEIGHT * 0.5 - (text.getLayoutBounds().getHeight() / 2));
		}
		text.setText(textToDisplayCritical[index]);
		index = 0;
		text.setVisible(false);
		textFlow.getChildren().add(text);
		timelines = new ArrayList<Timeline>();
	}

	/**
	 * Changes the text displayed
	 * @param delay - delays the start of the text display in seconds
	 */
	public void changeText(double delay) {

		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(delay), ae -> {
			text.setText(textToDisplayCritical[index]);
			if (index < textToDisplayCritical.length-1)
				index++;
		}));
		timeline.play();
		timelines.add(timeline);

	}

	
	/**
	 * Gets the Text flow object
	 * @return {@link TextFlow}
	 */
	public TextFlow getText() {
		return textFlow;
	}

	
	/**
	 * Resets the variables to defaults
	 */
	public void reset() {
		index = 0;
		setVisible(false, 0);
	}

	/**
	 * Sets the visibility of the text with delayed specified
	 * @param isvisible -  visibility flag
	 * @param delay - delays the setting of visibility
	 */
	public void setVisible(boolean isvisible, double delay) {
		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(delay), ae -> {
			text.setVisible(isvisible);
		}));
		timeline.play();
		timelines.add(timeline);
	}

	/**
	 * Pauses the text changing timelines
	 */
	public void pause() {

		for (Timeline t : timelines) {
			if (t != null)
				t.pause();
		}
	}

	/**
	 * Plays the text changing timelines
	 */
	public void play() {
		for (Timeline t : timelines) {
			if (t != null && t.getStatus() == Animation.Status.PAUSED)
				t.play();
		}
	}

	/**
	 * Stops the text changing timelines
	 */
	public void stop() {

		for (Timeline t : timelines) {
			if (t != null)
				t.stop();
		}
	}

}
