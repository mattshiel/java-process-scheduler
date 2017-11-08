package ie.gmit.sw;

public class Process {
	
	// Wait time: time for which process is ready to run but not executed by CPU scheduler
	// Burst Time: time that is required to complete execution of particular task or process.
	
	private String name;
	private int burstTime;
	private int waitTime;
	private int waitCount;

	public Process(String name, int burstTime) {
		this.name = name;
		this.burstTime = burstTime;
		this.waitTime = 0;
		this.waitCount = 0;
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
	
	public void incWaitCount() {
		waitCount++;
	}
	
	public int getWaitCount() {
		return waitCount;
	}
	
	public void decBurstTime(int change) {
		this.burstTime -= change;
		this.burstTime = this.burstTime < 0 ? 0 : this.burstTime;
	}
	
	@Override 
	public String toString() {
		return String.format("%-16s%-16d%-16d", name, burstTime, waitTime);
	}
	
}
