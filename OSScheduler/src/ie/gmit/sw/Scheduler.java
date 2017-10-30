package ie.gmit.sw;

import java.util.*;

public class Scheduler {

	public static double firstComeFirstServed(List<Process> processes) {

		int waitTime = 0;
		double totalWait = 0;	
		
		// Header for FCFS
		System.out.println("Process Name \tBurst Time \tWait Time");

		// Loop through list of processes
		// Set the wait time to be the sum of the process burst times as there is no arrival time
		for (Process p : processes) {
			p.setWaitTime(waitTime);
			waitTime += p.getBurstTime();
			System.out.println(p);
			// Sum wait times of each process to get the total wait time
			totalWait += p.getWaitTime();
		}
		
		// Return the average wait (total/num of processes)
		return totalWait / processes.size();
	}
	
}
