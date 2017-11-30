package integration.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import state.diagram.CriticalStateDiagram;
import state.diagram.StateDiagram;
import unit.test.MockApplication;

/**
 * Integration test that tests StateDiagram
 * 
 * 
 * @author Satpal Singh
 *
 */
public class CarStateDiagramTest {

	private StateDiagram carSD;

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
	 * Set ups the {@link StateDiagram}
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		carSD = new CriticalStateDiagram();
	}

	/**
	 * Tests the objects within the diagram if they are of right colours
	 */
	@Test
	public void testAiplaneCodeObjectsColor() {
		Circle c1 = ((CriticalStateDiagram) carSD).getFirstObject().getCircle();
		Circle c2 = ((CriticalStateDiagram) carSD).getSecondObject().getCircle();
		Circle c3 = ((CriticalStateDiagram) carSD).getThirdObject().getCircle();
		assertEquals(Color.ORANGE.toString(), c1.getFill().toString());
		assertEquals(Color.GREEN.toString(), c2.getFill().toString());
		assertEquals(Color.PINK.toString(), c3.getFill().toString());
	}

	/**
	 * Tests the objects within the diagram if they are of right labels
	 */
	@Test
	public void testObjectsLabel() {
		Text t1 = ((CriticalStateDiagram) carSD).getFirstObject().getLabel();
		Text t2 = ((CriticalStateDiagram) carSD).getSecondObject().getLabel();
		Text t3 = ((CriticalStateDiagram) carSD).getThirdObject().getLabel();
		assertEquals("1", t1.getText());
		assertEquals("2", t2.getText());
		assertEquals("3", t3.getText());
	}

}
