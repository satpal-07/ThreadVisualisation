package sequence.diagram.resource;

import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;

/**
 * Class that creates Display text to be used in critical section scenario sequence diagram
 * 
 * @author Satpal Singh
 * @version 1.0
 */
public class SequenceDiagramDisplayText {
	
	//text variables
	private Text car1;
	private Text car2;
	private Text car3;

	/**
	 * Creates a new instance of the text to be displayed in sequence diagram
	 * @param width - width of the text
	 * @param height - height of the text
	 */
	public SequenceDiagramDisplayText(double width, double height) {
		car1 = new Text("Car 1 acquired \n   the road");
		car2 = new Text("Car 2 acquired \n   the road");
		car3 = new Text("Car 3 acquired \n   the road");
		car1.setBoundsType(TextBoundsType.VISUAL);
		car2.setBoundsType(TextBoundsType.VISUAL);
		car3.setBoundsType(TextBoundsType.VISUAL);
		
		setCar1Visible(false);
		setCar2Visible(false);
		setCar3Visible(false);
		
		car1.setLayoutX(0.715*width);
		car1.setLayoutY(0.445*height);
		
		car2.setLayoutX(0.715*width);
		car2.setLayoutY(0.64*height);
		
		car3.setLayoutX(0.715*width);
		car3.setLayoutY(0.814*height);
	}

	/**
	 * Gets the text object of car 1
	 * @return Text containing the text of car 1
	 */
	public Text getCar1Text() {
		return car1;
	}
	
	/**
	 * Gets the text object of car 2
	 * @return Text containing the text of car 2
	 */
	public Text getCar2Text() {
		return car2;
	}
	
	/**
	 * Gets the text object of car 3
	 * @return Text containing the text of car 3
	 */
	public Text getCar3Text() {
		return car3;
	}

	/**
	 * Resets the text visibility to the default
	 */
	public void reset() {
		setCar1Visible(false);
		setCar2Visible(false);
		setCar3Visible(false);
		setCar1Bold(false);
		setCar2Bold(false);
		setCar3Bold(false);
	}
	
	/**
	 * Sets the visibility of car 1 Text with specified parameter
	 * @param isvisible - boolean true or false visibility
	 */
	public void setCar1Visible(boolean isvisible){
		car1.setVisible(isvisible);
	}
	
	/**
	 * Sets the visibility of car 2 Text with specified parameter
	 * @param isvisible - boolean true or false visibility
	 */
	public void setCar2Visible(boolean isvisible){
		
		car2.setVisible(isvisible);
	}
	
	/**
	 * Sets the visibility of car 3 Text with specified parameter
	 * @param isvisible - boolean true or false visibility
	 */
	public void setCar3Visible(boolean isvisible){
		
		car3.setVisible(isvisible);
	}
	
	
	/**
	 * Sets the bold property of the car 1 Text
	 * @param isBold - boolean true or false Bold
	 */
	public void setCar1Bold(boolean isBold){
		if(isBold)
			car1.setStyle("-fx-font-weight: bold;");
		else
			car1.setStyle("<font-weight>: regular;");
	}
	
	/**
	 * Sets the bold property of the car 2 Text
	 * @param isBold - boolean true or false Bold
	 */
	public void setCar2Bold(boolean isBold){
		
		if(isBold)
			car2.setStyle("-fx-font-weight: bold;");
		else
			car2.setStyle("<font-weight>: regular;");
	}
	
	/**
	 * Sets the bold property of the car 3 Text
	 * @param isBold - boolean true or false Bold
	 */
	public void setCar3Bold(boolean isBold){
		
		if(isBold)
			car3.setStyle("-fx-font-weight: bold;");
		else
			car3.setStyle("<font-weight>: regular;");
	}
}
