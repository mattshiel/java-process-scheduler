package ie.gmit.sw;

import java.util.*;

public class Runner {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Please enter the amount of process to be scheduled: ");
		int numProcesses = scanner.nextInt();
		
		ArrayList<Process> processes = new ArrayList<Process>(numProcesses);
		
		System.out.println("Enter the process time and burst time for the process");

		for (int i = 0; i < numProcesses; i++) {
			System.out.print("Enter the name for process " + (i + 1) + ": ");
			String name = scanner.next();
			System.out.println("Enter the burst time for process " + (i + 1) + ": ");
			int burstTime = scanner.nextInt();
			processes.add(new Process(name, burstTime));
		}

		System.out.println("\nChoose the Scheduling Algorithm\nPress 1 for Round Robin\nPress 2 for FCFS\nPress 3 for SJF\nPress 4 to exit");
		System.out.print("Enter choice: ");
		int choice = scanner.nextInt();

		System.out.println();
	}
}
