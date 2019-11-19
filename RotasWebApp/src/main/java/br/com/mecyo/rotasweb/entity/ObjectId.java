package br.com.mecyo.rotasweb.entity;

public class ObjectId {
	protected String timestamp;
	protected long counter;
	protected String time;
	protected String date;
	protected String machineIdentifier;
	protected String processIdentifier;
	protected String timeSecond;
	/**
	 * @return the timestamp
	 */
	public String getTimestamp() {
		return timestamp;
	}
	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	/**
	 * @return the counter
	 */
	public long getCounter() {
		return counter;
	}
	/**
	 * @param counter the counter to set
	 */
	public void setCounter(long counter) {
		this.counter = counter;
	}
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the machineIdentifier
	 */
	public String getMachineIdentifier() {
		return machineIdentifier;
	}
	/**
	 * @param machineIdentifier the machineIdentifier to set
	 */
	public void setMachineIdentifier(String machineIdentifier) {
		this.machineIdentifier = machineIdentifier;
	}
	/**
	 * @return the processIdentifier
	 */
	public String getProcessIdentifier() {
		return processIdentifier;
	}
	/**
	 * @param processIdentifier the processIdentifier to set
	 */
	public void setProcessIdentifier(String processIdentifier) {
		this.processIdentifier = processIdentifier;
	}
	/**
	 * @return the timeSecond
	 */
	public String getTimeSecond() {
		return timeSecond;
	}
	/**
	 * @param timeSecond the timeSecond to set
	 */
	public void setTimeSecond(String timeSecond) {
		this.timeSecond = timeSecond;
	}
	@Override
	public String toString() {
		return "ObjectId [counter=" + counter + "]";
	}
}
