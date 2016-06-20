/**
 *
 */
package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.IHero;
import contract.IMobile;
import contract.IModel;
import contract.IStrategy;

/**
 * The Class ModelTest.
 *
 * @author Jean-Aymeric Diet
 */
public class ModelTest {
	private Gate gate;
	private int score;
	private Save save;
	private IModel imodel;
	private IMobile activator;
	private Purse purse;
	private Demons demons;
	private HighScore highScore;
	private Map map;

	/**
	 * Sets the up before class.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Tear down after class.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Sets the up.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@Before
	public void setUp() throws Exception {
		this.save = new Save();
		Assert.assertEquals(0, this.save.getLife());
		Assert.assertEquals(0, this.save.getScore());
		
		this.save = new Save(10, 20);
		Assert.assertEquals(10, this.save.getLife());
		Assert.assertEquals(20, this.save.getScore());
				
		this.purse = new Purse(imodel, 0, 0);
		
		this.highScore = new HighScore(5);
		Assert.assertEquals(5, this.highScore.getScore());
		
		this.highScore = new HighScore();
		Assert.assertEquals(0, this.highScore.getScore());
		
		this.map = new Map();
		Assert.assertEquals(0, this.map.getWidth());
		Assert.assertEquals(0, this.map.getHeight());
		Assert.assertEquals("", this.map.getMap());
		
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception
	 *           the exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void open() {
		this.gate = new Gate(null);
		this.gate.open();
		Assert.assertEquals(true, this.gate.getState());
	}
	
	@Test
	public void onTouch() {
		Assert.assertEquals(false, purse.onTouch(activator));
	}
	
	@Test
	public void SetScore() {
		int test = 0;
		save.setScore(test);
		Assert.assertEquals(test, this.score);
	}
	
	@Test
	public void Demons() {
		IStrategy strat = new Kyracj();
		this.demons = new Demons(imodel , 1 , 1, strat);
		//System.out.println(contract.Element.setCurrentSprite(0));
		//Assert.assertEquals(setCurrentSprite(0), false)
	}
	
	@Test
	public void testOnTouch() {
		IStrategy strat = null;
		this.demons = new Demons(imodel , 1 , 1, strat);
		this.activator = new FireBall(imodel, score, score, score, score);
		//Assert.assertEquals(false,demons.onTouch(activator));
	}
	
	@Test
	public void setLife() {
		this.save = new Save(10, 20);
		save.setLife(5);
		Assert.assertEquals(15, save.getLife());
	}
	
	@Test
	public void setScore() {
		this.save = new Save(10, 20);
		save.setScore(5);
		Assert.assertEquals(25, save.getScore());
	}
	
	
}
