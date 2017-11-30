package integration.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import code.panel.CriticalCodePanel;
import code.panel.CodePanel;
import code.panel.ThreadCode;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import unit.test.MockApplication;

/**
 * Integration test that tests CodePanel
 * 
 * 
 * @author Satpal Singh
 *
 */
public class CarCodePanelTest {
	
	private CodePanel carCP;
	
	/**
	 * Set up the JavaFX environment for tests
	 * 
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Thread t = new Thread("JavaFX Init Thread") {
	        public void run() {
	            Application.launch(MockApplication.class, new String[0]);
	        }
	    };
	    t.setDaemon(true);
	    t.start();
	    //create a circle to initialise the JavaFX graphics
	    new Circle();
	}

	
	/**
	 * Set ups the {@link CriticalCodePanel}
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		carCP =  new CriticalCodePanel();
	}

	/**
	 * Tests the objects within the code display panel if they are of right colours
	 */
	@Test
	public void testCodeObjectsColor() {
		Circle c1 =  ((CriticalCodePanel)carCP).getFirstObject().getCircle();
		Circle c2 = ((CriticalCodePanel)carCP).getSecondObject().getCircle();
		Circle c3 = ((CriticalCodePanel)carCP).getThirdObject().getCircle();
		assertEquals(Color.ORANGE.toString(), c1.getFill().toString());
		assertEquals(Color.GREEN.toString(), c2.getFill().toString());
		assertEquals(Color.PINK.toString(), c3.getFill().toString());
	}
	
	/**
	 * Tests the objects within the code display panel if they are of right labels
	 */
	@Test
	public void testCodeObjectsLabel() {
		Text t1 =  ((CriticalCodePanel)carCP).getFirstObject().getLabel();
		Text t2 = ((CriticalCodePanel)carCP).getSecondObject().getLabel();
		Text t3 = ((CriticalCodePanel)carCP).getThirdObject().getLabel();
		assertEquals("1", t1.getText());
		assertEquals("2", t2.getText());
		assertEquals("3", t3.getText());
	}
	
	/**
	 * Tests if the code display is right
	 */
	@Test
	public void testCodeDisplay() {
		ThreadCode code = new ThreadCode();
		Text use  = ((CriticalCodePanel)carCP).getUseMethodCode();
		Text run  = ((CriticalCodePanel)carCP).getRunMethodCode();
		assertEquals(code.getUseJunctionMethodCode_WS(), use.getText());
		assertEquals(code.getRunMethodCode_CS(), run.getText());
	}

}
