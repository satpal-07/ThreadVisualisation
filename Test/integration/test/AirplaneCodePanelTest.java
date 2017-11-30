package integration.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import code.panel.WaitingCodePanel;
import code.panel.CodePanel;
import code.panel.ThreadCode;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import state.diagram.WaitingStateDiagram;
import state.diagram.StateDiagram;
import unit.test.MockApplication;

/**
 * Integration test that tests both WaitingCodePanel and WaitingStateDiagram
 * 
 * 
 * @author Satpal Singh
 *
 */
public class AirplaneCodePanelTest {

	private CodePanel airplaneCP;
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
	}

	/**
	 * Set ups the {@link WaitingCodePanel} and {@link WaitingStateDiagram}
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		airplaneCP = new WaitingCodePanel();
		airplaneSD = new WaitingStateDiagram();
	}

	/**
	 * Tests the objects within the WaitingCodePanel if they are of right colour
	 */
	@Test
	public void testAiplaneCodeObjectsColor() {
		Circle c1 = ((WaitingCodePanel) airplaneCP).getFirstObject().getCircle();
		Circle c2 = ((WaitingCodePanel) airplaneCP).getSecondObject().getCircle();
		assertEquals(Color.ORANGE.toString(), c1.getFill().toString());
		assertEquals(Color.GREEN.toString(), c2.getFill().toString());
	}

	/**
	 * Tests the objects within the WaitingStateDiagram if they are of right colours
	 */
	@Test
	public void testAiplaneCodeObjectsColor1() {
		Circle c1 = ((WaitingStateDiagram) airplaneSD).getFirstObject().getCircle();
		Circle c2 = ((WaitingStateDiagram) airplaneSD).getSecondObject().getCircle();
		assertEquals(Color.ORANGE.toString(), c1.getFill().toString());
		assertEquals(Color.GREEN.toString(), c2.getFill().toString());
	}

	/**
	 * Tests the objects within the WaitingStateDiagram if they are of right labels
	 */
	@Test
	public void testObjectsLabel1() {
		Text t1 = ((WaitingStateDiagram) airplaneSD).getFirstObject().getLabel();
		Text t2 = ((WaitingStateDiagram) airplaneSD).getSecondObject().getLabel();
		assertEquals("1", t1.getText());
		assertEquals("2", t2.getText());
	}

	/**
	 * Tests the objects within the WaitingCodePanel if they are of right labels
	 */
	@Test
	public void testObjectsLabel() {
		Text t1 = ((WaitingCodePanel) airplaneCP).getFirstObject().getLabel();
		Text t2 = ((WaitingCodePanel) airplaneCP).getSecondObject().getLabel();
		assertEquals("1", t1.getText());
		assertEquals("2", t2.getText());
	}

	/**
	 * Tests if the code display is right
	 */
	@Test
	public void testCodeDisplay() {
		ThreadCode code = new ThreadCode();
		Text use = ((WaitingCodePanel) airplaneCP).getUseMethodCode();
		Text run = ((WaitingCodePanel) airplaneCP).getRunMethodCode();
		assertEquals(code.getUseRunwayMethodCode_WS(), use.getText());
		assertEquals(code.getRunMethodCode_WS(), run.getText());
	}

}
