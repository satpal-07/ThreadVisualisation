package gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import code.panel.WaitingCodePanel;
import code.panel.CriticalCodePanel;
import code.panel.CodePanel;
import code.panel.resources.CodePanelAnimation;
import diagram.Diagram;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import sequence.diagram.CriticalSequenceDiagram;
import sequence.diagram.SequenceDiagram;
import sequence.diagram.WaitingSequenceDiagram;
import state.diagram.WaitingStateDiagram;
import state.diagram.CriticalStateDiagram;

/**
 * GUI class creates the GUI using JavaFX components
 * 
 * The GUI has two different scenario for thread visualisation which contains animations using JavaFX animations
 * 
 * @author Satpal Singh
 * @version 1.0
 */
public class MainGUI extends Application {

	//GUI components
	private WaitingSequenceDiagram waitingSequenceDiagram;
	private WaitingStateDiagram waitingStateDiagram;
	private CriticalSequenceDiagram criticalSectionSequenceDiagram;
	private CriticalStateDiagram criticalSectionStateDiagram;
	private CriticalCodePanel criticalSectionCodePanel;
	private HBox criticalSectionDiagramHolder;
	private HBox criticalSectionTopPanel;
	private WaitingCodePanel waitingSectionCodePanel;
	private HBox waitingSectionDiagramHolder;
	private HBox waitingSectionTopPanel;
	private VBox waitingSectionHolder;
	private VBox criticalSectionHolder;
	private VBox waitingSectionButtonHolder;
	private VBox criticalSectionButtonHolder;
	private Timeline criticalButtonEnableDelay;
	private Timeline waitingButtonEnableDelay;
	//Buttons
	private Button criticalSectionPlay;
	private Button criticalSectionAboutButton;
	private Button criticalStopButtton;
	private Button criticalPauseButtton;
	private Button criticalSaveButtton;
	private Button waitingSectionPlay;
	private Button waitingSectionAboutButton;
	private Button waitingStopButtton;
	private Button waitingPauseButtton;
	private Button waitingSaveButtton;

	//Tab panels components
	private Tab waitingSectionTab;
	private Tab criticalSectionTab;
	private TabPane tabPane;
	//states of scenarios such as playing and paused
	private PlayState criticalSectionPlayState;
	private PlayState waitingSectionPlayState;

