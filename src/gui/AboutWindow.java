package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * Class creates the about window that explains the diagrams used as visuals
 * 
 * @author Satpal Singh
 * @version 1.0
 */
public class AboutWindow {

	// about window variables
	private VBox criricalDialogVbox;
	private VBox waitingDialogVbox;
	private Button criticalNextButton;
	private Button criticalPrevButton;
	private Button waitingNextButton;
	private Button waitingPrevButton;
	private int criticalDiagramCounter;
	private int waitingDiagramCounter;
	private StackPane criticalButtons;
	private StackPane criticalButtonHolder;
	private StackPane criticalHeadingHolder;
	private Text criticalHeading;
	private StackPane waitingButtons;
	private StackPane waitingButtonHolder;
	private StackPane waitingHeadingHolder;
	private Text waitingHeading;

	// image holders
	private ImageView[] criticalDiagramsView;
	private ImageView[] waitingDiagramsView;

	/**
	 * Creates new instance of about window that contains images and explanation
	 * of the diagrams used in the system
	 * 
	 * @param primaryStage
	 * @param isWaiting
	 */
	public AboutWindow(Window primaryStage, boolean isWaiting) {

		// create the stage
		Stage dialog = new Stage();
		criticalHeading = new Text();
		criticalHeading.setText("Thread execution without waiting room");
		criticalHeading.setFont(new Font(32));
		waitingHeading = new Text();
		waitingHeading.setText("Thread execution with waiting room");
		waitingHeading.setFont(new Font(32));

		dialog.setTitle("About");
		dialog.getIcons().add(new Image("/QuestionIcon.jpg"));
		dialog.setResizable(false);
		dialog.initModality(Modality.APPLICATION_MODAL);
		dialog.initOwner(primaryStage);
		criticalButtonHolder = new StackPane();
		criticalButtons = new StackPane();
		waitingButtonHolder = new StackPane();
		waitingButtons = new StackPane();
		criticalDiagramsView = new ImageView[8];
		// add the images to the container
		criticalDiagramsView[0] = new ImageView(new Image("/CarThreadAnnotated.jpg"));
		criticalDiagramsView[1] = new ImageView(new Image("/CarSharedAnnotated.jpg"));
		criticalDiagramsView[2] = new ImageView(new Image("/CarThreadLifelinesAnnotated.jpg"));
		criticalDiagramsView[3] = new ImageView(new Image("/CarThreadTimeAnnocated.jpg"));
		criticalDiagramsView[4] = new ImageView(new Image("/ThreadStateNewCS.jpg"));
		criticalDiagramsView[5] = new ImageView(new Image("/ThreadStateWaitingCS.jpg"));
		criticalDiagramsView[6] = new ImageView(new Image("/ThreadStateCriticalCS.jpg"));
		criticalDiagramsView[7] = new ImageView(new Image("/ThreadStateTerminateCS.jpg"));

		waitingDiagramsView = new ImageView[11];
		waitingDiagramsView[0] = new ImageView(new Image("/AirplaneThreadAnnotated.jpg"));
		waitingDiagramsView[1] = new ImageView(new Image("/AirplaneSharedAnnotated.jpg"));
		waitingDiagramsView[2] = new ImageView(new Image("/AirplaneWaitingAnnotated.jpg"));
		waitingDiagramsView[3] = new ImageView(new Image("/AirplaneLifelinesAnnotated.jpg"));
		waitingDiagramsView[4] = new ImageView(new Image("/AirplaneThreadTimeAnnotated.jpg"));
		waitingDiagramsView[5] = new ImageView(new Image("/AirplaneWaitingTimeAnnotated.jpg"));
		waitingDiagramsView[6] = new ImageView(new Image("/ThreadStateNewWS.jpg"));
		waitingDiagramsView[7] = new ImageView(new Image("/ThreadStateWaitingCriticalWS.jpg"));
		waitingDiagramsView[8] = new ImageView(new Image("/ThreadStateWaitingConditionWS.jpg"));
		waitingDiagramsView[9] = new ImageView(new Image("/ThreadStateCriticalWS.jpg"));
		waitingDiagramsView[10] = new ImageView(new Image("/ThreadStateTerminateWS.jpg"));
		// set the width and height of the images
		for (int i = 0; i < criticalDiagramsView.length; i++) {
			criticalDiagramsView[i].setFitWidth(1010);
			criticalDiagramsView[i].setFitHeight(740);
		}
		for (int i = 0; i < waitingDiagramsView.length; i++) {
			waitingDiagramsView[i].setFitWidth(1010);
			waitingDiagramsView[i].setFitHeight(740);
		}
		criticalDiagramCounter = 0;
		waitingDiagramCounter = 0;
		criricalDialogVbox = new VBox();
		waitingDialogVbox = new VBox();
		criricalDialogVbox
				.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		waitingDialogVbox
				.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		criticalNextButton = new Button("Next");
		criticalNextButton.setPrefWidth(100);
		criticalPrevButton = new Button("Previous");
		criticalPrevButton.setPrefWidth(100);
		waitingNextButton = new Button("Next");
		waitingNextButton.setPrefWidth(100);
		waitingPrevButton = new Button("Previous");
		waitingPrevButton.setPrefWidth(100);
		StackPane.setAlignment(criticalPrevButton, Pos.CENTER_LEFT);
		StackPane.setAlignment(criticalNextButton, Pos.CENTER_RIGHT);
		criticalButtons.getChildren().addAll(criticalPrevButton, criticalNextButton);
		criticalButtons.setMaxWidth(250);
		StackPane.setAlignment(criticalButtons, Pos.CENTER);
		criticalButtonHolder.getChildren().add(criticalButtons);

		StackPane.setAlignment(waitingPrevButton, Pos.CENTER_LEFT);
		StackPane.setAlignment(waitingNextButton, Pos.CENTER_RIGHT);
		waitingButtons.getChildren().addAll(waitingPrevButton, waitingNextButton);
		waitingButtons.setMaxWidth(250);
		StackPane.setAlignment(waitingButtons, Pos.CENTER);
		waitingButtonHolder.getChildren().add(waitingButtons);

		criticalHeadingHolder = new StackPane();
		StackPane.setAlignment(criticalHeading, Pos.CENTER);
		criticalHeadingHolder.getChildren().add(criticalHeading);
		VBox.setMargin(criticalButtonHolder, new Insets(10));

		waitingHeadingHolder = new StackPane();
		StackPane.setAlignment(waitingHeading, Pos.CENTER);
		waitingHeadingHolder.getChildren().add(waitingHeading);
		VBox.setMargin(waitingButtonHolder, new Insets(10));

		criricalDialogVbox.getChildren().addAll(criticalHeadingHolder, criticalDiagramsView[criticalDiagramCounter],
				criticalButtonHolder);
		Scene criticalDialogScene = new Scene(criricalDialogVbox, 1000, 840);
		waitingDialogVbox.getChildren().addAll(waitingHeadingHolder, waitingDiagramsView[waitingDiagramCounter],
				waitingButtonHolder);
		Scene waitingDialogScene = new Scene(waitingDialogVbox, 1000, 840);

		// show the scenario for particular diagram based on the scenario where the event is triggered
		if (!isWaiting) dialog.setScene(criticalDialogScene);
		else dialog.setScene(waitingDialogScene);
		//show the window
		dialog.show();
		
		//add events to prev and next buttons
		criticalNextButton.setOnMouseClicked(e -> criticalNext());
		criticalPrevButton.setOnMouseClicked(e -> criticalPrev());
		criticalPrevButton.setDisable(true);
		waitingNextButton.setOnMouseClicked(e -> waitingNext());
		waitingPrevButton.setOnMouseClicked(e -> waitingPrev());
		waitingPrevButton.setDisable(true);
	}

