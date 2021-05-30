package processcontrolblock;

import constants.ProcessConstants;
import constants.ThreadConstants;

// Process Control Block
public class ProcessControlBlock {
	private int processId;
	private long arrivalTime;
	private long terminatedTime;
	private long threadId;
	private String threadState;
	private String processType;
	private int lightBearRequired;
	private int lightBeerConsumption;
	private int wakeCount;
	private int turnAroundTime;

	public ProcessControlBlock() {
		this.threadState = this.processType = "";
		this.arrivalTime = this.terminatedTime = this.threadId = 0;
		this.processId = this.wakeCount = this.turnAroundTime = this.lightBearRequired = this.lightBeerConsumption = 0;
	}

	public ProcessControlBlock(int processId, long arrivalTime, long terminatedTime, long threadId, String threadState,
			String processType, int lightBearRequired, int lightBeerConsumption, int wakeCount, int turnAroundTime) {
		super();
		this.processId = processId;
		this.arrivalTime = arrivalTime;
		this.terminatedTime = terminatedTime;
		this.threadId = threadId;
		this.threadState = threadState;
		this.processType = processType;
		this.lightBearRequired = lightBearRequired;
		this.lightBeerConsumption = lightBeerConsumption;
		this.wakeCount = wakeCount;
		this.turnAroundTime = turnAroundTime;
	}

	public final int getProcessId() {
		return processId;
	}

	public final void setProcessId(int processId) {
		this.processId = processId;
	}

	public final long getArrivalTime() {
		return arrivalTime;
	}

	public final void setArrivalTime(long arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public final long getTerminatedTime() {
		return terminatedTime;
	}

	public final void setTerminatedTime(long terminatedTime) {
		if (!this.threadState.equals(ThreadConstants.terminated)) {
			this.terminatedTime = terminatedTime;

			Long turnAroundTime = this.terminatedTime - this.arrivalTime;
			int seconds = turnAroundTime.intValue() / 1000;

			this.setTurnAroundTime(seconds);
		}
	}

	public final long getThreadId() {
		return threadId;
	}

	public final void setThreadId(long threadId) {
		this.threadId = threadId;
	}

	public final String getThreadState() {
		return threadState;
	}

	public final void setThreadState(String threadState) {
		this.threadState = threadState;
	}

	public final String getProcessType() {
		return processType;
	}

	public final void setProcessType(String processType) {
		this.processType = processType;
	}

	public final int getLightBearRequired() {
		return lightBearRequired;
	}

	public final void setLightBearRequired(int lightBearRequired) {
		this.lightBearRequired = lightBearRequired;
	}

	public final int getLightBeerConsumption() {
		return lightBeerConsumption;
	}

	public final void setLightBeerConsumption(int lightBeerConsumption) {
		this.lightBeerConsumption = lightBeerConsumption;
	}

	public final int getWakeCount() {
		return wakeCount;
	}

	public final void setWakeCount(int wakeCount) {
		this.wakeCount = wakeCount;
	}

	public final int getTurnAroundTime() {
		return turnAroundTime;
	}

	public final void setTurnAroundTime(int turnAroundTime) {
		this.turnAroundTime = turnAroundTime;
	}

	@Override
	public String toString() {
		return "ProcessControlBlock [processId=" + processId + ", arrivalTime=" + arrivalTime + ", threadId=" + threadId
				+ ", threadState=" + threadState + ", processType=" + this.processType
				+ (this.processType.equals(ProcessConstants.bartender) ? ""
						: ", lightBearRequired=" + this.lightBearRequired)
				+ (this.processType.equals(ProcessConstants.bartender) ? ""
						: ", lightBeerConsumption=" + this.lightBeerConsumption)
				+ (this.processType.equals(ProcessConstants.bartender) ? ", wakeCount=" + wakeCount : "")
				+ (this.threadState.equals(ThreadConstants.terminated) ? ", turnAroundTime=" + this.turnAroundTime + "]"
						: "]");
	}
}