package opower;

import javax.persistence.*;

@Entity
@Table(name = "Device")
public abstract class Device {

	@Id
	@GeneratedValue
	private int numDevice;
	private String name;
	private int averageConso;
	
	public Device(){
		super();
	}
	
	public Device(String name, int averageConso){
		this.name = name;
		this.averageConso = averageConso;
	}
	
	public int getNumDevice() {
		return numDevice;
	}

	public void setNumDevice(int numDevice) {
		this.numDevice = numDevice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAverageConso() {
		return averageConso;
	}

	public void setAverageConso(int averageConso) {
		this.averageConso = averageConso;
	}
	
	public String toString() {
		return "Device "+this.getClass()
				+" [num="+numDevice
				+", name="+name
				+", average consomation="+averageConso
				+"W]";
	}
}