	/**
	 * Creates and lauches the GUI
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			@SuppressWarnings("unused")
			ScreenSelection sc = new ScreenSelection();
			launch(args);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Error: " + e.toString());
		}
		
	}

	@Override
	public void start(Stage primaryStage) {

		primaryStage.getIcons().add(new Image("/ThreadIcon.jpg"));
		// Tab pane
		tabPane = new TabPane();
		// tabs
		waitingSectionTab = new Tab("Wait-Notify Scenario");
		criticalSectionTab = new Tab("Critical Section Scenario");
		waitingSectionTab.setClosable(false);
		criticalSectionTab.setClosable(false);

		tabPane.getTabs().addAll(criticalSectionTab, waitingSectionTab);

		// create Holders
		criticalSectionTopPanel = new HBox();
		criticalSectionDiagramHolder = new HBox();
		criticalSectionTopPanel.setMinHeight(ScreenSelection.SHOW_CODE_HEIGHT);
		criticalSectionHolder = new VBox();
		waitingSectionDiagramHolder = new HBox();
		waitingSectionHolder = new VBox();
		waitingSectionTopPanel = new HBox();
		waitingSectionTopPanel.setMinHeight(ScreenSelection.SHOW_CODE_HEIGHT);
		//set the white background
		criticalSectionTopPanel
				.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		criticalSectionTopPanel.setStyle(
                "-fx-border-style: solid ;" + 
                "-fx-border-width: 0 0 2 0;" +
                "-fx-border-color: Black;");
		
		waitingSectionTopPanel.setStyle(
                "-fx-border-style: solid ;" + 
                "-fx-border-width: 0 0 2 0;" +
                "-fx-border-color: Black;");
		waitingSectionTopPanel
				.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		//close event to close all the processes
		primaryStage.setOnCloseRequest(e -> {
			System.exit(0);
		});

		waitingSectionPlay = new Button("Start");
		waitingSectionPlay.setMinWidth(80);
		waitingSectionPlay.setTooltip(new Tooltip("Plays the visualisation"));
		waitingStopButtton = new Button("Stop");
		waitingStopButtton.setDisable(true);
		waitingStopButtton.setMinWidth(80);
		waitingStopButtton.setTooltip(new Tooltip("Stops the sequence diagram"));
		waitingSectionAboutButton = new Button("About");
		waitingSectionAboutButton.setMinWidth(80);
		waitingSectionAboutButton.setTooltip(new Tooltip("About the waiting section diagram"));
		waitingPauseButtton = new Button("Pause");
		waitingPauseButtton.setMinWidth(80);
		waitingPauseButtton.setDisable(true);
		waitingPauseButtton.setTooltip(new Tooltip("Pauses the waiting section diagram"));
		waitingSaveButtton = new Button("Save");
		waitingSaveButtton.setMinWidth(80);
		waitingSaveButtton.setTooltip(new Tooltip("Saves the sequence diagram"));
		waitingSectionButtonHolder = new VBox();
		waitingSectionButtonHolder.setPrefHeight(180);
		waitingSectionButtonHolder.setSpacing(10);
		waitingSectionButtonHolder.setPadding(new Insets(20));
		waitingSectionButtonHolder.getChildren().addAll(waitingSectionPlay, waitingPauseButtton, waitingStopButtton,
		waitingSaveButtton, waitingSectionAboutButton);
		
		criticalSectionPlay = new Button("Start");
		criticalSectionPlay.setMinWidth(80);
		criticalSectionPlay.setTooltip(new Tooltip("Plays the visualisation"));
		criticalStopButtton = new Button("Stop");
		criticalStopButtton.setDisable(true);
		criticalStopButtton.setMinWidth(80);
		criticalStopButtton.setTooltip(new Tooltip("Stops the visualisation"));
		criticalSectionAboutButton = new Button("About");
		criticalSectionAboutButton.setMinWidth(80);
		criticalSectionAboutButton.setTooltip(new Tooltip("About the waiting section diagram"));
		criticalPauseButtton = new Button("Pause");
		criticalPauseButtton.setMinWidth(80);
		criticalPauseButtton.setDisable(true);
		criticalPauseButtton.setTooltip(new Tooltip("Pauses the visualisation"));
		criticalSaveButtton = new Button("Save");
		criticalSaveButtton.setMinWidth(80);
		criticalSaveButtton.setTooltip(new Tooltip("Saves the sequence diagram"));
		criticalSectionButtonHolder = new VBox();
		criticalSectionButtonHolder.setPrefHeight(180);
		criticalSectionButtonHolder.setSpacing(10);
		criticalSectionButtonHolder.setPadding(new Insets(20));
		criticalSectionButtonHolder.getChildren().addAll(criticalSectionPlay, criticalPauseButtton,
				criticalStopButtton, criticalSaveButtton, criticalSectionAboutButton);

		//create and populate the sections
		createCriticalSectionPanel();
		createWaitingSectionPanel();
		criticalSectionHolder.getChildren().addAll(criticalSectionTopPanel, criticalSectionDiagramHolder);
		criticalSectionTab.setContent(criticalSectionHolder);
		waitingSectionHolder.getChildren().addAll(waitingSectionTopPanel, waitingSectionDiagramHolder);
		waitingSectionTab.setContent(waitingSectionHolder);

		//create the scene and add the scene set up above
		Scene scene = new Scene(tabPane);
		primaryStage.setScene(scene);
		primaryStage.setMaximized(true);
		primaryStage.setTitle("Thread Visualisation");
		primaryStage.show();

		// event listener when the width changes that recalculates the components coordinates
		primaryStage.widthProperty().addListener(e -> {
				ScreenSelection.change(primaryStage.getWidth(), primaryStage.getHeight());
				CodePanelAnimation.recalculate();
				createCriticalSectionPanel();
				stopCriticalSection();
				createWaitingSectionPanel();
				stopWaitingSection();
		});
		// event listener when the height changes that recalculates the components coordinates
		primaryStage.heightProperty().addListener(e -> {
				ScreenSelection.change(primaryStage.getWidth(), primaryStage.getHeight());
				CodePanelAnimation.recalculate();
				createCriticalSectionPanel();
				stopCriticalSection();
				createWaitingSectionPanel();
				stopWaitingSection();
		});
		
		//event listener for critical section saving button
		criticalSaveButtton.setOnAction(e -> {
			saveImage(primaryStage, criticalSectionSequenceDiagram);
		});
		
		//pause button event listener to pause all the animation in the scene in critical section
		criticalPauseButtton.setOnAction(e -> {
			if (criticalSectionPlayState == PlayState.PLAYING) {
				criticalSectionPlayState = PlayState.PAUSED;
				criticalSectionSequenceDiagram.pause();
				criticalSectionStateDiagram.pause();
				criticalSectionCodePanel.pause();
				criticalButtonEnableDelay.pause();
				criticalStopButtton.setDisable(false);
				// pre-check to determine the button has right text
				assert criticalPauseButtton.getText() == "Pause";  
				criticalPauseButtton.setText("Play");
				// pre-check to determine the button is not disabled by other function at the stage
				assert criticalPauseButtton.isDisabled() == false; 
				criticalSaveButtton.setDisable(false);
			} else if (criticalSectionPlayState == PlayState.PAUSED) {
				criticalSectionPlayState = PlayState.PLAYING;
				criticalSectionSequenceDiagram.play();
				criticalSectionStateDiagram.play();
				criticalSectionCodePanel.play();
				criticalButtonEnableDelay.play();
				assert criticalPauseButtton.getText() == "Play"; 
				criticalPauseButtton.setText("Pause");
				assert criticalPauseButtton.isDisabled() == false; 
				assert criticalSaveButtton.isDisabled() == false; 
				criticalSaveButtton.setDisable(true);
				criticalStopButtton.setDisable(false);
				assert criticalSaveButtton.isDisabled() == true; 
			}
		});
		//pause button event listener to pause all the animation in the scene in waiting section
		waitingPauseButtton.setOnAction(e -> {
			if (waitingSectionPlayState == PlayState.PLAYING) {
				waitingSectionPlayState = PlayState.PAUSED;
				waitingSequenceDiagram.pause();
				waitingStateDiagram.pause();
				waitingSectionCodePanel.pause();
				waitingButtonEnableDelay.pause();
				waitingPauseButtton.setText("Play");
				waitingSaveButtton.setDisable(false);
				waitingStopButtton.setDisable(false);
			} else if (waitingSectionPlayState == PlayState.PAUSED) {
				waitingSectionPlayState = PlayState.PLAYING;
				waitingSequenceDiagram.play();
				waitingStateDiagram.play();
				waitingSectionCodePanel.play();
				waitingButtonEnableDelay.play();
				waitingPauseButtton.setText("Pause");
				waitingSaveButtton.setDisable(true);
				waitingStopButtton.setDisable(false);
			}
		});
		//play event listener
		waitingSectionPlay.setOnAction(e -> {
			startWaitingSection();
			temporaryDisableWaitingButton(52);
			waitingSectionPlay.setDisable(true);
			waitingPauseButtton.setDisable(false);
			waitingSaveButtton.setDisable(true);
			waitingStopButtton.setDisable(false);
		});
		
		//event listener for waiting saving button
		waitingSaveButtton.setOnAction(e -> {
			saveImage(primaryStage, waitingSequenceDiagram);
		});
		
		//play and stop event listener
		criticalSectionPlay.setOnAction(e -> {
			startCriticalSection();
			temporaryDisableCriticalButton(63);
			criticalSectionPlay.setDisable(true);
			criticalPauseButtton.setDisable(false);
			criticalSaveButtton.setDisable(true);
			criticalStopButtton.setDisable(false);
		});
		criticalStopButtton.setOnAction(e -> {
			stopCriticalSection();
		});
		
		//about window pop up
		criticalSectionAboutButton.setOnAction(e -> {
			new AboutWindow(primaryStage, false);
		});
		waitingSectionAboutButton.setOnAction(e -> {
			new AboutWindow(primaryStage, true);
		});

		waitingStopButtton.setOnAction(e -> {
			stopWaitingSection();
			
		});

	}

	/**
	 * Disables the buttons of critical scene for specified time in seconds to avoid user clicking buttons which could cause error
	 * @param sec - used as delay factor
	 */
	private void temporaryDisableCriticalButton(int sec) {

		criticalStopButtton.setText("Stop");
		criticalSectionAboutButton.setDisable(true);
		criticalButtonEnableDelay = new Timeline(new KeyFrame(Duration.seconds(sec), ae -> {
			criticalSectionAboutButton.setDisable(false);
			criticalSectionPlay.setDisable(false);
			criticalStopButtton.setText("Reset");
			criticalPauseButtton.setText("Pause");
			criticalPauseButtton.setDisable(true);

		}));
		criticalButtonEnableDelay.play();
	}

