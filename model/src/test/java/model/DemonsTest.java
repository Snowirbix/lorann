package model;

import static org.junit.Assert.*;

import org.junit.*;

import contract.IMobile;
import contract.IModel;
import contract.Permeability;

public class DemonsTest {

	Demons demons;
	IModel model;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception { 
		model = new Model();
		model.loadMap(1);
		demons = new Demons(model, 0, 0, new Arrbarr());
		assertNotNull(demons.getSprites().get(demons.getCurrentSprite()));
		assertEquals(demons.getPermeability(), Permeability.BLOCKING);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void onTouchTest() {
		IMobile fireBall = (IMobile) new FireBall(model, 0, 0, 1, 0);
		assertTrue(demons.onTouch(fireBall));
		assertFalse(demons.onTouch((IMobile) demons));
	}

	@Test
	public void moveTest() {
		assertNotNull(demons.move());
	}

}
