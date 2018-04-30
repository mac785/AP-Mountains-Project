import java.util.ArrayList;

public class MountainRange {

	private ArrayList<Mountain>myMountains; 	// an array of mountain objects, initially all null.
	private int width; 				// the horizontal "range" of this mountain.
	private int maxHeight;			// the maximum height that this range will use when outputting a graph.
	private int numMountains; 		// how many slots in the myMountains list are actually filled with a mountain?
	
	public MountainRange()
	{
		this(15,10);
	}
	
	public MountainRange(int w, int maxH) {
		width = w;
		maxHeight = maxH;
		myMountains = new ArrayList<Mountain>();
		numMountains = 0;
	}
	
	/**
	 * adds this mountain to the list (if there is space) and increments the number of mountains;
	 * if the list is full, then the range is unchanged.
	 * @param m
	 * @return whether the mountain range was changed by this addition.
	 */
	public void addMountain(Mountain m)
	{
		// TODO: Insert your code here.
		myMountains.add(m);
		// ---------------------------
	}
	/**
	 * Returns the number of mountains in this range.
	 * @return
	 */
	public int getNumMountains()
	{
		return myMountains.size();
	}

	/**
	 * Gets the height of the range of mountains at the given horizontal position - this is the highest
	 * mountain point at this location. Points outside the possible range of horizontal positions will return
	 * zero height.
	 * @param pos - the horizontal location of this mountain
	 * @return height - how high the mountain range is at this horizontal location.
	 */
	public int heightAtPosition(int pos)
	{
		int height = 0;
		// TODO: Insert your code here.
		for (int i=0; i<myMountains.size();i++){
			if (myMountains.get(i).getHeightAtLoc(pos)>height){
				height = myMountains.get(i).getHeightAtLoc(pos);
			}
		}
		// ---------------------------
		return height;
	}
	
	/**
	 * returns the height of the tallest mountain in this mountain range. 
	 * If there are no mountains, returns zero.
	 * @return
	 */
	public int tallestMountain()
	{
		int tallest = 0;
		// TODO: Insert your code here.
		int tallestForLoop = 0;
		for (int i=1;i<myMountains.size();i++){
			if (myMountains.get(i).getHeight()>myMountains.get(tallestForLoop).getHeight()){
				
				tallestForLoop = i;
				tallest = myMountains.get(i).getHeight();
			}
		}
		// ---------------------------
		return tallest;
	}
	
	/**
	 * Imagine a person walking from x = start to x = stop (inclusive). 
	 * What is the difference between the highest point in this range and 
	 * the lowest point?
	 * @param start
	 * @param stop
	 * @return variance - the largest amount of altitude difference along this range.
	 */
	
	public int altitudeVariance(int start, int stop)
	{
		int variance = 0;
		// TODO: Insert your code here.
		variance = Math.abs(heightAtPosition(start)-heightAtPosition(stop));
		// ----------------------------
		return variance;
		
	}
	
	//My Mountain Climber Test
	public int climberTest(){
		int highest = 0;
		for (int i=0; i<width/2;i++){
			int location = (int)(Math.random()*width);
			if ((altitudeVariance(location-1,location+1)==0)&&(heightAtPosition(location)>heightAtPosition(location-1))&&(heightAtPosition(highest)<heightAtPosition(location))){
				highest = location;
			}
			else if (heightAtPosition(location)<heightAtPosition(location+1)){
				
			}
		}
		return highest;
	}
	
	/**
	 * returns a string describing this mountain range with spaces and asterisks, separating lines with \n characters.
	 * For example, this might be something like:
	 * |     *      \n
	 * |    * *     \n
	 * | * *   *    \n
	 * |* *     *   \n
	 * |         ***\n
	 * +------------\n
	 * @return - a string showing the shape of this range.
	 */
	public String simpleMap()
	{
		String output = "";
		// TODO: Insert your code here.
		for(int i=tallestMountain();i>0;i--){
			for (int x=0; x<width;x++){
				if (heightAtPosition(x)==i){
					output += "*";
				}
				else if ((heightAtPosition(x)==i)&&(altitudeVariance(x,x-1)==0)){
					output += "*";
				}
				else{
					output += " ";
				}
			}
			output += "\n";
		}
		// ---------------------------		
		return output;
	}
	/** OPTIONAL
	 * returns a string describing this mountain with a combination of {" ", "\", "/", "V", "A", "-"}, 
	 * separating lines with \n characters. The choice of characters would indicate something about the
	 * slope of the mountain range at each point.
	 * For example, this might be something like:
	 * |     A      \n
	 * |    / \     \n
	 * | A /   \    \n
	 * |/ V     \   \n
	 * |         \--\n
	 * +------------\n
	 * Note: this requires that you consider the heights before and after each point. You may consider
	 * heights of the points before and after the Mountain Range to be zero.
	 * @return - a string showing the shape of this range.
	 */
	public String slopeMap() // OPTIONAL
	{
		String output = "";
		// TODO: Insert your code here.
		for(int i=tallestMountain();i>0;i--){
			for (int x=0; x<width;x++){
				if ((heightAtPosition(x)==i)&&(heightAtPosition(x)>heightAtPosition(x-1))&&(altitudeVariance(x-1,x+1)==0))
					output += "A";
				else if ((heightAtPosition(x)==i)&&(heightAtPosition(x)<heightAtPosition(x-1))&&(altitudeVariance(x-1,x+1)==0))
					output += "V";
				else if ((heightAtPosition(x)==i)&&(altitudeVariance(x-1,x+1)==2) && (heightAtPosition(x)>heightAtPosition(x-1)))
					output += "/";
				else if ((heightAtPosition(x)==i)&&(altitudeVariance(x-1,x+1)==2) && (heightAtPosition(x)<heightAtPosition(x-1)))
					output += "\\";
				else if ((heightAtPosition(x)==i)&&(altitudeVariance(x,x+1)==1)&&(altitudeVariance(x,x-1)==0))
					output += "/";
				else if ((heightAtPosition(x)==i)&&(altitudeVariance(x,x-1)==1)&&(altitudeVariance(x,x+1)==0)&&(heightAtPosition(x-1)<heightAtPosition(x)))
					output += "A";
				else if ((heightAtPosition(x)==i)&&(altitudeVariance(x,x+1)==1))
					output += "/";
				else if ((heightAtPosition(x)==i)&&(altitudeVariance(x,x-1)==1)&&(heightAtPosition(x)<heightAtPosition(x+1)))
					output += "V";
				else if ((heightAtPosition(x)==i)&&(altitudeVariance(x,x-1)==1))
					output += "\\";
				else
					output += " ";
			}
			output += "\n";
		}
		// ---------------------------		
		return output;
	}
	
	public String toString()
	{
		//if you have written slopeMap, activate that code, instead.
		return slopeMap();
		//return slopeMap();
	}
}
