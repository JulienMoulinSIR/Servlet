package fr.istic.sir.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import opower.*;

@Path("/hello")
public class MyWebService {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		return "Hello, how are you?";
	}

	@GET
	@Path("/home")
	@Produces(MediaType.APPLICATION_JSON)
	public Home getHome() {
		Home home = new Home("home1",63,4);
		Device heater = new Heater();
		heater.setAverageConso(500);
		heater.setName("heater");
		Device heater2 = new Heater();
		heater2.setAverageConso(600);
		heater2.setName("heater2");
		home.addDevice(heater);
		home.addDevice(heater2);
		return home;
	}
	
}