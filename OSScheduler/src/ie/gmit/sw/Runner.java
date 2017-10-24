package ie.gmit.sw;

import java.util.*;

public class Runner {
	public static void main(String[] args) {
		
		// Scanner to take user input
		Scanner scanner = new Scanner(System.in);
		
		// Average wait time of the process
		int avgWaitTime = 0;
		
		//
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
		
		System.out.println();
		System.out.println("===============================");
		System.out.println("Choose the Scheduling Algorithm\n1. Round Robin\n2. FCFS\n3. SJF\n4. Exit");
		System.out.println("===============================");

		System.out.print("Enter choice: ");
		int choice = scanner.nextInt();
		
		switch(choice) {
			case 1:
				//System.out.print("Please enter a quantum: ");
				//int quantum = scanner.nextInt();
				//avgWaitTime = Scheduler.roundRobin(processes, quantum);
				break;
			case 2:
				//avgWaitTime = Scheduler.firstComeFirstServe(processes);
				break;
			case 3:
				//avgWaitTime = Scheduler.shortestJobFirst(processes);
				break;
				
			case 4:
				System.out.println("Program closing.....");
				System.out.println("Program closed");
				break;

			default:
				System.out.println("Invalid input, please enter 1, 2 ,3 or 4!");
				break;
		}
		System.out.println();
		scanner.close();
		System.out.println("Average Wait Time: " + avgWaitTime);
	}
}
