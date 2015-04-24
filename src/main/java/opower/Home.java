package opower;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Home")
public class Home {

	@Id
	@GeneratedValue
	private int numHome;
	private String name;
	private int size;
	private int nbParts;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="numHome")
	private List<Device> devices;
	
	public Home(){
		super();
		devices = new ArrayList<Device>();
	}
	
	public Home(String name, int size, int nbParts){
		this.name = name;
		this.size = size;
		this.nbParts = nbParts;
		devices = new ArrayList<Device>();
	}
	
	public int getNumHome() {
		return numHome;
	}

	public void setNumHome(int numHome) {
		this.numHome = numHome;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getNbParts() {
		return nbParts;
	}

	public void setNbParts(int nbParts) {
		this.nbParts = nbParts;
	}

	public List<Device> getDevices() {
		return devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}
	
	public boolean removeDevice(Device device) {
		return devices.remove(device);
	}

	public void addDevice(Device device) {
		devices.add(device);
	}
	
	@Override
	public String toString() {
		String devicesToStr = "";
		for(Device device : devices){
			devicesToStr += device.toString();
		}
		return	"Home [num="+numHome
					+", size="+size
					+", nbParts="+nbParts
					+", devices="+devicesToStr
					+"]";
	}

}
