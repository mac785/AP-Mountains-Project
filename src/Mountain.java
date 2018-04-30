
public class Mountain {

	private int peakLoc;
	private int height;
	
	public Mountain() 
	{
		this(0,0);
	}

	public Mountain(int loc, int hgt)
	{
		peakLoc = loc;
		height = hgt;
	}

	/**
	 * @return the peakLoc
	 */
	public int getPeakLoc() {
		return peakLoc;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}
	
	
	/**
	 * returns the height of this mountain at the given location - all mountains have slope 1,
	 * and they don't extend below sea level (0).
	 * @param loc - the horizontal position we are considering
	 * @return the altitude of the mountain at this position
	 */
	public int getHeightAtLoc(int loc)
	{
		int h = 0;
		// TODO: Insert your code here.
		if (Math.abs(peakLoc-loc)<=height){
			h = height-Math.abs(peakLoc-loc);
		}
		// ----------------------
		return h;
	}
	
}
