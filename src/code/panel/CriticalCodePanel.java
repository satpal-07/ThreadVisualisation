package code.panel;

import code.panel.resources.CriticalCodePanelObject;
import gui.ScreenSelection;
import javafx.scene.text.Font;
import state.diagram.resources.CircleObject;

/**
 * Class that represents the code panel for critical section
 * 
 * @author Satpal Singh
 * @version 1.0
 */
public class CriticalCodePanel extends CodePanel {
	
	//object variables used for thread animation
	private CriticalCodePanelObject thread1;
	private CriticalCodePanelObject thread2;
	private CriticalCodePanelObject thread3;
	
	/**
	 * Creates new instance of critical section code to be used in display panel
	 */
	public CriticalCodePanel() {
		super();
		run.setText(sourceCode.getRunMethodCode_CS());
		use.setText(sourceCode.getUseJunctionMethodCode_WS());
		use.setFont(Font.font("Verdana", 22));
		CircleObject.reset();
		thread1 = new CriticalCodePanelObject(0.17 * ScreenSelection.SHOW_CODE_WIDTH,
				52, RADIUS);
		thread2 = new CriticalCodePanelObject(0.15 * ScreenSelection.SHOW_CODE_WIDTH,
				52, RADIUS);
		thread3 = new CriticalCodePanelObject(0.13 * ScreenSelection.SHOW_CODE_WIDTH,
				52, RADIUS);
		root.getChildren().addAll(thread1, thread2, thread3);
	}
	

	/**
	 * Gets the first thread object
	 * @return CriticalCodePanelObject that represents a thread
	 */
	public CriticalCodePanelObject getFirstObject() {
		return thread1;
	}

	/**
	 * Gets the second thread object
	 * @return CriticalCodePanelObject that represents a thread
	 */
	public CriticalCodePanelObject getSecondObject() {
		return thread2;
	}

	/**
	 * Gets the third thread object
	 * @return CriticalCodePanelObject that represents a thread
	 */
	public CriticalCodePanelObject getThirdObject() {
		return thread3;
	}


	/* (non-Javadoc)
	 * @see code.panel.CodePanel#pause()
	 */
	@Override
	public void pause() {
		thread1.pause();
		thread2.pause();
		thread3.pause();
	}
	
	/* (non-Javadoc)
	 * @see code.panel.CodePanel#play()
	 */
	@Override
	public void play() {
		thread1.play();
		thread2.play();
		thread3.play();
	}


	/* (non-Javadoc)
	 * @see code.panel.CodePanel#stop()
	 */
	@Override
	public void stop() {
		thread1.stop();
		thread2.stop();
		thread3.stop();
		
	}
}