	/**
	 * Disables the buttons of waiting scene for specified time in seconds to avoid user clicking buttons which could cause error
	 * @param sec - used as delay factor
	 */
	private void temporaryDisableWaitingButton(int sec) {

		waitingStopButtton.setText("Stop");
		waitingSectionAboutButton.setDisable(true);
		waitingButtonEnableDelay = new Timeline(new KeyFrame(Duration.seconds(sec), ae -> {
			waitingSectionAboutButton.setDisable(false);
			waitingSectionPlay.setDisable(false);
			waitingStopButtton.setText("Reset");
			waitingPauseButtton.setText("Pause");
			waitingPauseButtton.setDisable(true);
		}));
		waitingButtonEnableDelay.play();
	}

	/**
	 * Creates and populates critical section scene with relevant components
	 */
	private void createCriticalSectionPanel() {
		criticalSectionSequenceDiagram = new CriticalSequenceDiagram();
		criticalSectionStateDiagram = new CriticalStateDiagram();
		criticalSectionCodePanel = new CriticalCodePanel();
		addCriticalSectionDiagrams(criticalSectionSequenceDiagram, criticalSectionStateDiagram,
				criticalSectionCodePanel);
		if (criticalButtonEnableDelay != null) {
			criticalButtonEnableDelay.stop();
		}
	}

