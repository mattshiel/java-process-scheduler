package ie.gmit.sw;

public class Process {
	
	// Wait time: time for which process is ready to run but not executed by CPU scheduler
	// Burst Time: time that is required to complete execution of particular task or process.
	
	private String name;
	private int burstTime;
	private int waitTime;

	public Process(String name, int burstTime) {
		this.name = name;
		this.burstTime = burstTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBurstTime() {
		return burstTime;
	}

	public void setBurstTime(int burstTime) {
		this.burstTime = burstTime;
	}
	
	public int getWaitTime() {
		return waitTime;
	}

	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	}
	
	@Override 
	public String toString() {
		return String.format("%-16s%-16d%-16d", name, burstTime, waitTime);
	}
	
}
