import static org.junit.Assert.*;

import org.junit.Test;

public class MountainTest {

	Mountain mntn = new Mountain(3,6);
	
	@Test
	public void testGetPeakLoc() {
		assertEquals("getPeakLoc() did not return correct value.",3,mntn.getPeakLoc());
		
	}

	@Test
	public void testGetHeight() {
		assertEquals(6,mntn.getHeight());
	}
	
	@Test
	public void testGetHeightAtLoc()
	{
		assertEquals(6,mntn.getHeightAtLoc(3));
		assertEquals(4,mntn.getHeightAtLoc(1));
		assertEquals(3,mntn.getHeightAtLoc(6));
		assertEquals(0,mntn.getHeightAtLoc(10));
		
	}
}
