package unit.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import state.diagram.resources.CircleObject;

/**
 * Unit test that tests CircleObject module
 * 
 * 
 * @author Satpal Singh
 *
 */
public class CircleObjectTest {

	private CircleObject co1;
	private CircleObject co2;
	private CircleObject co3;

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
	 * Set ups the objects
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {

		double centerX = 100;
		double centerY = 100;
		double radius = 20;
		co1 = new CircleObject(centerX, centerY, radius);
		co2 = new CircleObject(centerX, centerY, radius);
		co3 = new CircleObject(centerX, centerY, radius);

	}

	@After
	public void tearDown() throws Exception {
		CircleObject.reset();
	}

	/**
	 * Tests the radius of the objects
	 */
	@Test
	public void testRadius() {
		Circle c1 = co1.getCircle();
		Circle c2 = (Circle) co2.getCircle();
		Circle c3 = (Circle) co3.getCircle();
		assertEquals(20.0, c1.getRadius(), 0.0);
		assertEquals(20.0, c2.getRadius(), 0.0);
		assertEquals(20.0, c3.getRadius(), 0.0);

	}

	/**
	 * Tests the colour of the objects
	 */
	@Test
	public void testColor() {
		Circle c1 = co1.getCircle();
		Circle c2 = co2.getCircle();
		Circle c3 = co3.getCircle();
		assertEquals(Color.ORANGE.toString(), c1.getFill().toString());
		assertEquals(Color.GREEN.toString(), c2.getFill().toString());
		assertEquals(Color.PINK.toString(), c3.getFill().toString());

	}

	/**
	 * Tests the label of the objects
	 */
	@Test
	public void testLabel() {
		Text t1 = co1.getLabel();
		Text t2 = co2.getLabel();
		Text t3 = co3.getLabel();
		assertEquals("1", t1.getText());
		assertEquals("2", t2.getText());
		assertEquals("3", t3.getText());

	}

}