	/**
	 * Creates and populates waiting section scene with relevant components
	 */
	private void createWaitingSectionPanel() {
		waitingSequenceDiagram = new WaitingSequenceDiagram();
		waitingStateDiagram = new WaitingStateDiagram();
		waitingSectionCodePanel = new WaitingCodePanel();
		addWaitingSectionDiagrams(waitingSequenceDiagram, waitingStateDiagram, waitingSectionCodePanel);
		if (waitingButtonEnableDelay != null) {
			waitingButtonEnableDelay.stop();
		}
	}

	/**
	 * Adds critical section diagrams to the diagram root component
	 */
	private void addCriticalSectionDiagrams(Diagram sequenceDiagram, Diagram stateDiagram, CodePanel codePanel) {
		criticalSectionDiagramHolder.getChildren().clear();
		criticalSectionTopPanel.getChildren().clear();
		stateDiagram.getRoot().setStyle(
                "-fx-border-style: solid;" + 
                "-fx-border-width: 2;" +
                "-fx-border-color: Black;");
		criticalSectionDiagramHolder.getChildren().addAll(sequenceDiagram.getRoot(), stateDiagram.getRoot());
		criticalSectionTopPanel.getChildren().addAll(criticalSectionButtonHolder, codePanel.getRoot());
	}

