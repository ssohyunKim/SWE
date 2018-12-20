import java.util.Scanner;

public class Home {

	private static int homeChoice;
	private static Scanner scanner = new Scanner(System.in);
	/*
	 * static final int CONTACT = 1; static final int TODOLIST = 2; static final int
	 * APPOINTMENT = 3; static final int QUIT = 4;
	 */
	//static Contact_Manager contactManager;
	static TodoList_Manager todolistManager;
	//static Appointment_Manager apointmentManager;
	
	public static void main(String[] args) {
		selectHomeMenu();
	}

	private static void selectHomeMenu() {
		boolean isHomeMenu = true;

		while (isHomeMenu) {
			showHomeMenu();
			homeChoice = scanner.nextInt();

			if (homeChoice == 1) {
				System.out.println("+---------------------------Contact----------------------------+");

			} else if (homeChoice == 2) {
				System.out.println("+---------------------------To-do List--------------------------+");
				todolistManager = new TodoList_Manager();
				todolistManager.manageTodoList();
			} else if (homeChoice == 3) {
				System.out.println("+------------------------Appointment-------------------------+");
			} else if (homeChoice == 4) {
				System.out.println("**********************Thank You! Bye!*************************");
				isHomeMenu = false;
			}
		}
	}

	private static void showHomeMenu() {
		System.out.println("+-------------------------Home Menu-------------------------+");
		System.out.println("||   [1] Contact    [2] To-do List    [3] Appointment    [4] Quit  ||");
		System.out.println("+----------------------------------------------------------------+");
		System.out.print("Choose Home Menu: ");
	}
}
