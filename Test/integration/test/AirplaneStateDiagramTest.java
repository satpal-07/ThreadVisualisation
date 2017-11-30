package integration.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import state.diagram.WaitingStateDiagram;
import state.diagram.StateDiagram;
import unit.test.MockApplication;

/**
 * Integration test that tests StateDiagram
 * 
 * 
 * @author Satpal Singh
 *
 */
public class AirplaneStateDiagramTest {
	private StateDiagram airplaneSD;

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
		// create a circle to initialise the JavaFX graphics
		new Circle();
	}

	/**
	 * Set ups the {@link WaitingStateDiagram}
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		airplaneSD = new WaitingStateDiagram();
	}

	/**
	 * Tests the objects within the diagram if they are of right colours
	 */
	@Test
	public void testAiplaneCodeObjectsColor() {
		Circle c1 = ((WaitingStateDiagram) airplaneSD).getFirstObject().getCircle();
		Circle c2 = ((WaitingStateDiagram) airplaneSD).getSecondObject().getCircle();
		assertEquals(Color.ORANGE.toString(), c1.getFill().toString());
		assertEquals(Color.GREEN.toString(), c2.getFill().toString());
	}

	/**
	 * Tests the objects within the diagram if they are of right labels
	 */
	@Test
	public void testObjectsLabel() {
		Text t1 = ((WaitingStateDiagram) airplaneSD).getFirstObject().getLabel();
		Text t2 = ((WaitingStateDiagram) airplaneSD).getSecondObject().getLabel();
		assertEquals("1", t1.getText());
		assertEquals("2", t2.getText());
	}

}
