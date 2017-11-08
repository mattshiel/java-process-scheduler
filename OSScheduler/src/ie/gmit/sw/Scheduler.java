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
	
	public static double roundRobin(List<Process> processes, int quantum) {
		
		System.out.println("Process Name \tStart Time \tWait Time");
		
		int waitTime = 0;
		int totalWait = 0;
		int burstCount = 0;
		boolean checkBurst = false;
		double waitSum = 0;
		
		
		// Loop through processes for as long as checkBurst is false
		while(checkBurst = false) {
			burstCount = 0;
			
			for (Process p : processes) {
				
				// Print values
				if (p.getBurstTime() > 0) {
					System.out.printf("%-16s%-16d%-16d", p.getName(), waitTime, waitTime - p.getWaitCount() * quantum);
				}
				
				// If the burstTime = 0 increment count
				if (p.getBurstTime() == 0) {
					burstCount++;
				} 
			
				// If all of the processes' burst times are zero change boolean to true
				if(burstCount == processes.size()) {
					checkBurst = true;
				}
				
				// If the burst time is greater than the quantum set the wait time and increment by quantum
				if(p.getBurstTime() > quantum) {
					p.setWaitTime(waitTime);
					p.incWaitCount();
					waitTime += quantum;
				} 
				
				// if the burst time is less than the quantum
				// increase the total wait time by the remaining burst time
				else if (p.getBurstTime() < quantum) {
					p.setWaitTime(waitTime);
					waitTime += p.getBurstTime();
				}
				
				// Decrease burst time by quantum
				p.decBurstTime(quantum);
					
			}
		}
		
		// Sum all the wait times
		for (Process p : processes) {
			waitSum += p.getWaitTime();
		}
		
		// Return the sum of the wait times divided by the amount of processes
		return waitSum / processes.size();
		
	}
	
}
