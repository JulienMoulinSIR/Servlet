package opower;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Person")
public class Person {
	
	@Id
	@GeneratedValue
	private int numPerson;
	private String name;
	private String firstName;
	private char genre; // m -> man, w -> woman
	private String mail;
	private Date birthDay;
	@ManyToMany
	@JoinTable(name = "Friends",
		joinColumns = @JoinColumn(name = "PERSON1", referencedColumnName = "numPerson"), 
		inverseJoinColumns = @JoinColumn(name = "PERSON2", referencedColumnName = "numPerson")
	)
	private List<Person> friends;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="numPerson")
	private List<Home> homes;
	
	public Person(){
		super();
		friends = new ArrayList<Person>();
		homes = new ArrayList<Home>();
	}
	
	public Person(String name, String firstName, char genre, String mail, String birthDay){ // Date format "dd-MM-yyyy"
		this.name = name;
		this.firstName = firstName;
		this.genre = genre;
		this.mail = mail;
		birthDay = checkBirthDay(birthDay);
		try {
			this.birthDay = new SimpleDateFormat("dd-MM-yyyy").parse(birthDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		friends = new ArrayList<Person>();
		homes = new ArrayList<Home>();
	}
	
	public String checkBirthDay(String birthDay){
		String[] parts = birthDay.split("-");
		if(parts[0].length() == 4){
			birthDay = parts[2]+"-"+parts[1]+"-"+parts[0];
		}
		return birthDay;
	}
	
	public int getNumPerson() {
		return numPerson;
	}

	public void setNumPerson(int numPerson) {
		this.numPerson = numPerson;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public char isGenre() {
		return genre;
	}

	public void setGenre(char genre) {
		this.genre = genre;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Temporal(TemporalType.DATE)
	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	
	public void setBirthDay(String birthDay) {
		birthDay = checkBirthDay(birthDay);
		try {
			this.birthDay = new SimpleDateFormat("dd-MM-yyyy").parse(birthDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public List<Person> getFriends() {
		return friends;
	}

	public void setFriends(List<Person> friends) {
		this.friends = friends;
	}
	
	public boolean removeFriend(Person friend) {
		return friends.remove(friend);
	}

	//If we p1 is friendly with p2 then p2 
	public void addFriend(Person friend) {
		friends.add(friend);
		if(!friend.alreadyFriend(this)){
			friend.addFriend(this);
		}
	}

	public boolean alreadyFriend(Person friend) {
		return friends.contains(friend);
	}
	
	public Person getFriend(int index) {
		return friends.get(index);
	}

	public List<Home> getHomes() {
		return homes;
	}

	public void setHomes(List<Home> homes) {
		this.homes = homes;
	}
	
	public boolean removeHome(Home home) {
		return homes.remove(home);
	}

	public void addHome(Home home) {
		homes.add(home);
	}
	
	@Override
	public String toString() {
		String personToStr = "";
		for(Person person : friends){
			personToStr += person.toString2();
		}
		String homeToStr = "";
		for(Home home : homes){
			homeToStr += home.toString();
		}
		return	"Person [num="+numPerson
						+", name="+name
						+", firstName="+firstName
						+", genre="+genre
						+", mail="+mail
						+", friends="+personToStr
						+", homes="+homeToStr
						+", birthDay="+birthDay
						+"]";
	}
	
	public String toString2() {
		return	"Person [num="+numPerson
						+", name="+name
						+", firstName="+firstName
						+", genre="+genre
						+", mail="+mail
						+", birthDay="+birthDay.toString()
						+"]";
	}

}
