package CustomEssentials.Events.Misc;

public class TimeGenerator {
	
	public static String secondsToString(float s) {
		
		float mins = 0;
	    float hrs = 0;
	    float days = 0;
	    
	    if (s >= 60) {
	    	mins = Math.floorDiv((int) s, 60);
	    	s = (int) Math.floor(((s/60) - mins)*60);
	    }
	    if (mins >= 60) {
	    	hrs = Math.floorDiv((int) s, 60);
	    	mins = (int) Math.floor(((mins/60) - hrs)*60);
	    }
	    if (hrs >= 60) {
	    	days = Math.floorDiv((int) s, 60);
	    	hrs = (int) Math.floor(((hrs/60) - days)*60);
	    }
	    
		
		
	    return ((int)days+"d "+ (int)hrs+"hr "+ (int)mins+"m "+ (int)s+"s ");
		
	}

}
