import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
				String new_date = "";
				String new_location = "";
				String new_persons = "";
				try {
					appointment = appointments.get(updateNumber - 1);
					String pre_date = ((Appointment) appointment).getDate();
					String pre_location = ((Appointment) appointment).getLocation();
					String pre_people = ((Appointment) appointment).getPersons();

					System.out.println("Date: " + pre_date);
					System.out.println("Location: " + pre_location);
					System.out.println("People: " + pre_people);
					System.out.println();
					System.out.print("Date(yy-mm-dd): ");
					new_date = scanner.nextLine();

					System.out.print("Location: ");
					new_location = scanner.nextLine();

					System.out.print("People: ");
					new_persons = scanner.nextLine();
				} catch (Exception ex) {
					appointment = null;
				} finally {
					update(appointment, new_date, new_location, new_persons);
				}
				break;
			case DELETE:
				System.out.print("Number to delete: ");
				int deleteNumber = scanner.nextInt();
				scanner.nextLine();
				delete(deleteNumber);
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
		try {
			DateFormat date_format = new SimpleDateFormat("yy-MM-dd");
			date_format.setLenient(false);
			date_format.parse(date);
		} catch (ParseException e) {
			System.out.println("Date Format Error!! (yy-mm-dd)");
			return false;
		}
		
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
		if(appointment == null) {
			System.out.println("Don't exist!!");
			return false;
		}
		
		try {
			DateFormat date_format = new SimpleDateFormat("yy-MM-dd");
			date_format.setLenient(false);
			date_format.parse(new_date);
		} catch (ParseException e) {
			System.out.println("Date Format Error!! (yy-mm-dd)");
			return false;
		}
		
		((Appointment)appointment).setDate(new_date);
		((Appointment)appointment).setLocation(new_location);	
		((Appointment)appointment).setPersons(new_persons);
		System.out.println("Successfully Update!!");
		return true;
	}

	@Override
	boolean delete(int delete_no) {
		if(delete_no <=0 || delete_no > appointments.size()) {
			System.out.println("Don't exist!!");
			return false;
		}
		Appointment appointment = appointments.get(delete_no - 1);
		appointments.remove(appointment);
		System.out.println("Successfully deleted!!");
		return true;
	}

	@Override
	void goHome() {
		System.out.println("Go HomeMenu");
	}



}

