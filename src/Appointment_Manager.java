import java.util.ArrayList;
import java.util.Scanner;

public class Appointment_Manager extends Asset_Manager{
	static final int CREATE = 1;
	static final int VIEW = 2;
	static final int UPDATE = 3;
	static final int DELETE = 4;
	static final int GOHOME = 5;
	private Scanner scanner = new Scanner(System.in);
	ArrayList<Appointment> appointments = new ArrayList<Appointment>();
	
	void selectSubMenu() {
		int submenuChoice = 0;
		while (submenuChoice != 5) {
			System.out.print("Choose Sub Menu: ");
			submenuChoice = scanner.nextInt();
			scanner.nextLine();
			Appointment appointment = new Appointment();
			
			switch (submenuChoice) {
			case CREATE:
				System.out.print("Date(yy-mm-dd): ");
				String date = scanner.nextLine();
				System.out.print("Location: ");
				String location = scanner.nextLine();
				System.out.print("People: ");
				String persons = scanner.nextLine();
				create(date,location,persons);
				break;
			case VIEW:
				view();
				break;
			case UPDATE:
				System.out.print("Number to Update: ");
				int updateNumber = scanner.nextInt();
				scanner.nextLine();
				if(updateNumber <= 0 && updateNumber > appointments.size())
					break;
				appointment = appointments.get(updateNumber - 1);
				String pre_date = ((Appointment)appointment).getDate();
				String pre_location = ((Appointment)appointment).getLocation();
				String pre_people = ((Appointment)appointment).getPersons();
				
				System.out.println("Date: " + pre_date);
				System.out.println("Location: " + pre_location);
				System.out.println("People: " + pre_people);
				System.out.println();
				System.out.print("Date(yy-mm-dd): ");
				String new_date = scanner.nextLine();

				System.out.print("Location: ");
				String new_location = scanner.nextLine();
				
				System.out.print("People: ");
				String new_persons = scanner.nextLine();
				
				update(appointment, new_date, new_location, new_persons);
				break;
			case DELETE:
				System.out.print("Number to delete: ");
				int deleteNumber = scanner.nextInt();
				scanner.nextLine();
				if(deleteNumber <= 0 && deleteNumber > appointments.size())
					break;
				appointment = appointments.get(deleteNumber - 1);
				delete(appointment);
				break;
			case GOHOME:
				goHome();
				break;
			default:
				System.out.println("Choose valid sub menu!");
				break;
			}
			
			if (submenuChoice != GOHOME)
				showSubMenu();
		}
	}
	
	@Override
	boolean create(String date, String location, String persons) {
		Appointment appointment = new Appointment();
		appointment.setDate(date);	
		appointment.setLocation(location);	
		appointment.setPersons(persons);
		appointments.add(appointment);
		System.out.println("Successfully Created!!");
		return true;
	}

	@Override
	void view() {
		System.out.println();
		int apointment_no = 1;
		for(Appointment appointment: appointments) {
			String date = appointment.getDate();
			String location = appointment.getLocation();
			String people = appointment.getPersons();
			
			System.out.println("Appointment " + apointment_no);
			System.out.println("Date: " + date);
			System.out.println("Location: " + location);
			System.out.println("People: " + people);
			System.out.println();
			
			apointment_no++;
		}
		
	}

	@Override
	boolean update(Object appointment, String new_date, String new_location, String new_persons) {
		((Appointment)appointment).setDate(new_date);
		((Appointment)appointment).setLocation(new_location);	
		((Appointment)appointment).setPersons(new_persons);
		System.out.println("Successfully Update!!");
		return false;
	}

	@Override
	boolean delete(Object appointment) {
		appointments.remove(appointment);
		System.out.println("Successfully deleted!!");
		return false;
	}

	@Override
	void goHome() {
		System.out.println("Go HomeMenu");
	}



}