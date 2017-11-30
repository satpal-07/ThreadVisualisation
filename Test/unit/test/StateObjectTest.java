package unit.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import gui.ScreenSelection;
import javafx.application.Application;
import state.diagram.resources.CriticalStateObject;
import state.diagram.resources.StateDiagramText;
import state.diagram.resources.StateObject;
import thread.ThreadState;

/**
 * Unit test that tests StateObject module
 * 
 * 
 * @author Satpal Singh
 *
 */
public class StateObjectTest {
	private StateObject so1;
	private StateObject so2;
	private StateObject so3;

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
	 * Set-up the objects
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		double centerX = 100;
		double centerY = 100;
		StateDiagramText dt = new StateDiagramText(true);
		so1 = new CriticalStateObject(centerX, centerY, ScreenSelection.STATE_SEQUENCE_HEIGHT,
				ScreenSelection.STATE_WIDTH, dt);
		so2 = new CriticalStateObject(centerX, centerY, ScreenSelection.STATE_SEQUENCE_HEIGHT,
				ScreenSelection.STATE_WIDTH, dt);
		so3 = new CriticalStateObject(centerX, centerY, ScreenSelection.STATE_SEQUENCE_HEIGHT,
				ScreenSelection.STATE_WIDTH, dt);
	}

	@After
	public void tearDown() throws Exception {
		StateObject.reset();
	}

	/**
	 * Tests the instance of the object
	 */
	@Test
	public void testIsFirstInstance() {
		assertTrue(so1.isFirstInstance());
		assertFalse(so2.isFirstInstance());
		assertFalse(so3.isFirstInstance());
	}

	/**
	 * Tests of the the objects are in right state
	 */
	@Test
	public void testState() {
		assertEquals(ThreadState.NEW, so1.getState());
		assertEquals(ThreadState.NEW, so2.getState());
		assertEquals(ThreadState.NEW, so3.getState());
	}

	/**
	 * Tests the label of the objects
	 */
	@Test
	public void testStateNumber() {
		assertEquals(1, so1.getNumber());
		assertEquals(2, so2.getNumber());
		assertEquals(3, so3.getNumber());
	}

}
