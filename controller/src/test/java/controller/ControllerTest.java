/**
 *
 */
package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.ControllerOrder;
import contract.IHero;
import contract.IMobile;
import contract.IModel;
import contract.IView;

/**
 * The Class ModelTest.
 *
 * @author Jean-Aymeric Diet
 */
public class ControllerTest {
	private IView	view;
	private IModel	model;
	private ControllerOrder controllerOrder;
	
	@Test
	public void testOrderPerform() {
		IHero hero = (IHero) this.model.getMobiles().get(0);
		//Assert.assertNotNull(hero);
		
	}
	
	
}
