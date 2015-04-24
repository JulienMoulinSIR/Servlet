package opower;

import javax.persistence.Entity;

@Entity
public class Heater extends Device{

	public Heater(){
		super();
	}
	
	public Heater(String name, int averageConso){
		super(name, averageConso);
	}
	
}
