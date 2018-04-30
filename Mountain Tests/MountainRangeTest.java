import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MountainRangeTest {
	MountainRange range;
	
	@Before
	public void setUp() throws Exception {
		range = new MountainRange(24,10);
		range.addMountain(new Mountain(3,5));
		range.addMountain(new Mountain(9,8));
		range.addMountain(new Mountain(15,5));
	}

	@Test
	public void testGetNumMountains() {
		assertEquals(3,range.getNumMountains());
	}

	@Test
	public void testTallestMountain()
	{
		assertEquals(8,range.tallestMountain());
	}
	
	@Test
	public void testHeightAtPosition()
	{
		assertEquals(4,range.heightAtPosition(2));
		assertEquals(6,range.heightAtPosition(11));
		assertEquals(4,range.heightAtPosition(13));
		assertEquals(4,range.heightAtPosition(14));
		assertEquals(4,range.heightAtPosition(5));
		assertEquals(0,range.heightAtPosition(20));
		assertEquals(0,range.heightAtPosition(25));
	}
}
