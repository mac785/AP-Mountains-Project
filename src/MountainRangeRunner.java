
public class MountainRangeRunner {

	public static void main(String[] args) {
		
		MountainRange theRange = new MountainRange(30,30);
		
		theRange.addMountain(new Mountain(4,8));
		theRange.addMountain(new Mountain(8,10));
		theRange.addMountain(new Mountain(13,6));
		theRange.addMountain(new Mountain(20,13));
		System.out.println("Simple Map:");
		System.out.println(theRange.toString());
		
		System.out.println("Done.");
		
	}

}
