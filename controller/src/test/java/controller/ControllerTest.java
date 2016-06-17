/**
 *
 */
package controller;

import org.junit.Test;

import contract.IHero;
import contract.IModel;


/**
 * The Class ModelTest.
 *
 * @author Jean-Aymeric Diet
 */
public class ControllerTest {
	private IModel	model;
	
	@Test
	public void testOrderPerform() {
		IHero hero = (IHero) this.model.getMobiles().get(0);
		//Assert.assertNotNull(hero);
		
	}
	
	
}
