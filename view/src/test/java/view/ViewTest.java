/**
 *
 */
package view;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.ControllerOrder;
import contract.IMobile;

/**
 * The Class ModelTest.
 *
 * @author Jean-Aymeric Diet
 */
public class ViewTest {
	
	@Test
	public void keyCodeToControllerOrder(){
		System.out.println(View.keyCodeToControllerOrder(1, false));
		Assert.assertEquals(ControllerOrder.NOOP, View.keyCodeToControllerOrder(1, false));
		Assert.assertEquals(ControllerOrder.UP, View.keyCodeToControllerOrder(38, true));
		Assert.assertEquals(ControllerOrder._UP, View.keyCodeToControllerOrder(38, false));
		Assert.assertEquals(ControllerOrder.LEFT, View.keyCodeToControllerOrder(37, true));
		Assert.assertEquals(ControllerOrder._LEFT, View.keyCodeToControllerOrder(37, false));
		Assert.assertEquals(ControllerOrder.RIGHT, View.keyCodeToControllerOrder(39, true));
		Assert.assertEquals(ControllerOrder._RIGHT, View.keyCodeToControllerOrder(39, false));
		Assert.assertEquals(ControllerOrder.DOWN, View.keyCodeToControllerOrder(40, true));
		Assert.assertEquals(ControllerOrder._DOWN, View.keyCodeToControllerOrder(40, false));
		Assert.assertEquals(ControllerOrder.ATTACK, View.keyCodeToControllerOrder(32, true));
		Assert.assertEquals(ControllerOrder._ATTACK, View.keyCodeToControllerOrder(32, false));
	}
	
}
