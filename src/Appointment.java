
public class Appointment {
	String date;
	String location;
	String persons;
	
	Appointment(){
		
	}
	
	Appointment(String date, String location, String persons){
		this.date = date;
		this.location = location;
		this.persons = persons;
	}
	
	String getDate() {
		return date;
	}
	
	void setDate(String date) {
		this.date = date;
	}
	
	String getLocation() {
		return location;
	}
	
	void setLocation(String location) {
		this.location = location;
	}
	
	String getPersons() {
		return persons;
	}
	
	void setPersons(String persons) {
		this.persons = persons;
	}

}
