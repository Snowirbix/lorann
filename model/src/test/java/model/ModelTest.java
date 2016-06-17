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

import contract.IMobile;
import contract.IModel;

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
		this.purse = new Purse(imodel, 0, 0);
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


}
