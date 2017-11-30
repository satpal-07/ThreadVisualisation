package code.panel;

import code.panel.resources.WaitingCodePanelObject;
import gui.ScreenSelection;
import javafx.scene.text.Font;
import state.diagram.resources.CircleObject;

/**
 * Class that represents the code panel for waiting section
 * 
 * @author Satpal Singh
 * @version 1.0
 */
public class WaitingCodePanel extends CodePanel {
	
	//object variables used for thread animation
	private WaitingCodePanelObject circle1;
	private WaitingCodePanelObject circle2;
	
	/**
	 * Creates new instance of the waiting section code to be used in display panel
	 */
	public WaitingCodePanel() {
		super();
		run.setText(sourceCode.getRunMethodCode_WS());
		use.setText(sourceCode.getUseRunwayMethodCode_WS());
		use.setFont(Font.font("Verdana", 15));
		CircleObject.reset();
		circle1 = new WaitingCodePanelObject(0.17 * ScreenSelection.SHOW_CODE_WIDTH,
				52, RADIUS);
		circle2 = new WaitingCodePanelObject(0.15 * ScreenSelection.SHOW_CODE_WIDTH,
				52, RADIUS);
		root.getChildren().addAll(circle1, circle2);
	}
	
	/**
	 * Gets the first thread object
	 * @return CriticalCodePanelObject that represents a thread
	 */
	public WaitingCodePanelObject getFirstObject() {
		return circle1;
	}

	/**
	 * Gets the second thread object
	 * @return CriticalCodePanelObject that represents a thread
	 */
	public WaitingCodePanelObject getSecondObject() {
		return circle2;
	}

	/* (non-Javadoc)
	 * @see code.panel.CodePanel#pause()
	 */
	@Override
	public void pause() {
		circle1.pause();
		circle2.pause();
	}
	
	/* (non-Javadoc)
	 * @see code.panel.CodePanel#play()
	 */
	@Override
	public void play() {
		circle1.play();
		circle2.play();
	}

	/* (non-Javadoc)
	 * @see code.panel.CodePanel#stop()
	 */
	@Override
	public void stop() {
		circle1.stop();
		circle2.stop();
		
	}

}