	/**
	 * Shows the previous image for the critical help section
	 */
	private void criticalPrev() {
		criticalDiagramCounter--;
		criricalDialogVbox.getChildren().clear();
		criricalDialogVbox.getChildren().addAll(criticalHeadingHolder, criticalDiagramsView[criticalDiagramCounter],
				criticalButtonHolder);
		if (criticalDiagramCounter > criticalDiagramsView.length)
			criticalDiagramCounter = 0;
		if (criticalDiagramCounter == 0)
			criticalPrevButton.setDisable(true);
		if (criticalDiagramCounter < criticalDiagramsView.length)
			criticalNextButton.setDisable(false);

	}
	/**
	 * Shows the next image for the critical help section
	 */
	private void criticalNext() {
		criticalDiagramCounter++;
		criricalDialogVbox.getChildren().clear();
		criricalDialogVbox.getChildren().addAll(criticalHeadingHolder, criticalDiagramsView[criticalDiagramCounter],
				criticalButtonHolder);

		if (criticalDiagramCounter > criticalDiagramsView.length)
			criticalDiagramCounter = 0;
		if (criticalDiagramCounter > 0)
			criticalPrevButton.setDisable(false);
		if (criticalDiagramCounter == criticalDiagramsView.length - 1)
			criticalNextButton.setDisable(true);
	}

	/**
	 * Shows the previous image for the waiting help section
	 */
	private void waitingPrev() {
		waitingDiagramCounter--;
		waitingDialogVbox.getChildren().clear();
		waitingDialogVbox.getChildren().addAll(waitingHeadingHolder, waitingDiagramsView[waitingDiagramCounter],
				waitingButtonHolder);
		if (waitingDiagramCounter > waitingDiagramsView.length)
			waitingDiagramCounter = 0;
		if (waitingDiagramCounter == 0)
			waitingPrevButton.setDisable(true);
		if (waitingDiagramCounter < waitingDiagramsView.length)
			waitingNextButton.setDisable(false);

	}

	/**
	 * Shows the next image for the critical help section
	 */
	private void waitingNext() {
		waitingDiagramCounter++;
		waitingDialogVbox.getChildren().clear();
		waitingDialogVbox.getChildren().addAll(waitingHeadingHolder, waitingDiagramsView[waitingDiagramCounter],
				waitingButtonHolder);

		if (waitingDiagramCounter > waitingDiagramsView.length)
			waitingDiagramCounter = 0;
		if (waitingDiagramCounter > 0)
			waitingPrevButton.setDisable(false);
		if (waitingDiagramCounter == waitingDiagramsView.length - 1)
			waitingNextButton.setDisable(true);
	}
}