	/**
	 * Adds waiting section diagrams to the diagram root component
	 */
	private void addWaitingSectionDiagrams(Diagram sequenceDiagram, Diagram stateDiagram, CodePanel codePanel) {
		waitingSectionDiagramHolder.getChildren().clear();
		waitingSectionTopPanel.getChildren().clear();
		waitingSectionDiagramHolder.getChildren().addAll(sequenceDiagram.getRoot(), stateDiagram.getRoot());
		waitingSectionTopPanel.getChildren().addAll(waitingSectionButtonHolder, codePanel.getRoot());
	}

	
	/**
	 * Plays critical section visualisation
	 */
	public void startCriticalSection() {
		//change the state to playing
		criticalSectionPlayState = PlayState.PLAYING;

		//trigger the animation in sequence
		
		// animating the sequence diagram create object interactions
		criticalSectionSequenceDiagram.createRoadMove(0, 5);
		criticalSectionSequenceDiagram.createCar1Move(5, 5);
		criticalSectionSequenceDiagram.createCar2Move(6, 5);
		criticalSectionSequenceDiagram.createCar3Move(6, 5);
		criticalSectionSequenceDiagram.car1UseRoad(10, 5);
		//animation for first thread carrying out its tasks
		//animating the objects in code panel
		criticalSectionCodePanel.getFirstObject().setVisible(true);
		criticalSectionCodePanel.getFirstObject().moveToUseJunction(10);
		criticalSectionCodePanel.getFirstObject().moveToCritical(13);
		criticalSectionStateDiagram.getFirstObject().moveToRunning(10);
		criticalSectionStateDiagram.getFirstObject().moveFromRunningToTerminated(23);
		criticalSectionCodePanel.getFirstObject().moveToUseEnd(23);
		//animation for second thread carrying out its tasks 
		criticalSectionSequenceDiagram.car2UseRoad(11, 5);
		criticalSectionStateDiagram.getSecondObject().moveFromNewToWaiting(11);
		criticalSectionCodePanel.getSecondObject().setVisible(true);
		criticalSectionCodePanel.getSecondObject().moveToUseJunction(11);
		criticalSectionCodePanel.getSecondObject().moveToCritical(28);
		criticalSectionStateDiagram.getSecondObject().moveToRunning(28);
		criticalSectionStateDiagram.getSecondObject().moveFromRunningToTerminated(41);
		criticalSectionCodePanel.getSecondObject().moveToUseEnd(41);
		//animation for third thread carrying out its tasks 
		criticalSectionSequenceDiagram.car3UseRoad(11, 5);
		criticalSectionStateDiagram.getThirdObject().moveFromNewToWaiting(11);
		criticalSectionCodePanel.getThirdObject().setVisible(true);
		criticalSectionCodePanel.getThirdObject().moveToUseJunction(11);
		criticalSectionCodePanel.getThirdObject().moveToCritical(46);
		criticalSectionStateDiagram.getThirdObject().moveToRunning(46);
		criticalSectionSequenceDiagram.car1LeftRoad(23, 5);
		criticalSectionSequenceDiagram.car2LeftRoad(41, 5);
		criticalSectionSequenceDiagram.car3LeftRoad(59, 5);
		criticalSectionStateDiagram.getThirdObject().moveFromRunningToTerminated(59);
		criticalSectionCodePanel.getThirdObject().moveToUseEnd(59);
	}

