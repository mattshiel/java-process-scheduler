package ie.gmit.sw;

import java.util.*;

public class Scheduler {

	public static double firstComeFirstServed(List<Process> processes) {

		int waitTime = 0;
		double totalWait = 0;

		// Loop through list of processes
		// Set the wait time to be the sum of the process burst times as there is no arrival time
		for (Process p : processes) {
			p.setWaitTime(waitTime);
			totalWait += waitTime;
			waitTime += p.getBurstTime();
		}
		
		// Return the average wait (total/num of processes)
		return totalWait / processes.size();
	}
	
}
