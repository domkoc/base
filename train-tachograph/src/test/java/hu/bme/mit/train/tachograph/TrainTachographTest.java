package hu.bme.mit.train.tachograph;

import hu.bme.mit.train.tachograph.TrainTachograph;
import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;

public class TrainTachographTest {

	TrainTachograph tachograph;
	
	@Before
	public void before() {
		tachograph = new TrainTachograph();
	}
	
	@Test
	public void CheckIfTachographTableIsNotEmpty() {
		Assert.assertFalse(tachograph.TableIsEmpty());
	}
}