	/**
	 * Plays wait-notify section visualisation
	 */
	public void startWaitingSection() {
		//change the state to playing
		waitingSectionPlayState = PlayState.PLAYING;

		// animating the sequence diagram create object interactions
		waitingSequenceDiagram.createRunwayMove(0, 5);
		waitingSequenceDiagram.createAirplane1Move(5, 5);
		waitingSequenceDiagram.createAirplane2Move(6, 5);
		
		//trigger the animation in sequence
		
		//animation for first thread carrying out its tasks
		waitingSequenceDiagram.airplane1UseRunway(10, 5);
		waitingSectionCodePanel.getFirstObject().setVisible(true);
		waitingSectionCodePanel.getFirstObject().moveToRunwayUse(10);
		waitingSectionCodePanel.getFirstObject().moveToUseRunwayMethod(11);
		waitingSectionCodePanel.getFirstObject().animateToSetBusyTrue(14);
		waitingSectionCodePanel.getFirstObject().animateToCritical(20);
		waitingSectionCodePanel.getFirstObject().animateToSetBusyFalse(23);
		waitingStateDiagram.getFirstObject().moveToRunning(10);
		waitingStateDiagram.getFirstObject().moveFromRunningToTerminated(23);
		waitingSectionCodePanel.getFirstObject().animateToEndRun(30);
		waitingSequenceDiagram.airplane1Notify(24, 5);
		
		//animation for second thread carrying out its tasks
		waitingSequenceDiagram.airplane2UseRunway(12, 5);
		waitingSequenceDiagram.aiplane2Wait(18, 5);
		waitingStateDiagram.getSecondObject().moveFromNewToWaiting(12);
		waitingSectionCodePanel.getSecondObject().setVisible(true);
		waitingSectionCodePanel.getSecondObject().moveToRunwayUse(12);
		waitingSectionCodePanel.getSecondObject().moveToUseRunwayMethod(13);
		waitingSectionCodePanel.getSecondObject().moveFromUseToWaitSync(16);
		waitingSectionCodePanel.getSecondObject().animateToWait(20);
		waitingSectionCodePanel.getSecondObject().animateFromWaitingToSetBusy(25);
		waitingSectionCodePanel.getSecondObject().animateToCritical(38);
		waitingSectionCodePanel.getSecondObject().animateToSetBusyFalse(42);
		waitingStateDiagram.getSecondObject().moveToRunning(25);
		waitingStateDiagram.getSecondObject().moveFromRunningToTerminated(42);
		waitingSectionCodePanel.getSecondObject().animateToEndRun(49);

		waitingSequenceDiagram.airplane2AcquireRunway(30, 5);
		waitingSequenceDiagram.airplane2Notify(43, 5);

	}

	
	/**
	 * Stops the animation in critical section and resets the objects position to starting point
	 */
	private void stopCriticalSection() {
		criticalSectionPlayState = PlayState.STOPPED;
		criticalSectionSequenceDiagram.stop();
		criticalSectionCodePanel.stop();
		criticalSectionStateDiagram.stop();
		createCriticalSectionPanel();
		if (criticalButtonEnableDelay != null){
			criticalButtonEnableDelay.stop();
		}
		criticalSectionAboutButton.setDisable(false);
		criticalSectionPlay.setDisable(false);
		criticalPauseButtton.setText("Pause");
		criticalPauseButtton.setDisable(true);
		criticalSaveButtton.setDisable(false);
		criticalStopButtton.setDisable(true);
	}

	/**
	 * Stops the animation in wait-notify section and resets the objects position to starting point
	 */
	private void stopWaitingSection() {
		
		waitingSectionPlayState = PlayState.STOPPED;
		waitingSequenceDiagram.stop();
		waitingSectionCodePanel.stop();
		waitingStateDiagram.stop();
		createWaitingSectionPanel();
		if (waitingButtonEnableDelay != null){
			waitingButtonEnableDelay.stop();
		}
		waitingSectionAboutButton.setDisable(false);
		waitingSectionPlay.setDisable(false);
		// changeButton.setDisable(false);
		waitingStopButtton.setDisable(true);
		waitingPauseButtton.setText("Pause");
		waitingPauseButtton.setDisable(true);
		waitingSaveButtton.setDisable(false);
	}

	/**
	 * Saves the image of given snapshot and to given file
	 * @param snapshot - the image to be saved
	 * @param file - the file location where to save the image
	 */
	private void saveImage(Stage primaryStage, SequenceDiagram sequenceDiagram) {
		// Create the save window
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Save sequence diagram as image");
		// Set extension filter
		FileChooser.ExtensionFilter pngFilter = new FileChooser.ExtensionFilter("PNG (*.png)", "*.png");
		FileChooser.ExtensionFilter jpegFilter = new FileChooser.ExtensionFilter("JPEG (*.jpg)", "*.jpg");

		fileChooser.getExtensionFilters().addAll(jpegFilter, pngFilter);

		// Show save file dialog
		File file = fileChooser.showSaveDialog(primaryStage);
		WritableImage snapshot= sequenceDiagram.getRoot().snapshot(new SnapshotParameters(), null);
		if (file != null) {
			BufferedImage image;
			image = javafx.embed.swing.SwingFXUtils.fromFXImage(snapshot,
					new BufferedImage(550, 400, BufferedImage.TYPE_INT_ARGB));
			try {
				ImageIO.write(image, "png", file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
