/**
 *
 */
package contract;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.IMobile;

/**
 * The Class ModelTest.
 *
 * @author Jean-Aymeric Diet
 */
public class ContractTest {
	
	private Gate gate;
	
//	@Test
//	public void testGetMessageString() {
//		
//	}
	
	@Test
	public void open() {
		this.gate = new Gate(null);
		this.gate.open();
		System.out.println(this.gate.getState());
		Assert.assertEquals(true, this.gate.getState());
	}

}
