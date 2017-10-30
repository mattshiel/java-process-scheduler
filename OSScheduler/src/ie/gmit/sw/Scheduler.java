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
	
	/* Shortest Job First Scheduling 
	 * Ready queue is treated as a priority queue based on smallest CPU time requirement
	 * If equal time of completion, then FCFS is used for assigning priority. 
	 * Arrival time = 0
	 * Sort the processes in ascending order and return the processes through FCFS
	 */
	public static double shortestJobFirst(List<Process> processes) {
		// Provide a comparator to sort the processes in ascending order
		Collections.sort(processes, new Comparator<Process>() {
			  @Override
			  public int compare(Process p1, Process p2) {
			    return p1.getBurstTime() - p2.getBurstTime();
			  }
			});
		
		// Return the average wait (total/num of processes)
		return firstComeFirstServed(processes);
	}
	
}
