package CustomEssentials.Events.Misc;

public class TimeGenerator {
	
	public static String secondsToString(float s) {
		
		float mins = 0;
	    float hrs = 0;
	    float days = 0;
	    
	    if (s >= 60) {
	    	mins = Math.floorDiv((int) s, 60);
	    	s = (float) Math.floor(((s/60) - mins)*60);
	    }
	    if (mins >= 60) {
	    	hrs = Math.floorDiv((int) s, 60);
	    	mins = (float) Math.floor(((mins/60) - hrs)*60);
	    }
	    if (hrs >= 60) {
	    	days = Math.floorDiv((int) s, 60);
	    	hrs = (float) Math.floor(((hrs/60) - days)*60);
	    }
	    
		
		
	    return (days+"d "+ hrs+"hr "+ mins+"m "+ s+"s ");
		
	}

}
