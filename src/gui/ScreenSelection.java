package gui;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * Class that is calculates the heights and widths for the components in GUI
 * 
 * @author Satpal Singh
 * @version 1.0
 */
public class ScreenSelection {

	//Class variable to hold references of widths and heights
	public static double SCREEN_WIDTH;
	public static double SCREEN_HEIGHT;
	public static double STATE_WIDTH;
	public static double SEQUENCE_WIDTH;
	public static double STATE_SEQUENCE_HEIGHT;
	public static double SHOW_CODE_WIDTH;
	public static double SHOW_CODE_HEIGHT;

	/**
	 * Creates new instance of screenselection class and initialises the class variable based on the screen size
	 */
	public ScreenSelection() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		SCREEN_WIDTH = screenSize.getWidth();
		//set the off-set for screen below 1000 to corporate the odd animation of code display panel
		if (screenSize.getHeight() < 1000) {
			SCREEN_HEIGHT = screenSize.getHeight() - 50;
		} else {
			SCREEN_HEIGHT = screenSize.getHeight() - 10;
		}
		STATE_WIDTH = Math.round(0.47916 * SCREEN_WIDTH);
		SEQUENCE_WIDTH = Math.round(0.52083 * SCREEN_WIDTH);
		STATE_SEQUENCE_HEIGHT = Math.round(0.64814 * SCREEN_HEIGHT);
		SHOW_CODE_WIDTH = Math.round(0.89583 * SCREEN_WIDTH);
		SHOW_CODE_HEIGHT = Math.round(0.25925 * SCREEN_HEIGHT);
	}

	/**
	 * Recalculates the widths and heights for all the components based on the given screen width and height
	 * @param width 
	 * @param height
	 */
	public static void change(double width, double height) {
		SCREEN_WIDTH = Math.round(width);
		
		if (height < 1000) SCREEN_HEIGHT = Math.round(height) - 50;
		else SCREEN_HEIGHT = Math.round(height) - 10;
		STATE_WIDTH = Math.round(0.47916 * SCREEN_WIDTH);
		SEQUENCE_WIDTH = Math.round(0.52083 * SCREEN_WIDTH);
		STATE_SEQUENCE_HEIGHT = Math.round(0.64814 * SCREEN_HEIGHT);
		SHOW_CODE_WIDTH = Math.round(0.89583 * SCREEN_WIDTH);
		SHOW_CODE_HEIGHT = Math.round(0.25925 * SCREEN_HEIGHT);
	}

}
